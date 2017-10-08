package com.codepath.apps.restclienttemplate.models;

import java.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.format.DateUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created by trandhawa on 10/1/17.
 */

public class Tweet implements Comparable<Tweet> {

    // list out the attributes
    public String body;
    public Long uid;
    public User user;
    public String createdAt;
    public String relativeTime;

    // de-serialize the data
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException  {

        Tweet tweet = new Tweet();

        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.relativeTime = getRelativeTimeAgo(jsonObject.getString("created_at"));
        return tweet;
    }

    // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
    public static String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);
        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }

    public long getRelativeTimeInSeconds(String rTime) {

        long res;
        String[] relTimeStrArr = rTime.split("\\s+");
        int num;
        String unit;
        try{
            num = Integer.parseInt(relTimeStrArr[0]);
            unit = relTimeStrArr[1];
        } catch(Exception e){
            return 0;
        }

        switch(unit) {
            case "minutes":
                res = num * 60;
                break;

            case "minute":
                res = 60;
                break;

            case "hours":
                res = num * 3600;
                break;

            case "hour":
                res = 3600;
                break;

            default:
                res=0;
                break;
        }

        return res;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public int compareTo(Tweet t)
    {
        return Long.compare(getRelativeTimeInSeconds(this.relativeTime), getRelativeTimeInSeconds(t.relativeTime));
    }

}
