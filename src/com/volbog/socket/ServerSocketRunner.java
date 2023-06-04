package com.volbog.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerSocketRunner {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
            var request = inputStream.readUTF();
            var scanner = new Scanner(System.in);
            while(!"stop".equals(request)) {
                System.out.println("Client inputStream: " + request);
                var response = scanner.nextLine();
                outputStream.writeUTF(response);
                request = inputStream.readUTF();
            }
        } catch (Exception e) {

        }
    }
}
