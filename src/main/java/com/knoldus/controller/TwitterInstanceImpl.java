package com.knoldus.controller;

import com.knoldus.service.TwitterInstance;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterInstanceImpl implements TwitterInstance {
    @Override
    public Twitter getTwitterInstance() {
        Config configFactory = ConfigFactory.load();
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(configFactory.getString("consumer.key"))
                .setOAuthConsumerSecret(configFactory.getString("consumer.secret"))
                .setOAuthAccessToken(configFactory.getString("token.key"))
                .setOAuthAccessTokenSecret(configFactory.getString("token.secret"));
        return new TwitterFactory(configurationBuilder.build()).getInstance();

    }
}
