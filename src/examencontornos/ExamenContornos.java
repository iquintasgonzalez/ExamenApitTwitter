package examencontornos;

import java.util.Scanner;
import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author iquintasgonzalez
 */
public class ExamenContornos {

    public static void main(String[] args) throws TwitterException {
        // variable declarada
        Twitter twitter;
        //variables declaradas
        String busqueda;
        String tweet;
        String nombre;
        String mensaje;
        int opcion;
        //objeto creado
        Metodos obj = new Metodos();
        //menu
        obj.verTL();

        busqueda = JOptionPane.showInputDialog("Introduzca lo que desee buscar en Twitter");
        obj.buscarTrending(busqueda);

        tweet = JOptionPane.showInputDialog("Introduzca lo que desee twittear");
        obj.tweetear(tweet);

        nombre = JOptionPane.showInputDialog("Usuario");
        mensaje = JOptionPane.showInputDialog("¿Que mensaje le quieres enviar?");
        obj.directMessage(nombre, mensaje);
        //un menu switch
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("opciones: \n1 --> TimeLine\n2 --> Buscar\n3 --> Tweettear\n4 --> DirectMsg\n5 --> Exit"));
            switch (opcion) {
                case 1:
                    obj.verTL();
                    break;
                case 2:
                    busqueda = JOptionPane.showInputDialog("Introduzca lo que desee buscar");
                    obj.buscarTrending(busqueda);
                    break;
                case 3:
                    tweet = JOptionPane.showInputDialog("Introduzca lo que desee twittear");
                    obj.tweetear(tweet);
                    break;
                case 4:
                    nombre = JOptionPane.showInputDialog("Usuario");
                    mensaje = JOptionPane.showInputDialog("¿Que mensaje le quieres enviar?");
                    obj.directMessage(nombre, mensaje);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (opcion != 0 && opcion != 4);
    }
}
