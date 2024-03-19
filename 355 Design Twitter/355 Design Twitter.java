// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/design-twitter/

// Video Solution: https://www.youtube.com/watch?v=esZ4vvjwW6E

**************** Java Solution ***********************


import java.util.*;

public class Twitter {
    private static int timeStamp = 0;

    // User class to represent each user in Twitter
    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // User should follow themself
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            if (id != this.id) {
                followed.remove(id);
            }
        }

        public void post(int id) {
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    // Tweet class to represent each tweet
    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    private Map<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User newUser = new User(userId);
            userMap.put(userId, newUser);
        }
        userMap.get(userId).post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user themselves.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();
        if (!userMap.containsKey(userId)) return newsFeed;

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(followedUsers.size(), (a, b) -> b.time - a.time);

        for (int user : followedUsers) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                tweetHeap.add(tweet);
            }
        }

        int count = 0;
        while (!tweetHeap.isEmpty() && count < 10) {
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id);
            count++;
            if (tweet.next != null) {
                tweetHeap.add(tweet.next);
            }
        }

        return newsFeed;
    }

    /** Follower follows a followee. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }
        if (!userMap.containsKey(followeeId)) {
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
