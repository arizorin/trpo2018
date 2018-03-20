package practice4.server;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/price")
public class websocket{
    @OnOpen
    public void onOpen(Session session) throws IOException {
      //  session.getBasicRemote().sendText("Соединение установлено. Прим. команды (price:BTC:RUB)");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.getBasicRemote().sendText("Некорректная команда! Прим. команды (price:BTC:RUB)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            if(msg.contains("price")){
                String[] ms = msg.split(":");
                   GetData d = new GetData();
                    session.getBasicRemote().sendText(d.getPrice(ms[1],ms[2]));
            }
        } catch (IOException e) { }
    }
}
