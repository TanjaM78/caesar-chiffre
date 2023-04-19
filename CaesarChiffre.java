package advanced;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CaesarChiffre {

    public static void main(String[] args) {
        Scanner sc2 = new Scanner(System.in);
        int key;
        System.out.println("Gib bitte deinen Key ein");
        key = sc2.nextInt();
        String str = "";
        try {
            Scanner sc = new Scanner(new File("starterExercises/testtext.txt"));
            while (sc.hasNext()) {
                str = str + sc.nextLine();
            }
            sc.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Normaler Text: " + str);
        System.out.println(str);

        String secureText = "";
        for (int i = 0; i < str.length(); i++) {
            int charValue = str.charAt(i);
            char next;

            if (charValue >= 65 && charValue <= 90) {
                // Großbuchstaben
                next = (char) (charValue + key);
                if (next > 'Z') {
                    next = (char) (next - 26);
                }
            } else if (charValue >= 97 && charValue <= 122) {
                // Kleinbuchstaben
                next = (char) (charValue + key);

                if (next > 'z') {
                    next = (char) (next - 26);
                }
            } else {
                // Alles andere
                next = (char) (charValue);
            }
            secureText = secureText + next;
        }
        System.out.println(secureText);

        File secureTextFile = new File("starterExercises/secureText.txt");
        try {
            FileWriter writer = new FileWriter(secureTextFile, false);
            writer.write(secureText);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Datei erstellen ging nicht");
        }

        System.out.println(secureText);
        String readText = "";
        try {
            Scanner sc3 = new Scanner(new File("starterExercises/secureText.txt"));
            while (sc3.hasNext()) {
                readText = readText + sc3.nextLine();
            }
            sc3.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String unsecureText = " ";
        for (int i = 0; i < readText.length(); i++) {
            int charValue = readText.charAt(i);
            char next;

            if (charValue >= 65 && charValue <= 90) {
                // Großbuchstaben
                next = (char) (charValue - key);
                if (next < 'A') {
                    next = (char) (next + 26);
                }
            } else if (charValue >= 97 && charValue <= 122) {
                // Kleinbuchstaben
                next = (char) (charValue - key);

                if (next < 'a') {
                    next = (char) (next + 26);
                }
            } else {
                // Alles andere
                next = (char) (charValue);

            }
            unsecureText = unsecureText + (char) next;
        }
        System.out.println(unsecureText);
    }
}













