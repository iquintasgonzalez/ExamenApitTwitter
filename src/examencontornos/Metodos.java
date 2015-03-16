/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencontornos;

/**
 *
 * @author iquintasgonzalez
 */
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Metodos {

    Twitter twitter;

    public Metodos() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("0AOUWd7NMNgCi11E1mqpKCkuL")
                .setOAuthConsumerSecret("xW2KlbmdUaKNnBSWm73p9VpL9ywNeGrx726tXVv7R4Wji8a0KK")
                .setOAuthAccessToken("3055142195-sx2xtJqgPrjUXrP7Dtd8YuRHdzH6GsOMSHIG4nq")
                .setOAuthAccessTokenSecret("gZekOzP1RBvqbOwg2zUHhVy4OcMSdub8YIeRTXGqGGVG7");

        twitter = new TwitterFactory(cb.build()).getInstance();

    }

     public void verTL() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }

    }
     public void buscarTrending(String busqueda) throws TwitterException {

        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }

    }
}
