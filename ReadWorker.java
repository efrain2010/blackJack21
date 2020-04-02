import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.SwingWorker;

public class ReadWorker extends SwingWorker<Void,Void> {
    
	private Socket socket = null;
    private ObjectInputStream inputStream = null;
    private Client parent;
    private Controller controllerObject;
    
    public ReadWorker(Socket s, Controller controllerObject) {
        this.socket = s;
//        this.parent = parent;
        this.controllerObject = controllerObject;
        
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public Void doInBackground() {
        System.out.println("Started read worker");
        Message m = null;
        try {
            while((m = (Message)inputStream.readObject())!= null) {
                System.out.println(m);
                parent.display(m);
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
