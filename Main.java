import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static int PORT = 8765;
    private static String server = "127.0.0.1";

    public static void main(String[] args) {
        ServerSocket listener = null;
        Socket client = null;
        try {
            listener = new ServerSocket(8765);
            client = listener.accept();
            System.out.println("Client has arrived");
            OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());

            Scanner text = new Scanner(System.in);
            while(true) {
                String line = text.nextLine();
                if(line.equals("END")) {
                    break;
                }
                os.write(line + '\n');
                os.flush();
            }
            text.close();
            client.close();
            listener.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}