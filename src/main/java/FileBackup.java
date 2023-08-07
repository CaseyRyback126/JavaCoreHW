import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileBackup {
    public static void main(String[] args) {
        String sourceDirectory = "."; // Исходная директория
        String backupDirectory = "./backup"; // Папка для резервных копий

        createBackupDirectory(backupDirectory); // Создаем папку для резервных копий
        backupFiles(sourceDirectory, backupDirectory); // Создаем резервные копии файлов
    }

    /**
     * Создает папку для резервных копий
     *
     * @param backupDirectory путь к папке для резервных копий
     */
    public static void createBackupDirectory(String backupDirectory) {
        File directory = new File(backupDirectory);

        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Backup directory created: " + backupDirectory);
        }
    }

    /**
     * Создает резервные копии файлов в указанной директории
     *
     * @param sourceDirectory исходная директория
     * @param backupDirectory папка для резервных копий
     */
    public static void backupFiles(String sourceDirectory, String backupDirectory) {
        File directory = new File(sourceDirectory);
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Source directory is empty");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try {
                    File backupFile = new File(backupDirectory + "/" + file.getName());
                    Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File backed up: " + backupFile.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Error creating backup for file: " + file.getAbsolutePath());
                }
            }
        }
    }
}
