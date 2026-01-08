import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            String path = "";
            int correctPathsNum = 0;
            int fileNum = 0;
            String summary = "Номера файлов:";
            do {
                System.out.println("Введите путь к файлу");
                path = new Scanner(System.in).nextLine();
                File file = new File(path);
                boolean fileExists = file.exists();
                boolean isDirectory = file.isDirectory();
                if (!fileExists && isDirectory) {
                    System.out.println("Путь указан НЕверно");
                    //счетчик номеров файлов
                    // fileNum++;
                    continue;
                } else {
                    correctPathsNum++;
                    fileNum++;
                    summary = summary + fileNum + " ";
                    System.out.println("Путь указан верно. " + summary);
                    System.out.println("Число корректных файлов:" + correctPathsNum);
                }
            } while (true);
        }
    }
}
