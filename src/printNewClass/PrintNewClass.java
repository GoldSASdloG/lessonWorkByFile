package printNewClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrintNewClass {
    public static void main(String[] args) {
        List<String> listTest = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            listTest.add(String.valueOf(i));
        }
        try {
            Files.write(Path.of("dataBase/newTest.txt"), listTest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File fileed = new File("dataBase/newTest.txt");
        Date dte = new Date(fileed.lastModified());
        System.out.println(dte);

        try {
            Files.copy(Path.of("dataBase/newTest.txt"), Path.of("dataBase/newTest222.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
