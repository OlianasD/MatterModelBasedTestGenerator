package org.olianda.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Button loginBtn;
    private TextView loginErrorArea;
    private String HOST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        HOST = getString(R.string.host);
        username = (TextView) findViewById(R.id.usernameArea);
        password = (TextView) findViewById(R.id.passwordArea);
        loginErrorArea = findViewById(R.id.loginErrorArea);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
            }
        });
    }

    public void doLogin() {
        String usr = username.getText().toString();
        String psw = password.getText().toString();
        String msg = null;
        if(usr.isEmpty() || psw.isEmpty()) {
            loginErrorArea.setText("Username and password cannot be empty.");
        }
        else {
            msg = "{\"user\" : \""+usr+"\", \"psw\" : \""+psw+"\"}";
            new LoginPostTask(this).execute(HOST, msg);
        }
    }

    public void loginCallback(JSONObject res) {
        if(res.optBoolean("LoginResult")) {
            Intent in = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(in);
            finish();
        } else {
            loginErrorArea.setText("Login failed.");
        }
    }
}