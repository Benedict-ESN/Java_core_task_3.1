package ru.kamraze;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static StringBuilder logBuilder = new StringBuilder();
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("На каком диске установить игру?");
            String disk = scanner.nextLine();

            File gamesDirectory = new File(disk + ":\\Games");
            if (!gamesDirectory.exists()) {
//              boolean created = gamesDirectory.mkdir();
//              writeToFile("Games directory " + (gamesDirectory.mkdir() ? "successfully" : "unsuccessfully") + " created", "temp.txt");
                logBuilder.append("Games directory ").append(gamesDirectory.mkdir() ? "successfully" : "unsuccessfully").append(" created\n");

            }

            String[] directories = {"temp", "src", "res", "savegames"};
            for (String directoryName : directories) {
                File directory = new File(gamesDirectory, directoryName);
//              boolean created = directory.mkdir();
//              writeToFile(directoryName + " directory " + (directory.mkdir() ? "successfully" : "unsuccessfully") + " created", "temp.txt");
                logBuilder.append(directoryName).append(" directory ").append(directory.mkdir() ? "successfully" : "unsuccessfully").append(" created\n");
            }

            String[] srcSubdirectories = {"main", "test"};
            for (String subdirectoryName : srcSubdirectories) {
                File subdirectory = new File(gamesDirectory + "\\src", subdirectoryName);
//              boolean created = subdirectory.mkdir();
//              writeToFile(subdirectoryName + " directory " + (subdirectory.mkdir() ? "successfully" : "unsuccessfully") + " created", "temp.txt");
                logBuilder.append(subdirectoryName).append(" directory ").append(subdirectory.mkdir() ? "successfully" : "unsuccessfully").append(" created\n");

                if (subdirectoryName.equals("main")) {
                    try {
                        File mainJavaFile = new File(subdirectory, "Main.java");
//                      boolean fileCreated = mainJavaFile.createNewFile();
//                      writeToFile("Main.java file " + (mainJavaFile.createNewFile() ? "successfully" : "unsuccessfully") + " created", "temp.txt");
                        logBuilder.append("Main.java file ").append(mainJavaFile.createNewFile() ? "successfully" : "unsuccessfully").append(" created\n");
                        File utilsJavaFile = new File(subdirectory, "Utils.java");
//                      fileCreated = utilsJavaFile.createNewFile();
//                      writeToFile("Utils.java file " + (utilsJavaFile.createNewFile() ? "successfully" : "unsuccessfully") + " created", "temp.txt");
                        logBuilder.append("Utils.java file ").append(utilsJavaFile.createNewFile() ? "successfully" : "unsuccessfully").append(" created\n");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            String[] resDirectories = {"drawables", "vectors", "icons"};
            for (String directoryName : resDirectories) {
                File directory = new File(gamesDirectory + "\\res", directoryName);
//              boolean created = directory.mkdir();
//              writeToFile(directoryName + " directory " + (directory.mkdir() ? "successfully" : "unsuccessfully") + " created", "temp.txt");
                logBuilder.append(directoryName).append(" directory ").append(directory.mkdir() ? "successfully" : "unsuccessfully").append(" created\n");
            }

            try {
                File tempFile = new File(gamesDirectory + "\\temp", "temp.txt");
//              boolean fileCreated = tempFile.createNewFile();
//              writeToFile("temp.txt file " + (tempFile.createNewFile() ? "successfully" : "unsuccessfully") + " created", "temp.txt");
                logBuilder.append("temp.txt file ").append(tempFile.createNewFile() ? "successfully" : "unsuccessfully").append(" created\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        if (new File(new File(gamesDirectory, "temp"), "temp.txt").exists()) {
            writeToFile(String.valueOf(logBuilder),gamesDirectory + "\\temp\\temp.txt");
            System.out.println("Все директории и файлы успешно созданы.");
        } else {
            System.out.println("Файл temp.txt не существует в директории temp.");
            System.out.println(String.valueOf(logBuilder));
        }

        }

    private static void writeToFile(String text, String fileName) {

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}