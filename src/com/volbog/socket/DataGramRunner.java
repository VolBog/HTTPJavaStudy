package com.volbog.socket;

import java.io.IOException;
import java.net.*;

public class DataGramRunner {

    public static void main(String[] args) throws IOException {
        InetAddress byName = Inet4Address.getByName("localhost");
        try(DatagramSocket datagramSocket = new DatagramSocket()){
            var bytes = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, byName, 7777);
            datagramSocket.send(packet);
        }
    }
}
