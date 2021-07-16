package com.example.myapplicationiterabledemoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.iterable.iterableapi.IterableApi;


import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {


    JSONObject user = new JSONObject();
    JSONObject dataFields = new JSONObject();
    JSONObject events = new JSONObject();
    final String EMAIL = "grady.gene.thomas@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IterableApi.getInstance().setEmail(EMAIL);
        Button one = (Button) findViewById(R.id.button_1);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.button_2);
        two.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_1:
                // code for button when user clicks buttonOne.
                try {
                    user.put("firstName", "Gene");
                    user.put("isRegisteredUser", true);
                    user.put("SA_User_Test_Key", "completed");
                    //datafields.put("dataFields", user);
                } catch (JSONException e) {
                    e.printStackTrace();

                }
                IterableApi.getInstance().updateUser(user);
                Log.i("Info", "Button Pressed");
                break;

            case R.id.button_2:
                try {
                    events.put("platform", "Android");
                    events.put("isTestEvent", true);
                    events.put("url", "https://iterable.com/sa-test/Gene");
                    events.put("secret_code_key", "Code_123");
                   // dataFields.put("dataFields", events);
                } catch (JSONException e) {
                    e.printStackTrace();

                }
                IterableApi.getInstance().track(
                        "mobileSATestEvent",
                        events
                );
                Log.i("Info", "Button 2 Pressed");
                break;

                default:
                    break;

    }

    }
}




