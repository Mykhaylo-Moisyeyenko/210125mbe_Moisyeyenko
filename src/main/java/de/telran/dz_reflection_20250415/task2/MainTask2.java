package de.telran.dz_reflection_20250415.task2;

//2*. Используя только Reflection API и библиотеку NIO,
//создайте файл и сохраните в него строку "Я тестирую работу
//Reflection API при работе с NIO".

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainTask2 {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String str = new String("Я тестирую работу Reflection API при работе с NIO");
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

            //обычный путь побайтово:
//        Path path = Path.of("250415_dz_reflection.txt");
//        Files.write(path, bytes);
//        или построчно:
//        Files.writeString(path,str);

            //запись с использованием Reflection:

        Class<?> clazzPath = Path.class;// получаю ссылку на класс Path
        Class<?> clazzFiles = Files.class;//получаю ссылку на класс Files

        //выясняю методы всех типов:
//        Method[] allMethodsPath = clazzPath.getDeclaredMethods();
//        for (Method methods : allMethodsPath)
//            System.out.println("Все методы: " + methods);

        //найдено 2 нужных метода у Path:
//        Path.of(java.lang.String,java.lang.String[])
//        Path.of(java.net.URI)

        //получаю метод path.of и запускаю его, результат сохраняю в Object:
        Method methodPath = clazzPath.getMethod("of", String.class, java.lang.String[].class);
        Object pathForNewFile = methodPath.invoke(null, "250415_dz_reflection.txt", new java.lang.String[0]);

        //выясняю методы всех типов у Files:
//        Method[] allMethodsFiles = clazzFiles.getDeclaredMethods();
//        for (Method methods : allMethodsFiles)
//            System.out.println("Все методы: " + methods);

// найдено пять методов для записи:
//Files.write(java.nio.file.Path,java.lang.Iterable,java.nio.file.OpenOption[]) throws java.io.IOException
//Files.write(java.nio.file.Path,java.lang.Iterable,java.nio.charset.Charset,java.nio.file.OpenOption[]) throws java.io.IOException
//Files.write(java.nio.file.Path,byte[],java.nio.file.OpenOption[]) throws java.io.IOException
//Files.writeString(java.nio.file.Path,java.lang.CharSequence,java.nio.file.OpenOption[]) throws java.io.IOException
//Files.writeString(java.nio.file.Path,java.lang.CharSequence,java.nio.charset.Charset,java.nio.file.OpenOption[]) throws java.io.IOException

        //запись побайтово:
        Method methReflection = clazzFiles.getMethod("write", Path.class, byte[].class, java.nio.file.OpenOption[].class);
        methReflection.setAccessible(true);
        methReflection.invoke(null, pathForNewFile, bytes, new java.nio.file.OpenOption[0]);

        //запись построчно (альтернативно):
//        Method methodWriteString = clazzFiles.getMethod("writeString",
//                Path.class, CharSequence.class, java.nio.file.OpenOption[].class);
//        methodWriteString.setAccessible(true);
//        methodWriteString.invoke(null, pathForNewFile, str, new java.nio.file.OpenOption[0]);
    }
}
