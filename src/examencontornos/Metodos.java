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
//metodo para tener asceso a twitter
   /* public Metodos() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("0AOUWd7NMNgCi11E1mqpKCkuL")
                .setOAuthConsumerSecret("xW2KlbmdUaKNnBSWm73p9VpL9ywNeGrx726tXVv7R4Wji8a0KK")
                .setOAuthAccessToken("3055142195-sx2xtJqgPrjUXrP7Dtd8YuRHdzH6GsOMSHIG4nq")
                .setOAuthAccessTokenSecret("gZekOzP1RBvqbOwg2zUHhVy4OcMSdub8YIeRTXGqGGVG7");

        twitter = new TwitterFactory(cb.build()).getInstance();

    }*/
// metodo para ver twitter
     public void verTL() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }

    }
     
     // metodo para ver trending
     public void buscarTrending(String busqueda) throws TwitterException {

        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }

    }
     
     // metodo para twittear
     public void tweetear(String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }
     
     // metodo para mandar mensajes directo 
     public void directMessage(String nombre, String mensaje) throws TwitterException {

        DirectMessage message = twitter.sendDirectMessage(nombre, mensaje);
        System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());

    }
}
