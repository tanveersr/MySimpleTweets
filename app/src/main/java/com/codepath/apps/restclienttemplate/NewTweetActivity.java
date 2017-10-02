package com.codepath.apps.restclienttemplate;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class NewTweetActivity extends AppCompatActivity {

    EditText etNewTweet;
    Button btnTweet;
    TwitterClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tweet);
        client = TwitterApp.getRestClient();
        etNewTweet = (EditText) findViewById(R.id.etNewTweet);
        btnTweet = (Button) findViewById(R.id.btnTweet);

        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                client.postTweet(new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result",response.toString());
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result",response.toString());
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        Log.d("Tweet error: ", errorResponse.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                        Log.d("Tweet error: ", errorResponse.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("Tweet error: ", responseString.toString());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        super.onSuccess(statusCode, headers, responseString);
                    }
                }, etNewTweet.getText().toString());

            }
        });
    }
}
