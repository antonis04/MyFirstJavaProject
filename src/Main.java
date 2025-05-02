import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //ALARM CLOCK JAVA PROJECT

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filepath = "A Caring Friend.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use HH:MM:SS");

            }
        }
            AlarmClock alarmClock = new AlarmClock(alarmTime, filepath, scanner);
            Thread alarmThread = new Thread(alarmClock);
            alarmThread.start();


    }
}

