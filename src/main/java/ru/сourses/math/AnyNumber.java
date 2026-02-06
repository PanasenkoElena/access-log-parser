package ru.сourses.math;

public class AnyNumber extends Number implements Sumable {
    double n;

    public AnyNumber(double n) {
        this.n = n;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
    public int intValue(){
        return (int) (this.n);
    }

    @Override
    public long longValue() {
        return (long) (this.n);
    }

    @Override
    public float floatValue() {
        return ((float)this.n);
    }

    @Override
    public double doubleValue() {
        return ((double)this.n);
    }

    public double getSum(double sum){
        sum=sum+this.n;
        return sum;
    }
}
