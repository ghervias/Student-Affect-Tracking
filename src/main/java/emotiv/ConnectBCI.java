package emotiv;

//import gui.StatusBar;
//import gui.DataPanel;
//
//import javax.swing.*;
//import java.awt.*;
import java.net.URI;

/**
 * GUI for the Emotiv WebSocket client.
 *
 *  @author javiersgs
 *  @version 0.1
 */
public class ConnectBCI {

    /**
     * Constructor for the Main class.
     */
    public ConnectBCI() {
//        super("Emotiv WebSocket Client");
//        // statusbar
//        setLayout(new BorderLayout());
//        StatusBar statusBar = new StatusBar();
//        Blackboard.getInstance().addObserver(statusBar);
//        add(statusBar, BorderLayout.SOUTH);
//        // data-panel
//        DataPanel dataPanelDevice = new DataPanel(Device.class);
//        DataPanel dataPanelFace = new DataPanel(Face.class);
//        DataPanel dataPanelAffect = new DataPanel(Affect.class);
//        DataPanel dataPanelPAD = new DataPanel(PadData.class);
//        Blackboard.getInstance().addObserver(dataPanelDevice);
//        Blackboard.getInstance().addObserver(dataPanelFace);
//        Blackboard.getInstance().addObserver(dataPanelAffect);
//        Blackboard.getInstance().addObserver(dataPanelPAD);
        ServerNet server = new ServerNet();
//        Blackboard.getInstance().addObserver(server);
        Thread t = new Thread(server);
        t.start();

//        JPanel group = new JPanel(new GridLayout(1, 4));
//        group.add(dataPanelDevice);
//        group.add(dataPanelFace);
//        group.add(dataPanelAffect);
//        group.add(dataPanelPAD);
//        add(group, BorderLayout.CENTER);

    }

    /**
     * Main method for the Main class.
     *
     * @param args Command line arguments.
     */
    public static EmotivHandler connect() {
        ServerNet server = new ServerNet();
        Thread t = new Thread(server);
        t.start();
//        Main main = new Main();
//        main.setSize(800, 600);
//        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        main.setVisible(true);

        try {
            URI uri = new URI("wss://localhost:6868");
            EmotivHandler delegate = new EmotivHandler();
            EmotivSocket handler = new EmotivSocket(uri, delegate);
            handler.connect();
            return delegate;
        } catch (Exception e) {
//            Blackboard.getInstance().addStatusbarMessage("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
