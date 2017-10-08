package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.fragments.TweetsListFragment;
import com.codepath.apps.restclienttemplate.fragments.TweetsPagerAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // get the view pager
        ViewPager vPager = (ViewPager) findViewById(R.id.viewpager);

        // set the adapter for the pager
        vPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager(), this));

        // set up the tablayout to use the view pager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vPager);
    }




    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

//    public void newTweet(MenuItem item) {
//        Intent newTweetIntent = new Intent(this, NewTweetActivity.class);
//        startActivityForResult(newTweetIntent, NEW_TWEET_REQUEST);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // Check which request we're responding to
//        if (requestCode == NEW_TWEET_REQUEST) {
//            // Make sure the request was successful
//            if (resultCode == RESULT_OK) {
//                Log.d("Response : ", data.getExtras().getString("result"));
//                try {
//                    Tweet newTweet = Tweet.fromJson(new JSONObject(data.getExtras().getString("result")));
//                    tweets.add(newTweet);
//                    Collections.sort(tweets);
//                    tweetAdapter.notifyDataSetChanged();
////                    tweetAdapter.notifyItemRangeChanged(0, tweets.size());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
