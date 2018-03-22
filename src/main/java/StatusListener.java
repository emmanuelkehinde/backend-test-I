import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.User;

import java.io.IOException;

public class StatusListener implements twitter4j.StatusListener {
    @Override
    public void onStatus(Status status) {
        User user = status.getUser();
        if(user.getFollowersCount() > 1000 && user.getFollowersCount() <= 50000){
            System.out.println(user.getScreenName() + " : " + user.getFollowersCount());
            try {
                GoogleSheetHelper.setSheetContent(user.getScreenName(), String.valueOf(user.getFollowersCount()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {

    }

    @Override
    public void onStallWarning(StallWarning warning) {

    }

    @Override
    public void onException(Exception ex) {

    }
}
