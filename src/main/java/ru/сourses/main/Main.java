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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)  {
        { Scanner scanner = new Scanner(System.in);
            ArrayList<String> strs = new ArrayList<>();
            Stream<String> stringStream = Stream.of("стек", "база", "хост", "код", "сайт", "лог", "порт", "файл", "путь", "узел");
            String output=getStringFromStream(stringStream);

            System.out.println(output);
        }


    }

    public static String getStringFromStream(Stream<String> stringStream) {
        return stringStream.collect(Collectors.joining(" "));

    }

}



