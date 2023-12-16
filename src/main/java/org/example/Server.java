package org.example;
import java.io.IOException;
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
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nowe połączenie: " + clientSocket);
                number_of_players += 1;
                int finalNumber_of_players = number_of_players;
                new Thread(() -> handleClient(clientSocket, finalNumber_of_players)).start();

                if (number_of_players == 2) {


                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void handleClient(Socket clientSocket, int number_of_players) {
//        try (
//                Scanner in = new Scanner(clientSocket.getInputStream());
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
//        ) {
//            String message = in.nextLine();
//            System.out.println("Odebrano wiadomość od klienta: " + message);
//
//            // Przykładowa odpowiedź serwera
//            out.println("Otrzymałem wiadomość: " + message);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                clientSocket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }



        Player player;
        if (number_of_players <= 2) {
            player = new Player(number_of_players);
            System.out.println("Hello player number " + number_of_players);
        } else {
            System.out.println("Cannot play in party larger than 2");
        }



        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
