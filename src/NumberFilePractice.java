import java.util.*;
import java.io.*;

public class NumberFilePractice {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        PrintWriter outFile = null;
        do {
            System.out.print("Enter filename with .txt extension: ");
            String userFile = userInput.nextLine();

            try {
                outFile = new PrintWriter(new BufferedWriter(new FileWriter(userFile, false)));
            } catch (IOException e) {
                System.out.print(e.getMessage());
                System.out.println(" is not a valid file name.");
            }
        } while (outFile == null);


        double number;
        boolean validInput = false;

        for (int i = 1; i <= 10; i++) {
            do {
                System.out.print("Enter number " + i + ": ");
                try {
                    number = Double.parseDouble(userInput.nextLine());
                    outFile.append(String.valueOf(number)).append("\n");
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.print(e.getMessage());
                    System.out.println(" is not a valid number.");
                }
            } while (!validInput);

            validInput = false;
        }

        userInput.close();
        outFile.close();
    }
}
