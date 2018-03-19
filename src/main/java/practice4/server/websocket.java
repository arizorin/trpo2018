package practice4.server;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/hello")
public class websocket{
    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            if(msg.equals("price")){
                Tester f = new Tester();
                session.getBasicRemote().sendText(f.show());
            }
        } catch (IOException e) { }
    }
}
