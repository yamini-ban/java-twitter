package com.knoldus.controller;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TwitterOps {

    CompletableFuture<List<Status>> listOfTweets;

    public TwitterOps(TwitterInstanceImpl twitterInstance) {
        try {
            this.listOfTweets = CompletableFuture.supplyAsync(() -> {
                try {
                    twitterInstance.getTwitterInstance().getHomeTimeline();
                } catch (TwitterException te) {
                    CompletableFuture.runAsync(() -> Collections.emptyList());
                }
            });
        }
        catch (TwitterException e) {

        }
    }
}
