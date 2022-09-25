import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String lineHasNumberLargerThanTen(File file) {
        Scanner scanner;
        String line;
        String answerString = "";
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            for (int i = 1; i < line.length(); i++) {
                if ((Character.isDigit(line.charAt(i)) && Character.isDigit(line.charAt(i - 1)))
                        && (Character.getNumericValue(line.charAt(i - 1)) > 0)) {
                    answerString += line + "\n";
                    break;
                }
            }
        }
        return answerString;
    }

    public static void main(String[] args) {
        File file = new File(".//src/files/input.txt");
        FileWriter fileWriter;
        Scanner answerScanner = new Scanner(System.in);
        String answer = "";

        System.out.print("Hello" + "\n" +
                "How would you like to get your result" + "\n" +
                "1 - Print in console" + "\n" +
                "2 - Write it to answer file" + "\n");
        System.out.print("Your answer: ");

        switch (answerScanner.nextInt()) {
            case 1:
                answer = lineHasNumberLargerThanTen(file);
                System.out.println("Lines where exists number bigger than 10: " + "\n"
                        + answer);
                break;
            case 2:
                answer = lineHasNumberLargerThanTen(file);
                try {
                    fileWriter = new FileWriter(".//src/files/output.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    fileWriter.write(answer);
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Answer has been added to file successfully");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
}