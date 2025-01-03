package sg.darren.ms.file.rename;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ScanDuplicatePhotos {

    public static void main(String[] args) throws Exception {
        String filename = "H:/Photos";
        try (Stream<Path> stream = Files.walk(Paths.get(filename))) {
            AtomicInteger total = new AtomicInteger();
            stream.forEach(item -> {
                if (Files.isRegularFile(item)) {
                    total.addAndGet(1);
                }
                System.out.println("[" + format(total.get()) + "]" + item.toAbsolutePath());
            });
        }
    }

    private static String format(int in) {
        return String.format("%05d", in);
    }

}

