import java.io.*;
import java.net.*;

// Client Side
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public void run() {
        try {
            int serverPort = 4020;
            InetAddress host = InetAddress.getByName("localhost");
            System.out.println("Connecting to server on port " + serverPort);

            Socket socket = new Socket(host,serverPort);
            //Socket socket = new Socket("127.0.0.1", serverPort);
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            PrintWriter toServer =
                    new PrintWriter(socket.getOutputStream(),true);
            BufferedReader fromServer =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            toServer.println("Hello from " + socket.getLocalSocketAddress());
            String line = fromServer.readLine();
            System.out.println("Client received: " + line + " from Server");
            toServer.close();
            fromServer.close();
            socket.close();
        }
        catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Would yo like to play a quiz game? (q)\nor\nWould you like to click buttons to see cool stuff happen?(b)");
        String answer = scanner.nextLine();

        if(answer.contains("q")){
            new Quiz();

        } else if (answer.contains("b")) {
            new LambdaGame();
        }else {
            System.out.println("Since your answer was invalid, here is some multithreading: ");
            for (int i = 0; i < 5; i++) {
                Multithreading threads = new Multithreading(i);
                threads.start();
            }
        }
        }



    public static void main(String[] args) {
        Client client = new Client();
        client.run();


    }
}