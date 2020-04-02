import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends JFrame {

    private Socket server = null;
    private JTextArea textArea;
    private ObjectOutputStream outputStream;
    private JTextField messageField;
    private JButton sendButton;
    private Human player;
    
    public Client() {

    	this.player = new Human(BoardView.initWindow(), 1);
    	Controller controllerObject = new Controller(this.player);

        connect();

        try {
            outputStream = new ObjectOutputStream(server.getOutputStream());
        }catch(IOException e) {
            e.printStackTrace();
        }

        ReadWorker rw = new ReadWorker(server, controllerObject);
        rw.execute();
        System.out.println("HERE");
    }
    
    private void connect() {
        try {
            server = new Socket("127.0.0.1",8765);
            System.out.println("Connected");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void display(Message m) {
        textArea.append(m.toString() + '\n');
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