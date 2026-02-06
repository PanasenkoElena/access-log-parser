import java.util.Optional;

public class Fraction extends Number{
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
 @Override
    public int intValue(){
        return (int) (this.num/this.denum);
    }
    @Override
    public long longValue(){
        return (long) (this.num/ this.denum);
    }
    @Override
    public float floatValue(){
        return ((float)this.num/(float)this.denum);
    }
    @Override
    public double doubleValue(){
        return  ((double)this.num/(double)this.denum);
    }
    double getSum(double sum){
     sum=sum+this.doubleValue();
        return sum;
    }
}
