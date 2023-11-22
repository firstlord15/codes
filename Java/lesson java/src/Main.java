
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String way = "result.txt";
        String way2 = "result2.txt";

        if (new File(way).delete() || new File(way2).delete()) {
            System.out.println("Файлы удалены");
        }

        StringBuilder stringBuilder = new StringBuilder();
        String string = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Пиши че хочешь: ");
        while (true) {
            String text = scanner.next();
            stringBuilder.append(text).append("\n");

            try(FileOutputStream fileOutputStream = new FileOutputStream(way, true)){
                String newText = text + "\n";
                fileOutputStream.write(newText.getBytes());
            } catch (IOException e){
                e.printStackTrace();
            }

            if (text.equals("1")){
                try (FileOutputStream newFileOutputStream = new FileOutputStream(way2)){
                    newFileOutputStream.write(stringBuilder.toString().getBytes());
                } catch (IOException e){
                    e.printStackTrace();
                }

                break;
            }
        }
    }
}