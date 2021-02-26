package org.inputouput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;

public class WritingBytes {

    public static void main(String[] args) {

        String pathname = "files/ints.bin.gz";
        File file = new File(pathname);

        try (OutputStream os = new FileOutputStream(file);) {

            GZIPOutputStream gzos = new GZIPOutputStream(os);
            DataOutputStream dos = new DataOutputStream(gzos);

            dos.write(10);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Path path = Paths.get(pathname);
            long size = Files.size(path);
            System.out.println(path + "size: " + size);
        } catch (IOException e) {

        }
    }
}
