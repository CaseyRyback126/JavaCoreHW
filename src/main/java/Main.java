import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Main {

    private static final Random random = new Random();

    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;

    private static final String TO_SEARCH = "GeekBrains";

    /**
     * 1.  Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
     * 2.  Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     * 3.* Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     * 4.* Написать метод, проверяющий, есть ли указанное слово в папке
     */

    public static void main(String[] args) throws IOException {

        System.out.println(generateSymbols(25));

        writeFileContents("sample01.txt", 25, 3);
        writeFileContents("sample02.txt", 25, 5);

        concatenate("sample01.txt", "sample02.txt", "sample.res.txt");

        System.out.printf("Файл sample.res.txt %s\n",
                searchInFile("sample.res.txt", TO_SEARCH) ?
                        String.format("содержит искомое слово \"%s\".", TO_SEARCH) : "не содержит искомого слова.");

        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "file_" + i + ".txt";
            writeFileContents(fileNames[i], 100, 4);
            System.out.printf("Файл %s создан.\n", fileNames[i]);
        }

        Tree.print(new File("."), "", true);

        File rootDir = new File(".");
        File[] files = rootDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.printf("Файл %s %s\n",
                        files[i].getName(),
                        searchInFile(files[i].getName(), TO_SEARCH) ?
                                String.format("содержит искомое слово \"%s\".", TO_SEARCH) : "не содержит искомого слова.");

            }
        }


        // Папка для резервных копий
        String backupDirectory = "./backup";
        FileBackup.createBackupDirectory(backupDirectory); // Создаем папку для резервных копий
        // Исходная директория
        String sourceDirectory = ".";
        FileBackup.backupFiles(sourceDirectory, backupDirectory); // Создаем резервные копии файлов

    }

    /**
     * Метод генерации некоторой последовательности символов
     *
     * @param size кол-во символов
     * @return последовательность символов
     */
    private static String generateSymbols(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append
                    ((char) random.nextInt((CHAR_BOUND_H - CHAR_BOUND_L + 1) + CHAR_BOUND_L));
        }
        return stringBuilder.toString();
    }

    /**
     * Записать последовательность символов в файл
     *
     * @param fileName
     * @param size
     * @throws IOException
     */
    private static void writeFileContents(String fileName, int size) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(generateSymbols(size).getBytes());
        }
    }

    private static void writeFileContents(String fileName, int size, int words) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < words; i++) {
                if (random.nextInt(8) == 0) {
                    fileOutputStream.write(TO_SEARCH.getBytes());
                } else {
                    fileOutputStream.write(generateSymbols(size).getBytes());
                }
            }

        }
    }

    private static void concatenate(String fileIn1, String fileIn2, String fileOut) throws IOException {

        // Поток на запись
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {

            // Поток на чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn1)) {
                int c;
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }

            // Поток на чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn2)) {
                int c;
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }
        }
    }

    private static boolean searchInFile(String fileName, String search) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            byte[] searchData = search.getBytes();
            int i = 0;
            int c;
            while ((c = fileInputStream.read()) != -1) {
                if (c == searchData[i]) {
                    i++;
                } else {
                    i = 0;
                    if (c == searchData[i])
                        i++;
                    continue;
                }
                if (i == searchData.length) {
                    return true;
                }
            }
            return false;
        }
    }
}
