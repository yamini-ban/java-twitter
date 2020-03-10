package com.knoldus;

import com.knoldus.controller.TwitterInstanceImpl;
import com.knoldus.controller.TwitterOps;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AppDriver {

    public static void main(String[] args) {
        TwitterOps ops = new TwitterOps(new TwitterInstanceImpl(), "#dmrc");
        TwitterOps ops1 = new TwitterOps(new TwitterInstanceImpl(), "#dmrc", 50);
        List<String> list = ops.getTweetsFromGivenDate(LocalDate.of(2020, 3, 9))
                .stream().map(status -> status.getCreatedAt().toString()).collect(Collectors.toList());
        for (String tweet : list) {
            System.out.println(tweet + "\n\n**********************************\n");
        }
        System.out.println(list.size());
        System.out.println(ops1.getListOfLikesInAscending());

    }

}
