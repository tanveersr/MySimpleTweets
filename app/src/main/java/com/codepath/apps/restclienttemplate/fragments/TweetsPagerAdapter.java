package com.codepath.apps.restclienttemplate.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by trandhawa on 10/8/17.
 */

public class TweetsPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] {"Home", "Mentions"};
    private Context context;

    public TweetsPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context=context;
    }

    // return the total number of fragments
    @Override
    public int getCount() {
        return 2;
    }

    // return the fragment to use depending upon the position
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new HomeTimelineFragment();
        } else {
            return new MentionsTimelineFragment();
        }
    }

    // return title
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }

}
