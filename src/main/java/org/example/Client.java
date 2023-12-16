package org.example;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
