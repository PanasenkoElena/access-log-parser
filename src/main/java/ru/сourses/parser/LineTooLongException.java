package ru.сourses.parser;

public class LineTooLongException extends Exception {
    public LineTooLongException(String message) {
        super("Строка имеет длину более 1024 символа. Выполнение программы остановлено"); // Передача сообщения в родительский класс
    }

    public LineTooLongException() {
        super("Строка имеет длину более 1024 символа. Выполнение программы остановлено"); // Передача сообщения в родительский класс
    }
}
