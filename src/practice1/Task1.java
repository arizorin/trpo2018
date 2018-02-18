package practice1;

import java.text.ParseException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task1 {
    public static void main(String[] args) throws ParseException {
        String dateStr = "2018-02-12T01:02:03Z";
        Date date = Date.from(Instant.parse(dateStr));
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.setTime(date);
        System.out.println("Задание 1\nCurrent date: "+date);


        //Вывод следующего дня
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date tomorrow = calendar.getTime();
        System.out.println("Tomorrow date: " + tomorrow);

        //начало и конец недели
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        Date begin = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 6);
        calendar.set(Calendar.HOUR,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,59);
        Date end = calendar.getTime();
        System.out.println("Beginning of the week: " + begin + " \nEnding of the week: " + end);

        //конец месяца
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        Date lastDayOfMonth = calendar.getTime();
        System.out.println("Last day of mounth: " +lastDayOfMonth);
    }
}
