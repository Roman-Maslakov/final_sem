import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    static File dir = new File(".");
    static File backup = new File("./backup/");

    public static void main(String[] args) throws IOException {
        
        try {
            backup.mkdir();
            backup(dir, backup);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void backup(File from, File to) throws IOException {

        int c = 0;
        for (File file : from.listFiles()) {

            if (file.isFile() && !file.getName().equals("Main.java")) {
                File copy = new File(to.getAbsolutePath() + "/" + file.getName());
                try (FileInputStream in = new FileInputStream(file);
                        FileOutputStream out = new FileOutputStream(copy)) {
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                }

            } else if (file.isDirectory() && !file.getName().equals("backup")) {

                File copyDir = new File(to.getAbsolutePath() + "/" + file.getName());
                copyDir.mkdir();
                backup(file, copyDir);
            }
        }
    }
}