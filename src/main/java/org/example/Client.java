package org.example;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //dodac tutaj player ktory widzialby czy jest jego tura gdzie ture zmieniamy na serwerze
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 12345;

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             Scanner scanner = new Scanner(System.in);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Podaj wiadomość do wysłania na serwer:");
            String message = scanner.nextLine();

            // Wysłanie wiadomości na serwer
            out.println(message);

            // Odczytanie odpowiedzi od serwera
            Scanner in = new Scanner(socket.getInputStream());
            String response = in.nextLine();
            System.out.println("Odpowiedź od serwera: " + response);




/**            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Player receivedPlayer = (Player) objectInputStream.readObject();
            System.out.println(receivedPlayer.get_surrender());



              HERE U CAN CHANGE ANYTHING ABOUT THE CLIENT - THEN THE SERWER WILL TAKE CARE OF IT

            receivedPlayer.licznik_ruchow += 1;


            receivedPlayer.setYour_tour(false);

              AT THE END CHANGE receivedPlayer.setYour_tour to flase to triger the next player

*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
