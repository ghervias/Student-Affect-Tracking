package emotiv;

import org.java_websocket.client.WebSocketClient;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * EmotivDelegate follows CortexAPI protocol to set up a connection
 *
 * @author javiersgs
 * @version 0.1
 * @see <a href="https://emotiv.gitbook.io/cortex-api/">Cortex API</a>
 */
public class EmotivHandler {

    public static final String CLIENT_ID = "mhZEBYGa4i6jMRTmavQmxsoa81RMF6SyWoN5BYzg";
    public static final String CLIENT_SECRET = "EZo2zJNiGmjTCWicUejLyrjwe3UF9JPhTBwj4Rf5F1tMHqP5Y1t1KIhFD0MDgYQnqcJVILRvmm6ixsd11EkzRo0F8Jok21RCq6RExRv4ZQ8F04nLZgZspi5SCtHUMAj3";

    private boolean subscribed = false;
    private String cortexToken = null;
    private String firstName, lastName, userName;
    private String headset = null;
    private String session = null;

    public void getCortexInfo(WebSocketClient ws) {
        System.out.println("getCortexInfo: done!");
        JSONObject message = new JSONObject();
        message.put("id", 1);
        message.put("jsonrpc", "2.0");
        message.put("method", "getCortexInfo");
        ws.send(message.toString());
    }

    public void requestAccess(WebSocketClient ws) {
        System.out.println("requestAccess: done!");
        JSONObject message = new JSONObject();
        message.put("id", 2);
        message.put("jsonrpc", "2.0");
        message.put("method", "requestAccess");
        JSONObject params = new JSONObject();
        params.put("clientId", CLIENT_ID);
        params.put("clientSecret", CLIENT_SECRET);
        message.put("params", params);
        ws.send(message.toString());
    }

    public void authorize(WebSocketClient ws) {
        System.out.println("authorize: done!");
        JSONObject message = new JSONObject();
        message.put("id", 3);
        message.put("jsonrpc", "2.0");
        message.put("method", "authorize");
        JSONObject params = new JSONObject();
        params.put("clientId", CLIENT_ID);
        params.put("clientSecret", CLIENT_SECRET);
        params.put("debit", 1);
        message.put("params", params);
        ws.send(message.toString());
    }

    public void getUserInformation(WebSocketClient ws) {
        System.out.println("getUserInformation");
        if (cortexToken != null) {
            JSONObject message = new JSONObject();
            message.put("id", 4);
            message.put("jsonrpc", "2.0");
            message.put("method", "getUserInformation");
            message.put("params", new JSONObject().put("cortexToken", cortexToken));
            ws.send(message.toString());
        }
    }

    public void queryHeadsets(WebSocketClient ws) {
        System.out.println("queryHeadsets");
        JSONObject message = new JSONObject();
        message.put("id", 5);
        message.put("jsonrpc", "2.0");
        message.put("method", "queryHeadsets");
        ws.send(message.toString());
    }

    public void createSession(WebSocketClient ws) {
        if (cortexToken != null && headset != null) {
            System.out.println("createSession");
            JSONObject message = new JSONObject();
            message.put("id", 6);
            message.put("jsonrpc", "2.0");
            message.put("method", "createSession");
            JSONObject params = new JSONObject();
            params.put("cortexToken", cortexToken);
            params.put("headset", headset);
            params.put("status", "active");
            message.put("params", params);
            ws.send(message.toString());
        }
    }

    public void subscribe(WebSocketClient ws) {
        System.out.println("subscribe");
        if (cortexToken != null && session != null) {
            JSONObject message = new JSONObject();
            message.put("id", 7);
            message.put("jsonrpc", "2.0");
            message.put("method", "subscribe");
            JSONObject params = new JSONObject();
            params.put("cortexToken", cortexToken);
            params.put("session", session);
            params.put("streams", new JSONArray().put("met").put("fac").put("dev"));

            // "met" is for emotion, "dev" is for dev mode, "fac" is for facial gestures
            message.put("params", params);
            ws.send(message.toString());
        }
    }

    public void handle(int id, Object result, WebSocketClient ws) {
        //System.out.println("Handle: " + id);
        JSONObject myJsonObj;
        switch (id) {
            case 0:
                getCortexInfo(ws);
                break;
            case 1:
                requestAccess(ws);
                break;
            case 2:
                authorize(ws);
                break;
            case 3:
                myJsonObj = new JSONObject(result.toString());
                cortexToken = myJsonObj.getString("cortexToken");
                getUserInformation(ws);
                break;
            case 4:
                myJsonObj = new JSONObject(result.toString());
                System.out.println(">>>> getUserInformation: " + myJsonObj.toString());
                firstName = myJsonObj.getString("firstName");
                lastName = myJsonObj.getString("lastName");
                userName = myJsonObj.getString("username");
                queryHeadsets(ws);
                break;
            case 5:
                JSONArray myJsonArr = new JSONArray(result.toString());
                headset = myJsonArr.getJSONObject(0).getString("id");
                createSession(ws);
                break;
            case 6:
                myJsonObj = new JSONObject(result.toString());
                session = myJsonObj.getString("id");
                subscribe(ws);
                break;
            case 7:
                subscribed = true;
                System.out.println("SUBSCRIBED = TRUE");
        }
    }

    public boolean isSubscribed() {
        return subscribed;
    }
}
