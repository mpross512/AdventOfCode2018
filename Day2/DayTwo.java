import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class DayTwo {

    public static void main(String[]args) throws IOException {
        File file = new File("input.txt");
        System.out.println("Puzzle A: " + getChecksumA(file));
        System.out.println("Puzzle B: " + getChecksumB(file));
    }
    
    public static int getChecksumA (File file) throws IOException{ 
        int doubleLetters = 0, tripleLetters = 0, prevDouble = 0, prevTriple = 0;
        Scanner scanner = new Scanner(file);
        char tripleLetter = ' ';
        while(scanner.hasNextLine()) {
            prevDouble = doubleLetters;
            prevTriple = tripleLetters;
            String line = scanner.nextLine();
            for(int i = 0; i < line.length() - 1; i++) {
                int count = 1;
                for(int j = i + 1; j < line.length(); j++) {
                    if(line.charAt(i) == line.charAt(j)) {
                        count++;
                    }
                }
                if(count == 3 && prevTriple == tripleLetters) {
                    tripleLetter = line.charAt(i);
                    tripleLetters++;
                }
                if(count == 2 && line.charAt(i) != tripleLetter && prevDouble == doubleLetters)
                    doubleLetters++;
            }
            tripleLetter = ' ';
        }
        scanner.close();
        return doubleLetters * tripleLetters;
    }
    
    public static String getChecksumB(File file) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        scanner.close();
        int difference = 0;
        String id =  "";

        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i; j < list.size(); j++) {
                difference = 0;
                for(int k = 0; k < list.get(i).length(); k++) {
                    if(list.get(i).charAt(k) != list.get(j).charAt(k)) {
                        difference++;
                    }
                }
                if(difference == 1) {
                    for(int k = 0; k < list.get(i).length(); k++) {
                        if(list.get(i).charAt(k) == list.get(j).charAt(k))
                            id += list.get(i).charAt(k);
                    }
                    return id;
                }
            }
        }
        return id;
    }
}