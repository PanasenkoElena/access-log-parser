package ru.сourses.main;

import ru.сourses.other.Cat;
import ru.сourses.parser.LineTooLongException;
import ru.сourses.parser.LogEntry;
import ru.сourses.parser.Statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, LineTooLongException {
        {Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
            Class<?> c = cat.getClass();
            for (Field field : c.getDeclaredFields()) {
                if (!field.getType().isPrimitive()) {
                    try {
                        field.setAccessible(true);
                        field.set(cat, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(cat);
        }
    }

    }







