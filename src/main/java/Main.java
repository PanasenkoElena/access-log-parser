import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            Fraction f1, f2, f3, f4, newFraction = null;
            f1 = new Fraction(1,3);
            f2 = new Fraction(2,5);
            f3 = new Fraction(7,8);
            f4 = new Fraction(5);

            newFraction = fractionSum(f1,f2);
            System.out.println("1/3+2/5 = "+newFraction.toString());
            newFraction = fractionSum(newFraction,f3);
            System.out.println("1/3+2/5+7/8 = "+newFraction.toString());
            newFraction= fractionDifference(newFraction,f4);
            System.out.println("1/3+2/5+7/8-5 = "+newFraction.toString());

        }
    }

    private static Fraction fractionDifference(Fraction f1, Fraction f2) {
        int ax = f1.getNumerator();
        int ay = f1.getDenominator();

        int bx = f2.getNumerator();
        int by = f2.getDenominator();

        int sumOfNumerators = ax * by - bx * ay;
        int commonDenominator = ay * by;
        Fraction result = new Fraction(sumOfNumerators, commonDenominator);
        return result;
    }

    private static Fraction fractionSum(Fraction f1, Fraction f2) {
        int ax = f1.getNumerator();
        int ay = f1.getDenominator();

        int bx = f2.getNumerator();
        int by = f2.getDenominator();

        int sumOfNumerators = ax * by + bx * ay;
        int commonDenominator = ay * by;
        Fraction result = new Fraction(sumOfNumerators, commonDenominator);
        return result;
    }
}