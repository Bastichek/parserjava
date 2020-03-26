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


        List<Path> files;
        FileWriter writer;
        try {

            files = Files.walk(Paths.get(filePath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            writer = new FileWriter("result.txt", false);

            for (Path path : files) {

                System.out.println("File: " + path);

                writer.write("File:" + path + "\n");

                String line;
                BufferedReader reader;

                reader = new BufferedReader(new FileReader(String.valueOf(path)));
                int i = 1;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(sear)) {
                        writer.write(line + "\n");
                        System.out.println("Find in: " + (i));
                    }
                    i++;

                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
