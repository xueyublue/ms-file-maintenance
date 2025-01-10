package sg.darren.ms.file.rename;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class DeleteDuplicatePhotos {

    // =IF(A2=A1,1,"")

    public static void main(String[] args) throws Exception {
        String filename = "H:/DeleteDuplicatePhotos/duplicate-20250104-4.txt";
        int total = 0;
        int deleted = 0;
        int skipped = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (true) {
                // read line
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                // deletion start
                line = line.replace("/volume1/homes/xueyu", "H:");
                File file = new File(line);
                total = total + 1;
                System.out.println("[" + format(total) + "] exists=" + file.exists() + " " + line);
                if (file.exists() && matchExtension(file.getName())) {
                    deleted = deleted + 1;
                    boolean result = file.delete();
                    System.out.println("deleted=" + deleted + " skipped=" + skipped + " total=" + total);
                } else {
                    skipped = skipped + 1;
                }
                // deletion end
            }
            System.out.println("end result: deleted=" + deleted + " skipped=" + skipped + " total=" + total);
        }
    }

    private static String format(int in) {
        return String.format("%03d", in);
    }

    private static boolean matchExtension(String filename) {
        List<String> extensions = Arrays.asList(".jpg", ".jpeg", ".mov");
        return extensions.stream().anyMatch(item -> filename.toLowerCase().endsWith(item));
    }

}
