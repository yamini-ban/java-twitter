package com.knoldus;

import com.knoldus.controller.TwitterInstanceImpl;
import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;

import java.util.Arrays;
import java.util.List;

public class AppDriver {

    public static void main(String[] args) {
        Twitter t = (new TwitterInstanceImpl()).getTwitterInstance();
        try {

            List<Status> listOfTweets = t.getUserTimeline();// t.search(new Query("meToo")).getTweets();
            Thread.sleep(5*1000);
            System.out.println(listOfTweets);
        }
        catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

}
