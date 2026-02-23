package ru.сourses.main;

import ru.сourses.parser.LineTooLongException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LineTooLongException, IOException,LineTooLongException {
        {
            String path = "";
            int correctPathsNum = 0, fileNum = 0,numOfLines=0, longestLine=0, length=0;
            int shortestLine=1024;
            String summary = "Номера файлов:";

                System.out.println("Введите путь к файлу");
                path = new Scanner(System.in).nextLine();
                File file = new File(path);
                boolean fileExists = file.exists();
            System.out.println("fileExists= "+fileExists);
                boolean isDirectory = file.isDirectory();
            System.out.println("isDirectory= "+isDirectory);
            try {
                FileReader fileReader = new FileReader(file.getAbsoluteFile().getPath());
                BufferedReader reader =
                        new BufferedReader(fileReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.length() > 1024) {
                        throw new LineTooLongException("Строка имеет длину более 1024 символа. Выполнение программы остановлено");
                    }
                    length = line.length();
                    if (length < shortestLine) {
                        shortestLine = length;
                    }
                    if (length > longestLine) {
                        longestLine = length;
                    }}
                } catch(RuntimeException | IOException ex){}

            try (var lines = Files.lines(Path.of(path))) {
                long count = lines.count();
                System.out.println("Количество строк: " + count);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Самая короткая строка имеет количество символов: " + shortestLine);
            System.out.println("Самая длинная строка имеет количество символов: " + longestLine);
   // ___________
        }
    }
}
