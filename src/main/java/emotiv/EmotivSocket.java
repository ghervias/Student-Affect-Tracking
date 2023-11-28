package emotiv;

import java.net.URI;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import data.Blackboard;
import data.PadData;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * EmotivSocket is a WebSocket client that connects to the Emotiv server.
 * It is used to send requests to the Emotiv server and receive responses.
 *
 *  @author javiersgs
 *  @version 0.1
 */
public class EmotivSocket extends WebSocketClient {

    private EmotivHandler delegate;

    private static final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
    };

    public EmotivSocket(URI serverURI, EmotivHandler delegate) throws Exception {
        super(serverURI);
        this.delegate = delegate;
        // Disable SSL certificate validation to allow self-signed certificates
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        // Connect to Emotiv server using secure WebSocket protocol
        setSocket(sc.getSocketFactory().createSocket());
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("Connected to Emotiv server: " + getURI());
        delegate.handle (0, null, this);
    }

    @Override
    public void onMessage(String message) {
        //System.out.println("Received message from Emotiv server.");
        if (!delegate.isSubscribed()) {
            JSONObject response = new JSONObject(message);
            int id = response.getInt("id");
            Object result = response.get("result");
            delegate.handle (id, result, this);
        } else {
            float time = new JSONObject(message).getFloat("time");
            JSONObject object = new JSONObject(message);
            JSONArray array = null;
            if ((object.keySet()).contains("met")) {
                array = object.getJSONArray("met");
                Blackboard.getInstance().addAffect(time, array);
                Blackboard.getInstance().addPAD(time, array);
            }
//            else if ((object.keySet()).contains("fac")) {
//                array = object.getJSONArray("fac");
//                Blackboard.getInstance().addFace(time, array);
//            }
//            else if ((object.keySet()).contains("dev")) {
//                array = object.getJSONArray("dev");
//                Blackboard.getInstance().addDevice(time, array);
//            } else


        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed with code " + code + " and reason " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("Error: " + ex);
    }

}
