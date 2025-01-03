package sg.darren.ms.file.rename;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DeleteDuplicatePhotos {

    // =IF(A2=A1,1,"")

    public static void main(String[] args) throws Exception {
        String filename = "C:/Users/xueyu/Downloads/duplicate-20250103-1.txt";
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
                if (file.exists()) {
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
}
