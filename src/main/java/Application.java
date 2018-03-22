import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        TwitterStream twitterStream = new TwitterStreamFactory(getConfiguration()).getInstance();
        twitterStream.addListener(new StatusListener());

        String[] hashTags = requestHashTags();
        System.out.print("Filter based on the following hashTags: [");
        for (int i=0; i < hashTags.length; i++) {
            if (i == hashTags.length - 1) {
                System.out.print(hashTags[i] + "]\n");
            } else {
                System.out.print(hashTags[i] + ", ");
            }
        }
        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.track(hashTags);
        twitterStream.filter(tweetFilterQuery);
    }

    private static Configuration getConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(Constants.OAUTH_CONSUMER_KEY)
                .setOAuthConsumerSecret(Constants.OAUTH_CONSUMER_SECRET)
                .setOAuthAccessToken(Constants.OAUTH_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(Constants.OAUTH_ACCESS_TOKEN_SECRET);
        return cb.build();
    }

    private static String[] requestHashTags() {
        Scanner scanner = new Scanner(System.in);
        String hashTags = null;
        do {
            System.out.println("Enter each HashTag separated by comma or space");
            if(scanner.hasNextLine()){
                hashTags = scanner.nextLine();
            }
        } while (Util.isNullOrEmpty(hashTags));
        return Util.getFormattedHashTags(hashTags);
    }

}
