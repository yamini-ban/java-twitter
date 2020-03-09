package com.knoldus.controller;

import com.knoldus.service.TwitterInstance;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterInstanceImpl implements TwitterInstance {
    private static AccessToken loadAccessToken(){
        String token = "160922224-AKOoOasbqi3huqT7uyq4Og0Oqlucn8rKeD9IcUvU";
        String tokenSecret = "7HgIJUmjOX2AZThvVp7RPWsZwOrW1ffpvkEpjeBSQynnH";
        return new AccessToken(token, tokenSecret);
    }
    @Override
    public Twitter getTwitterInstance() {
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true)
//        .setOAuthConsumerKey(getResources().getString(consumer.key));
//        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter instance = new TwitterFactory().getInstance();
        instance.setOAuthConsumer("e6uS4phTxImI68qlA6h4V3zwR", "M8b4Q3sudgU9mNZgJx1onUlqQYi5h5YCK1GVacjAc8yHDAohFc");
        instance.setOAuthAccessToken(loadAccessToken());
        return instance;
    }
}
