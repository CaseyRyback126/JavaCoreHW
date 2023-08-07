import java.io.File;


/**
 * TODO: Доработать метод print, необходимо распечатать директории и файлы на экран
 */
public class Tree {
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                int subDirTotal = 0;
                int fileTotal = 0;
                for (File subFile : files) {
                    if (subFile.isDirectory()) {
                        subDirTotal++;
                    } else {
                        fileTotal++;
                    }
                }

                int subDirCounter = 0;
                int fileCounter = 0;
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        subDirCounter++;
                        print(files[i], indent, subDirCounter == subDirTotal && fileCounter == fileTotal);
                    } else {
                        fileCounter++;
                        print(files[i], indent, fileCounter == fileTotal);
                    }
                }
            }
        }
    }
}
