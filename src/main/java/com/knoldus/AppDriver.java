package com.knoldus;

import com.knoldus.controller.TwitterInstanceImpl;
import com.knoldus.controller.TwitterOps;
import twitter4j.Status;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AppDriver {

    public static void main(String[] args) {
        TwitterOps ops = new TwitterOps(new TwitterInstanceImpl(), "#dmrc");
//        System.out.println(ops.getListOfTweets().size());
        List<String> list = ops.getTweetsFromGivenDate("hello", LocalDate.of(2020, 3,  9)).stream().map(status -> status.getCreatedAt().toString()).collect(Collectors.toList());
        for (String tweet: list) {
            System.out.println(tweet + "\n\n**********************************\n");
        }
        System.out.println(list.size());

    }

}
