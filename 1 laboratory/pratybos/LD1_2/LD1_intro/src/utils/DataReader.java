package utils;
import models.Hotel;
import models.Tourist;
import java.io.FileInputStream;
import java.util.Scanner;

public class DataReader {

    public static void readFromFileTourist(String filePath, List outputData) {
        FileInputStream fileStream = null;
        Scanner scanner = null;

        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(";");
                outputData.add(new Tourist(lines[0], lines[1], lines[2],lines[3], Integer.parseInt(lines[4])));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void readFromFileHotel(String filePath, List outputData) {
        FileInputStream fileStream = null;
        Scanner scanner = null;

        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(";");
                outputData.add(new Hotel(lines[0], lines[1], Double.parseDouble(lines[2])));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
