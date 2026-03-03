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
            List<Integer> list = new ArrayList<>();
            int buffer;
            for (int i = 1; i <= size; i++) {
                list.add(i);
            }
            for (int i = 0; i < list.size(); i += 2) {
                buffer = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, buffer);
            }
            System.out.println(list);

            int[] intArray = list.stream().mapToInt(i -> i).toArray();

            bubbleSort(intArray);
            System.out.println(Arrays.toString(intArray));
        }
    }

    public static void bubbleSort(int[] intArray) {
        for (int i = 0; i < Arrays.stream(intArray).count() - 1; i++) {
            for (int j = 0; j < Arrays.stream(intArray).count() - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
    }
}