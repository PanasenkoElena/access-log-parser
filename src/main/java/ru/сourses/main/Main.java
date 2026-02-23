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
    public static void main(String[] args) throws IOException, LineTooLongException {
        {
            String path = "";
            int length = 0;
            System.out.println("Введите путь к файлу");
            path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            System.out.println("fileExists= " + fileExists);
            boolean isDirectory = file.isDirectory();
            System.out.println("isDirectory= " + isDirectory);
            String line, firstBrackets, fragment;
            float yandexBotQ = 0;
            String yBot = "YandexBot";
            float googleBotQ = 0;
            String gBot = "Googlebot";
            float otherQ = 0;
            try {
                FileReader fileReader = new FileReader(file.getAbsoluteFile().getPath());
                BufferedReader reader = new BufferedReader(fileReader);

                while ((line = reader.readLine()) != null) {
                    try {
                        int start = line.indexOf('(');
                        int end = line.indexOf(')');
                        if (start != -1 && end != -1 && end > start) {
                            firstBrackets = line.substring(start + 1, end);
                            String[] parts = firstBrackets.split(";");
                            if (parts.length >= 2) {
                                fragment = parts[1];
                                fragment = fragment.replaceAll("\\s", "");
                                boolean contains = fragment.contains("/");
                                if (contains) {
                                    fragment = fragment.substring(0, fragment.indexOf("/"));
                                }
                                boolean b = fragment.hashCode() == yBot.hashCode() && fragment.equals(yBot);
                                boolean g = fragment.hashCode() == gBot.hashCode() && fragment.equals(gBot);
                                if (b) {
                                    yandexBotQ++;
                                }
                                if (g) {
                                    googleBotQ++;
                                }
                                if (b == false && g == false) {
                                    otherQ++;
                                }
                            }
                        }

                        if (line.length() > 1024) {
                            throw new LineTooLongException("Строка имеет длину более 1024 символа. Выполнение программы остановлено");
                        }
                    } catch (LineTooLongException e) {
                        throw new RuntimeException(e);
                    }
                }
                try (var lines = Files.lines(Path.of(path))) {
                    long count = lines.count();
                    System.out.println("Количество строк: " + count);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                float yandexBotShare = (yandexBotQ / (yandexBotQ + googleBotQ + otherQ)) * 100;
                float googleBotShare = (googleBotQ / (yandexBotQ + googleBotQ + otherQ)) * 100;
                System.out.println("yandexBotShare= " + String.valueOf(yandexBotShare)+"%");
                System.out.println("googleBotShare= " + String.valueOf(googleBotShare)+"%");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }
}