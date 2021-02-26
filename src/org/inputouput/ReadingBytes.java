package org.inputouput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class ReadingBytes {

    public static void main (String[] args) {

        String fileName = "files/ints.bin.gz";

        try {
            Path path = Paths.get(fileName);
            long size = Files.size(path);
            System.out.println(path + "size:" + size);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream(new File(fileName));
             GZIPInputStream gzis = new GZIPInputStream(is);
             DataInputStream dis = new DataInputStream(is);) {

            List<Integer> ints = new ArrayList<>();
            try {
                while (true) {
                    ints.add(dis.readInt());
                }
            } catch (EOFException e) {}
            System.out.println("ints: " + ints.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
