package lesson10.paths_and_files;

import java.io.*;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Transfer {
    public static void main(String[] args) {
        try (
                SeekableByteChannel channel = Files.newByteChannel(Paths.get(""), StandardOpenOption.WRITE);
                BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(""));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(""));
                InputStream inputStream = Files.newInputStream(Paths.get(""));
                OutputStream outputStream = Files.newOutputStream(Paths.get(""));
        ) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
