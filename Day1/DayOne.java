import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class DayOne {

    public static void main(String[]args) {
        try {
            Scanner file = new Scanner(new File("puzzle.txt"));
            System.out.println("Puzzle A: " + getPuzzleA(file));
            System.out.println("Puzzle B: " + getPuzzleB(new File("puzzle.txt")));      
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static int getPuzzleA(Scanner file) {
        int num = 0;
        while(file.hasNextLine()) {
            String line = file.nextLine();
            if(line.charAt(0) == '+') {
                num += Integer.parseInt(line.substring(1));
            } else {
                num -= Integer.parseInt(line.substring(1));
            }
        }
        return num;
    }

    public static int getPuzzleB(File file) throws IOException{
        Scanner fileScanner = new Scanner(file);
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(fileScanner.nextInt());
        boolean found = false;
        while(!found) {
            if(fileScanner.hasNextInt()) {
                int nextInt = fileScanner.nextInt();
                if(list.contains(list.get(list.size() - 1) + nextInt))
                    return nextInt + list.get(list.size() - 1);
                list.add(nextInt + list.get(list.size() - 1));
            } else {
                fileScanner = new Scanner(file);
            }
        }
        return 0;
    }
}