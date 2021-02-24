package org.inputouput;

import java.awt.print.Pageable;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderInAction {

    public static void main(String[] args){

        Path path = Paths.get("files/bat-weasels.txt");

        //System.out.println(file.getName());
        //System.out.println(file.exists());

        /*File nope = new File ("files/nope.txt");
        System.out.println(nope.getName());
        System.out.println(nope.exists());
        nope.createNewFile();*/

        try (Stream<String> lines = Files.newBufferedReader(path).lines()) {

            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
