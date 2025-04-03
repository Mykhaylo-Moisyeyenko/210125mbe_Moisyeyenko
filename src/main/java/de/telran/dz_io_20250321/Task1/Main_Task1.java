package de.telran.dz_io_20250321.Task1;
//1. Написать приложение, которое будет копировать информацию из файла в другой файл.
//    Путь к существующему файлу и имя нового файла нужно вводить с клавиатуры.

import java.io.*;
import java.util.Scanner;

public class Main_Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите полный путь (с именем файла) к исходному файлу для копировния: ");
        String file1 = scanner.nextLine();

        System.out.println("Введите полный путь (с именем) для нового файла: ");
        String file2 = scanner.nextLine();

        File sourceFile = new File(file1);

        boolean isExistSourceFile = sourceFile.exists();
        boolean isFileSourceFile = sourceFile.isFile();

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        if (isExistSourceFile && isFileSourceFile) {
            System.out.println("Исходный файл существует и является файлом");
            File targetFile = new File(file2);
            try {
                boolean isCreate = targetFile.createNewFile();
                System.out.println("Новый файл для записи создан корректно: " + isCreate);

                inputStream = new FileInputStream(sourceFile);
                outputStream = new FileOutputStream(targetFile);

                byte[] buffer = new byte[4096];
                int bytesReaded = 0;
                bytesReaded = inputStream.read(buffer);
                while (bytesReaded != -1){
                    outputStream.write(buffer, 0, bytesReaded);
                    bytesReaded = inputStream.read(buffer);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла: " + e);
                throw new RuntimeException(e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else
            System.out.println("Исходный файл отсутствует или является папкой");
    }
}
