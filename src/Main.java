//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        for (int i = 1; i <= 5; i++) System.out.println("i = " + i);


        //Advent of Code 2024 Day 2 Scratch Paper
        String filePath = "src/input.txt";  // adjust if needed
        int safeCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> levels = parseLine(line);
                if (isSafe(levels)) {
                    safeCount++;
                }
            }
            System.out.println("Safe reports: " + safeCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static List<Integer> parseLine(String line) {
        String[] tokens = line.trim().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        for (String t : tokens) {
            nums.add(Integer.parseInt(t));
        }
        return nums;
    }

    private static boolean isSafe(List<Integer> levels) {
        if (levels.size() < 2) return false;

        boolean increasing = levels.get(1) > levels.get(0);
        for (int i = 0; i < levels.size() - 1; i++) {
            int diff = levels.get(i + 1) - levels.get(i);
            if (diff == 0 || Math.abs(diff) > 3) return false;
            if ((diff > 0) != increasing) return false;
        }
        return true;
    }
}