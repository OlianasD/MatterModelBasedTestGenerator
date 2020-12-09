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

public class RetrieveParkTask extends AsyncTask<String, String, JSONArray> {
    private MainActivity parent;
    private JSONArray resObj;

    public RetrieveParkTask(MainActivity parent) {
        this.parent = parent;
    }


    @Override
    protected JSONArray doInBackground(String... strings) {
        HttpURLConnection conn = null;
        byte[] data = strings[1].getBytes();
        try {
            //Preparing request
            URL url = new URL(strings[0] + "/smartparking/req");
            Log.d("RetrieveParkTask", "URL is: "+url.toString());
            conn = (HttpURLConnection) url
                    .openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setChunkedStreamingMode(data.length);
            conn.connect();

            //Sending request
            Log.d("RetrieveParkTask", "Length set");
            BufferedOutputStream output = new BufferedOutputStream(conn.getOutputStream());
            Log.d("RetrieveParkTask", "got output stream");
            Log.d("RetrieveParkTask", "Sending: "+strings[1]);
            output.write(data);
            output.flush();
            Log.d("RetrieveParkTask", "request sent");

            //Receiving response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Log.d("RetrieveParkTask", "got input stream");
            String strRes=in.readLine();
            resObj = new JSONArray(strRes);
            Log.d("RetrieveParkTask", "returning");
            return resObj;

        } catch (Exception e) {
            Log.d("RetrieveParkTask", "Connection error: "+e.getMessage());
        }
        finally {
            conn.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONArray res) {
        Log.d("RetrieveParkTask", "onPostExecute");
        parent.retrieveParkCallback(res);
    }

}
