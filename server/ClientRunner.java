package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientRunner implements Runnable {

    private Socket s = null;
    private ChatServer parent = null;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;

    public ClientRunner(Socket s, ChatServer parent) {
        this.s = s;
        this.parent = parent;
        try {
            outputStream = new ObjectOutputStream(this.s.getOutputStream());
            inputStream = new ObjectInputStream(this.s.getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {
            Message message = null;
            while((message = (Message) inputStream.readObject()) != null) {
                this.parent.transmit(message);
            }
            inputStream.close();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void transmitMessage(Message m) {
        System.out.println(m);
	}

}