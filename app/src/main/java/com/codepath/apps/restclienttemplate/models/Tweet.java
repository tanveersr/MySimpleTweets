package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by trandhawa on 10/1/17.
 */

public class Tweet {

    // list out the attributes
    public String body;
    public Long uid;
    public User user;
    public String createdAt;

    // de-serialize the data
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {

        Tweet tweet = new Tweet();

        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

}
