import java.io.File;

public class Tree {

    /**
     * TODO: TODO: Доработать метод print, необходимо распечатывать директории и
     * файлы
     * 
     * @param args
     */
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        int subDirTotal = 0;
        int subFileTotal = 0;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            }
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                subFileTotal++;
            }
        }

        int subDirCounter = 0;
        int subFileCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirTotal == ++subDirCounter); 
            } else {
                System.out.print(indent);
                if (subFileTotal == ++subFileCounter) {
                    System.out.print("└─");
                    indent += "  ";
                } else {
                    System.out.print("├─");
                }
                System.out.println(files[i].getName());
            }
        }
    }
}
