import java.util.Optional;

public final class Fraction {
    private int  numerator;
    private int denominator;

    //конструктор
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator<1) {
            throw new IllegalArgumentException("знаменатель должен быть больше 0!");
        }
        this.denominator = denominator;//Для целого числа знаменатель будет Null
    }

    public Fraction (int numerator){
        this.numerator = numerator;
        this.denominator=1;
    }



    //getter-setter
    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //Вывод в строку
    @Override
    public String toString() {
        String fractionString = numerator + "/" + denominator;
        return fractionString;
    }



}
