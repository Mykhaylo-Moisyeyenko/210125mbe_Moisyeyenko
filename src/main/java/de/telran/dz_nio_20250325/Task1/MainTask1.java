package de.telran.dz_nio_20250325.Task1;

//Написать приложение, которое будет копировать информацию из файла в другой файл
//с использованием NIO.
//Путь к существующему файлу и имя нового файла нужно вводить с клавиатуры.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MainTask1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите полный путь (с именем файла) к исходному файлу для копирования: ");
        String file1 = scanner.nextLine();

        System.out.println("Введите полный путь (с именем) для нового файла: ");
        String file2 = scanner.nextLine();

        Path sourceFilePath = Path.of(file1);
        Path targetFilePath = Path.of(file2);

        String string;
        try (BufferedReader reader = Files.newBufferedReader(sourceFilePath);
                BufferedWriter writer = Files.newBufferedWriter(targetFilePath)) {
            while ((string = reader.readLine()) != null) {
                writer.write(string);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
