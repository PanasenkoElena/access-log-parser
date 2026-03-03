package ru.сourses.math;

import java.util.Objects;

public class Fraction extends Number implements Cloneable {
    private int num;
    private int denum;

    //конструктор
    public Fraction(int numerator, int denominator) {
        this.num = numerator;
        if (denominator < 1) {
            throw new IllegalArgumentException("знаменатель должен быть больше 0!");
        }
        this.denum = denominator;//Для целого числа знаменатель будет Null
    }

    public Fraction(int numerator) {
        this.num = numerator;
        this.denum = 1;
    }

    private void copy(Fraction f) {
        f.denum = this.denum;
        f.num = this.num;

    }

    //getter-setter
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenum() {
        return denum;
    }

    public void setDenum(int denum) {
        this.denum = denum;
    }

    //Вывод в строку
    @Override
    public String toString() {
        String fractionString = num + "/" + denum;
        return fractionString;
    }

    @Override
    public int intValue() {
        return (int) (this.num / this.denum);
    }

    @Override
    public long longValue() {
        return (long) (this.num / this.denum);
    }

    @Override
    public float floatValue() {
        return ((float) this.num / (float) this.denum);
    }

    @Override
    public double doubleValue() {
        return ((double) this.num / (double) this.denum);
    }

    public double getSum(double sum) {
        sum = sum + this.doubleValue();
        return sum;
    }

    @Override
    public Fraction clone() throws CloneNotSupportedException {
        Fraction fr = (Fraction) super.clone();
        this.copy(fr);
        return fr;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num && denum == fraction.denum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, denum);
    }
}
