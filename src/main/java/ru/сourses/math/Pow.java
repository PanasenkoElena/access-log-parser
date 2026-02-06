package ru.сourses.math;

public class Pow {
double pow;

    public Pow(double pow) {
        this.pow = pow;
    }

    public double getPow() {
        return pow;
    }

    public void setPow(double pow) {
        this.pow = pow;
    }

    public static double pow (String s1,String s2){
        int x=Integer.parseInt(s1);
        int y=Integer.parseInt(s2);
        double pow= Math.pow(x,y);
        return pow;
    }
}
