package de.telran.dz_io_20250321.Task2;
//Написать приложение, которое будет копировать содержимое одной папки в другую
// со всеми вложениями (другие папки, файлы).
//Путь к существующей папке и имя новой папки нужно вводить с клавиатуры.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main_Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите полный путь к исходной папке для копирования: ");
        String folder1 = scanner.nextLine();

        System.out.println("Введите полный путь для новой папки: ");
        String folder2 = scanner.nextLine();

        File targetFolder = new File(folder2);
        if (targetFolder.exists()) {
            targetFolder.mkdirs();
            System.out.println("Каталог для копирования создан");
        }

        File sourseFolder = new File(folder1);
        File[] massFoldersAndFiles = sourseFolder.listFiles();

        copyFilesAndFolders(massFoldersAndFiles, targetFolder);
    }

    public static void copyFilesAndFolders(File[] arraySourceFolders, File folder) {
        for (int i = 0; i < arraySourceFolders.length; i++) {
            File newFileOrFolder = new File(folder.getAbsolutePath() + File.separator + arraySourceFolders[i].getName());

            if (arraySourceFolders[i].isFile()) {
                try (FileInputStream inputStream = new FileInputStream(arraySourceFolders[i]);
                     FileOutputStream outputStream = new FileOutputStream(newFileOrFolder)) {

                    byte[] buffer = new byte[4096];
                    int bytesReaded = 0;
                    bytesReaded = inputStream.read(buffer);
                    while (bytesReaded != -1) {
                        outputStream.write(buffer, 0, bytesReaded);
                        bytesReaded = inputStream.read(buffer);
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при создании файла: " + e);
                    throw new RuntimeException(e);
                }
            } else {
                newFileOrFolder.mkdir();
                copyFilesAndFolders(arraySourceFolders[i].listFiles(), newFileOrFolder);
            }
        }
    }
}



