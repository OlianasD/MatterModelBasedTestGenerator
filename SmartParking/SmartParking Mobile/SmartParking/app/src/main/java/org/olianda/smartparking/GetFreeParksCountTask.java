package org.olianda.smartparking;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetFreeParksCountTask extends AsyncTask<String, String, Integer> {
    private MainActivity parent;
    private JSONObject resObj;

    public GetFreeParksCountTask(MainActivity parent) {
        this.parent = parent;
    }


    @Override
    protected Integer doInBackground(String... strings) {
        HttpURLConnection conn = null;
        byte[] data = strings[1].getBytes();
        try {
            //Preparing request
            URL url = new URL(strings[0] + "/smartparking/count");
            Log.d("GetFreeParksCountTask", "URL is: "+url.toString());
            conn = (HttpURLConnection) url
                    .openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setChunkedStreamingMode(data.length);
            conn.connect();

            //Sending request
            Log.d("GetFreeParksCountTask", "Length set");
            BufferedOutputStream output = new BufferedOutputStream(conn.getOutputStream());
            Log.d("GetFreeParksCountTask", "got output stream");
            Log.d("GetFreeParksCountTask", "Sending: "+strings[1]);
            output.write(data);
            output.flush();
            Log.d("GetFreeParksCountTask", "request sent");

            //Receiving response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Log.d("GetFreeParksCountTask", "got input stream");
            String strRes=in.readLine();
            resObj = new JSONArray(strRes).getJSONObject(0);
            Log.d("GetFreeParksCountTask", "returning");
            return resObj.optInt("numparks");

        } catch (Exception e) {
            Log.d("GetFreeParksCountTask", "Connection error: "+e.getMessage());
        }
        finally {
            conn.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Integer res) {
        Log.d("GetFreeParksCountTask", "onPostExecute");
        parent.getFreeParkCountCallback(res);
    }

}
