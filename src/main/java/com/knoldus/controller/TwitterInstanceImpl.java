package com.knoldus.controller;

import com.knoldus.service.TwitterInstance;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterInstanceImpl implements TwitterInstance {
    private static AccessToken loadAccessToken() {
        String token = System.getenv("TOKEN_KEY");
        String tokenSecret = System.getenv("TOKEN_SECRET");
        return new AccessToken(token, tokenSecret);
    }

    @Override
    public Twitter getTwitterInstance() {
        String consumerKey = System.getenv("CONSUMER_KEY");
        String consumerSecret = System.getenv("CONSUMER_SECRET");
        Twitter instance = new TwitterFactory().getInstance();
        instance.setOAuthConsumer(consumerKey, consumerSecret);
        instance.setOAuthAccessToken(loadAccessToken());
        return instance;

    }
}
