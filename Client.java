import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends JFrame {

    private Socket server = null;
    private ObjectOutputStream outputStream;
    private Human player;
    private Controller controllerObject;
    
    public Client() {

        connect();

        try {
            outputStream = new ObjectOutputStream(this.server.getOutputStream());
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        ReadWorker rw = new ReadWorker(this.server, this);
        rw.execute();
        
        this.controllerObject = new Controller(new Model(), outputStream);
    }

    private void connect() {
        try {
            server = new Socket("127.0.0.1",8765);
            System.out.println("Connected");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void updateClients(Board board) {
        System.out.println("update clients");
    }
    
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == sendButton) {
//            String messageText = messageField.getText();
//            try {
//                outputStream.writeObject(new Message(messageText,this.player.getName()));
//                messageField.setText("");
//            }catch(IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
        new Client();
    }
    
}