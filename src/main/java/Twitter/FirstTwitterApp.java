//https://www.youtube.com/watch?v=EuLEki6c1A8
//https://vaadin.com/blog/consuming-rest-services-from-java-applications
//https://www.youtube.com/watch?v=c0apqyro0-Y
//https://www.youtube.com/watch?v=ogwH4pMyJCE&index=22&list=PLVlQHNRLflP9O_T5bbRS8oTU7Y3Co3ZE9
//https://www.youtube.com/watch?v=O1epK2bQscA&index=28&list=PLVlQHNRLflP9O_T5bbRS8oTU7Y3Co3ZE9
//https://www.mongodb.com/download-center#atlas


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
