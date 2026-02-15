package ru.сourses.other;

public class Sauces {
    public String name;
    public Sharpness sharpness;

    public Sauces(String name, Sharpness sharpness) {
        this.name = name;
        this.sharpness = sharpness;
    }

    @Override
    public String toString() {
        return "Sauces{" +
                "name='" + name + '\'' +
                ", sharpness=" + sharpness +
                '}';
    }
}
