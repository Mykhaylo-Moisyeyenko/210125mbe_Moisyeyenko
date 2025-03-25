package de.telran.DZ_nio_20250325;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_NIO {

    public static void main(String[] args) {

        Path pathDefault = Paths.get("testFileDef.txt");
        Path pathAbsolut = Path.of("d:/java/projects/students/Java210524/src/main/resources/testFileAbs.txt");
        Path pathRelative = Path.of("src/main/resources/testFileRel.txt");

        System.out.println("Абсолютный путь к файлу -> "+pathDefault.toAbsolutePath());
        System.out.println("getNameCount -> "+pathAbsolut.getNameCount());
        System.out.println("Root -> "+pathAbsolut.getRoot());
        System.out.println("getName -> "+pathRelative.getName(0));
        System.out.println("getName -> "+pathRelative.getName(pathRelative.getNameCount()-1));
        System.out.println("getParent() -> "+pathRelative.getParent());
    }
}
