import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class main {
    public static void main(String[] args) {
        String filePath = null;
        String sear = null;
        try {
            filePath = args[0];
            sear = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error! Enter arguments! First - filePath, second - Search string");
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter("result.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Path> files = null;
        try {
            files = Files.walk(Paths.get(filePath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error! Enter arguments! (folderPath)");
        }

        for (Path file : files) {
            System.out.println("File: " + file);
            try {
                writer.write("File:" + file + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<String> lines = null;
            try {
                lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.out.println("Error! Enter arguments! (filePath)");
            }

            for (String str : lines) {
                if (str.contains(sear)) {
                    try {
                        writer.write(str + "\n");
                        System.out.println("Find in: " + (lines.indexOf(str) + 1) + " / " + lines.size());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
