import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            //ввод чисел
            System.out.println("Введите первое число:");
            int firstNumber=new Scanner(System.in).nextInt();
            System.out.println("Введите второе число:");
            int secondNumber=new Scanner(System.in).nextInt();

            //вычисления
            double quoient = (double)firstNumber/secondNumber;
            int sum = firstNumber+secondNumber;
            int difference = firstNumber-secondNumber;
            int multiplication= firstNumber*secondNumber;

            //вывод результатов
            System.out.println("Сумма:"+sum);
            System.out.println("Разность:"+difference);
            System.out.println("Произведение:"+multiplication);
            System.out.println("Частное:"+quoient);
        }
    }
}