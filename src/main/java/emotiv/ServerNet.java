package emotiv;//import java.io.ObjectOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import data.*;
import java.io.*;
import java.net.*;

/**
 * This class implements java Socket server
 *
 * @author javiersgs
 * @version 0.1
 */

public class ServerNet implements Runnable, Observer {
  private String status = "";
  private ServerSocket server;
  private static final int PORT = 9876;
  public static boolean flag = false;



  public void run() {
    try {
    server = new ServerSocket(PORT);
    //ObjectOutputStream oos;
    while (true) {
      Thread.sleep(50);
      Socket socket = server.accept();
      if (flag) {
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        //oos = new ObjectOutputStream(socket.getOutputStream());

        //System.out.println("Streaming data in port " + PORT);
        //oos.writeObject(status);
        //System.out.println("> " + status);
       // System.out.println("Receive new connection: " + socket.getInetAddress());
        if (PadData.getPADZone() == "Engagement") {
          dout.writeUTF(PadData.getPADZone() + "," + PadData.getEngage());
        }
        else if (PadData.getPADZone() == "Frustration") {
          dout.writeUTF(PadData.getPADZone() + "," + PadData.getStress());
        }

        flag = false;
        dout.flush();
        dout.close();
        // oos.close();

      }
      socket.close();
      //server.close();

    }
    } catch (Exception ex) {
      System.out.println("Error: " + ex);
    }
  }

  @Override
  public void update(Observable o, Object arg) {
    flag = true;
    this.status = status = Blackboard.getInstance().getData();
  }

}
