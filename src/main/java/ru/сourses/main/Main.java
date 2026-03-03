package ru.сourses.main;

import ru.сourses.parser.LineTooLongException;
import ru.сourses.parser.LogEntry;
import ru.сourses.parser.Statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, LineTooLongException {
        {
            ArrayList<LogEntry> logEntry = new ArrayList<>();
            String path = "";
            System.out.println("Введите путь к файлу");
            path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            System.out.println("fileExists= " + fileExists);
            boolean isDirectory = file.isDirectory();
            System.out.println("isDirectory= " + isDirectory);
            String line;
            Statistics statistics = new Statistics();
            long count = 0;
            int i = 0;
            try {
                FileReader fileReader = new FileReader(file.getAbsoluteFile().getPath());
                BufferedReader reader = new BufferedReader(fileReader);
                var lines = Files.lines(Path.of(path));
                count = lines.count();
                System.out.println("Количество строк: " + count);
                while ((line = reader.readLine()) != null) {
                    try {
                        logEntry.add(new LogEntry(line));
                      //  System.out.println(logEntry.get(i).toString());
                        statistics.addEntry(logEntry.get(i));
                      //  System.out.println("Накопленная статистика "+ statistics.toString());
                        i++;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (IOException e) {
            }
            java.text.DecimalFormat df = new java.text.DecimalFormat("###.##");
            String formattedResult = df.format(statistics.getTrafficRate());
            System.out.println("Средний трафик в час = "+ formattedResult);
            System.out.println("Статистика за промежуток от "+statistics.getMinTime()+" до "+statistics.getMaxTime());
        }
        return sum;
    }

    public static List<Double> toNumbers(String string) throws NumberFormatException {
        String str = string.substring(9);
        int spaceCount = 0;
        int i=0;
        List<String> textNumbers = new ArrayList();
        do {
            if (i == str.length() - 1 & str.charAt(i) == ' ') {i++;continue;}
            if (i <= str.length() - 1 & str.charAt(i) != ' ' & textNumbers.size() == spaceCount) {
                textNumbers.add(String.valueOf(str.charAt(i)));i++;
                continue;
            } else if(i <= str.length() - 1 & str.charAt(i) != ' ' & textNumbers.size() > spaceCount) {
                String a = textNumbers.get(spaceCount);
                a += (String.valueOf(str.charAt(i)));
                textNumbers.set(spaceCount, a); i++; continue;
            } else if (i <= str.length() - 1 & str.charAt(i) == ' ' & str.charAt(i + 1) != ' ') {
                spaceCount++; i++; continue;
            } i++;
        }
         while (i < str.length() );

        List<Double> summand = new ArrayList<>();
        boolean isDouble = true;
        String checkTextNumber;
        for (i = 0; i < textNumbers.size(); i++) {
            checkTextNumber = String.valueOf(textNumbers.get(i));
            if (isDouble == checkTextNumber.matches("-?\\d+(\\.\\d+)?")) {
                summand.add(Double.parseDouble(String.valueOf(textNumbers.get(i))));
                System.out.println(summand.get(summand.size() - 1));
            } else {
                summand.add(Double.valueOf(0));
                System.out.println("В позиции " + i + " было не число");
            }
        }
        return summand;
    }

}



