package emotiv;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * This class implements java socket client
 * @author javiersgs
 * @version 0.1
 *
 */
public class ClientNet {

  public static void main(String[] args) {
    try {
        InetAddress host = InetAddress.getByName("192.168.1.38");
      Socket socket = null;
      ObjectInputStream ois = null;
      while (true) {
        socket = new Socket("192.168.1.38", 9876);
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println(message);
        ois.close();
        Thread.sleep(100);
      }
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

}
