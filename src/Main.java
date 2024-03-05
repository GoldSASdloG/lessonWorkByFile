import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/serggold/Library/Mobile Documents/com~apple~CloudDocs/" +
                "Gid_GoldSA/lessonWorkByFile/dataBase/test.txt");
        Date date = new Date(file.lastModified());

        System.out.println(date);

        System.out.println(file.isFile());

        System.out.println(file.isDirectory());

        File file11 = new File("/Users/serggold/Library/Mobile Documents/com~apple~CloudDocs/" +
                "Gid_GoldSA/lessonWorkByFile");
//        Arrays.stream(file11.listFiles()).forEach(f -> System.out.println(f.getAbsoluteFile()));
        print(file11);
        //
        System.out.println(file11.length());
        //
        try {
            List<String> strings = Files.readAllLines(Path.of("dataBase/test.txt"));
            strings.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void print(File file11) {
        if(file11.isDirectory()){
            Arrays.stream(file11.listFiles()).forEach(f -> print(f));
        }
        if(file11.isFile()) {
            System.out.println(file11.getAbsolutePath());
        }
    }
}