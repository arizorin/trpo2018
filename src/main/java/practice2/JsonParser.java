package practice2;
import org.json.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JsonParser {
    public static void main(String[] args) throws FileNotFoundException {
        String path =  "src/main/resources/practice2/E05_aanderaa_all_1769_d432_5004.json";
        FileReader br = new FileReader(path);
        JSONTokener Tokener = new JSONTokener(br);

        //Парсим данные из файла
        JSONObject obj = new JSONObject(Tokener);
        JSONObject table = (JSONObject) obj.get("table");
        JSONArray columnNames = table.getJSONArray("columnNames");
        JSONArray columnTypes = table.getJSONArray("columnTypes");
        JSONArray columnUnits = table.getJSONArray("columnUnits");
        JSONArray rows = table.getJSONArray("rows");
        

        ArrayList<Integer> choice = new ArrayList<Integer>();
        //Scanner scanner = new Scanner(System.in);
        System.out.println("В файле содержаться следующие параметры: ");
        for (int i = 0; i < columnTypes.length(); i++){
       if(columnTypes.get(i).toString().equals("float") && !columnNames.get(i).toString().equals("longitude") &&
               !columnNames.get(i).toString().equals("latitude") && !columnNames.get(i).toString().equals("depth")){
               System.out.println(columnNames.get(i));
               choice.add(i);
           }
        }
        System.out.println();
        for (int num: choice) {
            System.out.println("Вывод значений для " + columnNames.get(num));
            String units = " " + columnUnits.get(num);
            getAverage(rows, columnNames, num, units);
            System.out.println("--------------");
        }




    }

    public static void getAverage(JSONArray rows, JSONArray columnNames, int num, String units){
        float average = 0;
        Float averageMass[] = new Float[rows.length()];
        for (int i = 0; i < rows.length(); i++){
            String row = String.valueOf(rows.get(i));
            for(int j = 0; j<columnNames.length(); j++){
                String mass[] = row.split(",");
                //  System.out.println(mass[j].toString());
                averageMass[i] = Float.valueOf(mass[num]);
            }
            average = average + averageMass[i];
            //System.out.println(averageMass[i]);
        }
        Arrays.sort(averageMass);
        System.out.println("Minimum: " + averageMass[32] + units);
        System.out.println("Maximum: " + averageMass[averageMass.length-1]+ units);
        System.out.println("Average: " + average/averageMass.length + units);
    }



}
