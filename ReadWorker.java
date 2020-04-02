import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.SwingWorker;

public class ReadWorker extends SwingWorker<Void,Void> {
    
	private Socket socket = null;
    private ObjectInputStream inputStream = null;
    private Client parent;
    
    public ReadWorker(Socket s, Client parent) {
        this.socket = s;
        this.parent = parent;
        
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public Void doInBackground() {
        System.out.println("Started read worker");
        Board board = null;
        try {
            while((board = (Board)inputStream.readObject())!= null) {
                System.out.println("Client listened about board");
                parent.updateClients(board);
            }
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            return null;
        }
    }
    
}
