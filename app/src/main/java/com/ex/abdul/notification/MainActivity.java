package com.ex.abdul.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    EditText passwordInput;
    TextView AbdulText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput=(EditText)findViewById(R.id.userNameInput);
        passwordInput=(EditText)findViewById(R.id.PasswordInput);
        AbdulText=(TextView)findViewById(R.id.abdulTextView);

    }
    public void saveInfo(View view)
    {
        SharedPreferences sharedPref= getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("userName",userInput.getText().toString());
        editor.putString("password",passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();




    }
    public void displayInfo(View view)
    {
        SharedPreferences sharedPref= getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name=sharedPref.getString("userName", "");
        String pw=sharedPref.getString("password", "");
        AbdulText.setText(name+ "  " +pw);


    }


}
