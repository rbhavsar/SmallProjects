package Twitter;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class FirstTwitterApp {

    public static void main(String[] args) throws TwitterException {

        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true).setOAuthConsumerKey(	"j8Z3uaWhHAsCtbZKPCuiDVKvN").setOAuthConsumerSecret
                ("IGGgtP42WfwYgJfYlX4QvzOr9JpkaDaDlOioCyAsqdhq48L5ws").setOAuthAccessToken
                ("102618302-k1HCaHDo7kE8psjo6JK7FGCVyST8MMpvlVTZibv3").setOAuthAccessTokenSecret("SILdY7tyLj1UiLjHUE11EykYYRaRUImaR8trgfjOdeECd");

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();

        List<Status> status = twitter.getHomeTimeline();

        //get username & status

        for (Status st : status) {
            System.out.println("st :"+st.getUser().getName()+"-------"+st.getText()+"------"+st.getInReplyToScreenName());
        }
    }
}
