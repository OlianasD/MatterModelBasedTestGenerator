package org.olianda.smartparking;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;
import org.olianda.smartparking.LoginActivity;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginPostTask extends AsyncTask<String, Void, JSONObject> {

    private String error;
    private JSONObject resObj;
    private LoginActivity parent;

    public LoginPostTask(LoginActivity parent) {
        this.parent=parent;
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        HttpURLConnection conn = null;
        byte[] data = params[1].getBytes();
        try {
            //Preparing request
            URL url = new URL(params[0] + "/smartparking/login");
            Log.d("login", "URL is: "+url.toString());
            conn = (HttpURLConnection) url
                    .openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setChunkedStreamingMode(data.length);

            //Sending request
            Log.d("login", "Length set");
            BufferedOutputStream output = new BufferedOutputStream(conn.getOutputStream());
            Log.d("login", "got output stream");
            Log.d("login", "Sending: "+params[1]);
            output.write(data);
            output.flush();
            Log.d("login", "request sent");

            //Receiving response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String strRes=in.readLine();
            resObj = new JSONObject(strRes);
            return resObj;

        } catch (Exception e) {
            Log.d("onCompleted", "Login exception: "+e.getClass());
        }
        finally {
            conn.disconnect();
        }
        return null;
    }


    @Override
    protected void onPostExecute(JSONObject res) {
        parent.loginCallback(res);
    }
}