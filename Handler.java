import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Handler extends Thread {
    public Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        try {
            System.out.println("New connection started on thread " + this.getName());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello - welcome to the date server. You're on thread " + this.getName());
            while(true) {
                String message = (new Date()).toString();
                out.println(message);
                Thread.sleep(500);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}