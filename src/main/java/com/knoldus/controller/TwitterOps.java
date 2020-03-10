package com.knoldus.controller;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TwitterOps {

    List<Status> listOfTweets;
    int limit = 100;


    public TwitterOps(TwitterInstanceImpl twitterInstance, String searchBy, int limit) {
        try {
            Query query = new Query(searchBy);
            query.setCount(limit);
            listOfTweets = twitterInstance.getTwitterInstance().search(query).getTweets();
            this.limit = listOfTweets.size();
        } catch (TwitterException e) {
            System.out.println(e.getMessage());
            listOfTweets = Collections.emptyList();
        }
    }

    public TwitterOps(TwitterInstanceImpl twitterInstance, String searchBy) {
        try {
            Query query = new Query(searchBy);
            query.setCount(this.limit);
            listOfTweets = twitterInstance.getTwitterInstance().search(query).getTweets();
            this.limit = listOfTweets.size();
        } catch (TwitterException e) {
            System.out.println(e.getMessage());
            listOfTweets = Collections.emptyList();
        }
    }

    public List<Status> getListOfTweets() {
        return listOfTweets;
    }

    public List<Status> getTweetsWithLimit(int limit) {
        if (limit <= this.limit) {
            List<Status> tempList = listOfTweets;
            Collections.sort(tempList, Collections.reverseOrder());
            return tempList.subList(0, limit);
        } else {
            return Collections.emptyList();
        }
    }

    public List<Status> getTweetsSortedInOldestFirst() {
        List<Status> tempList = listOfTweets;
        Collections.sort(tempList);
        return tempList;
    }

    public List<Status> getListOfRetweetsInAscending() {
        return listOfTweets
                .stream()
                .sorted(Comparator.comparing(Status::getRetweetCount).reversed())
                .collect(Collectors.toList());
    }

    public List<Status> getListOfLikesInAscending() {
        return listOfTweets
                .stream()
                .sorted(Comparator.comparing(Status::getFavoriteCount).reversed()).collect(Collectors.toList());
    }

    public List<Status> getTweetsFromGivenDate(LocalDate date) {

        return listOfTweets
                .stream()
                .filter(status -> status
                        .getCreatedAt()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .equals(date))
                .collect(Collectors.toList());

    }
}
