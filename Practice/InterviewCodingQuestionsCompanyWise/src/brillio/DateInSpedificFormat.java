package brillio;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateInSpedificFormat {
    public static void main(String[] args){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date); // 06-23-2020
        withDateTimeFormatter();
    }

    public static void withDateTimeFormatter() {
        LocalDate date = LocalDate.now();
        String pattern = "MM-dd-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDate = date.format(formatter);
        System.out.println(formattedDate);
    }
}
