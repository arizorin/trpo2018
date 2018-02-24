package practice2;
import org.json.*;
import java.io.*;

public class JsonParser {
    public static void main(String[] args) throws FileNotFoundException {
        String path =  "src/main/resources/E05_aanderaa_all_1769_d432_5004.json";
        FileReader br = new FileReader(path);
        JSONTokener Tokener = new JSONTokener(br);
        JSONObject obj = new JSONObject(Tokener);
        JSONObject table = (JSONObject) obj.get("table");
        JSONArray columnNames = table.getJSONArray("columnNames");
        JSONArray columnTypes = table.getJSONArray("columnTypes");
        JSONArray columnUnits = table.getJSONArray("columnUnits");
        JSONArray rows = table.getJSONArray("rows");
        for (int i = 0; i < rows.length(); i++){
            System.out.println(rows.get(i).toString());
        }
        //что то надо посчитать, а я не помнню что :(
    }
}
