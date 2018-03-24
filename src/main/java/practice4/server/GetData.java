package practice4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetData {
    Coin coin = new Coin();
//    static final String currency = "RUB";
    public String getPrice(String crypto, String currency) throws IOException {
        URL oracle = new URL(String.format("https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=%s",crypto,currency));
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine = in.readLine();
        inputLine = inputLine.replaceAll("\\{", "").replaceAll("\\}","").replaceAll("\"","");
        String[] mass = inputLine.split(":");
        coin.setName(mass[0]);
        coin.setPrice(Double.valueOf(mass[1]));
        in.close();
        return coin.toString();
    }
}
