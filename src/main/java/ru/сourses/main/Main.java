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
            Scanner scanner = new Scanner(System.in);
            int size = Integer.parseInt(scanner.nextLine());
            ArrayList<Integer> list = new ArrayList<>();
            int buffer;
            for (int i = 1; i <= size; i++) {
                list.add(i);
            }
            System.out.println(list);

            reverse(list);
            System.out.println(list);

        }
    }
    public static void reverse(ArrayList<Integer> intList) {
        int n = intList.size() - 1;
        for (int i = 0; i < intList.size() / 2; i++) {
            int temp = intList.get(i);
            intList.set(i,intList.get(n - i));
            intList.set(n - i,temp);
        }
    }
}