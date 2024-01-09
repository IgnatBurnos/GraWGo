package org.example;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;


        int number_of_players = 0;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serwer nasłuchuje na porcie " + PORT);
            SerwerGame serwerGame = new SerwerGame();

            Socket client1Socket = serverSocket.accept();
            System.out.println("Nowe połączenie: " + client1Socket);

            Socket client2Socket = serverSocket.accept();
            System.out.println("Nowe połączenie: " + client2Socket);

            try (
                    Scanner in1 = new Scanner(client1Socket.getInputStream());
                    Scanner in2 = new Scanner(client2Socket.getInputStream());
                    PrintWriter out1 = new PrintWriter(client1Socket.getOutputStream(), true);
                    PrintWriter out2 = new PrintWriter(client2Socket.getOutputStream(), true)
            ) {

                /** @TODO
                 * add selection of map size
                 */
                Player player1 = new Player(1);
                Player player2 = new Player(2);
                serwerGame.setPlayer1(player1);
                serwerGame.setPlayer2(player2);
                serwerGame.startGame(9, 9);

                /**
                 * @TODO
                 * add implementatnio that sends player objeckt to Client, then client changes
                 * stuff on his end, then take the objeckt back and set it as the player in game
                 * */


                while (serwerGame.getContinueGame()) {

                    //player 1
                    String message = in1.nextLine();
                    System.out.println("Odebrano wiadomość od klienta: " + message);
                    out1.println("Otrzymałem wiadomość: " + message);

                    //wysylanie obiektu player

                    //player 2
                    String message2 = in2.nextLine();
                    System.out.println("Odebrano wiadomość od klienta: " + message2);
                    out2.println("Otrzymałem wiadomość: " + message2);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
