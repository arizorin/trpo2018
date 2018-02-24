package practice1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        //проверка даты
        System.out.println("Задание 2\nEnter date like {dd.MM.yyyy}:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(text);
            System.out.println("Valid format!");
        } catch (ParseException e) {
            System.out.println("Not valid format!");
        }

        //проверка email
        System.out.println("Enter you email: ");
        Pattern pattern = Pattern.compile("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$");
        text = scanner.next();
        Matcher matcher = pattern.matcher(text);

        if(matcher.matches()){
            System.out.println("valid!");
        }
        else System.out.println("not valid!");
    }
}
