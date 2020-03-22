import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь:");
        String path = scanner.next();

        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);


    }
}
