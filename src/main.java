import java.io.*;
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
            System.out.println("Error! Wrong argument! (folder)");
        }

        for (Path path : files) {

            System.out.println("File: " + path);
            try {
                writer.write("File:" + path + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }


            String line;
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(String.valueOf(path)));
                int i = 1;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(sear)) {
                        writer.write(line + "\n");
                        System.out.println("Find in: " + (i));
                    }
                    i++;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
