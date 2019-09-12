package com.sun.dev.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sunchengfei on 2018/12/29.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getLocalHost(), 6777);
        //读取服务器端传过来信息的DataInputStream
        DataInputStream in = new DataInputStream(client.getInputStream());
        //向服务器端发送信息的DataOutputStream
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        //装饰标准输入流，用于从控制台输入
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String send = scanner.nextLine(); //控制台无输入，阻塞
            //把从控制台得到的信息传送给服务器
            out.writeUTF( "client: " + send);

            //读取来自服务器的信息
            String accpet = in.readUTF();  //服务端无消息，阻塞
            System.out.println(accpet);
        }
    }
}
