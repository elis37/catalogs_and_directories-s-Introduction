package Task1_Install;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static String pathDirectoryGames = "C://Users//Asus//Desktop//JavaCore//Games";
    private static String pathDirectorySrc = "C://Users//Asus//Desktop//JavaCore//Games//src";
    private static String pathDirectoryRes = "C://Users//Asus//Desktop//JavaCore//Games//res";

    private static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        log.append("Start program" + "\n");
        File directory = new File(pathDirectoryGames);
        if (directory.mkdir()) {
            log.append("Директория \"Games\" создана" + "\n");
        } else {
            log.append("Указанная директория \"Games\" уже существует" + "\n");
        }

        makeDirectory(pathDirectoryGames, "src");
        makeDirectory(pathDirectoryGames, "res");
        makeDirectory(pathDirectoryGames, "saveGames");
        makeDirectory(pathDirectoryGames, "temp");

        makeDirectory(pathDirectorySrc, "main");
        makeDirectory(pathDirectorySrc, "test");

        File myFile = new File("C://Users//Asus//Desktop//JavaCore//Games//src//Main.java");
        try {
            if (myFile.createNewFile())
                log.append("Файл \"Main.java\" создан" + "\n");
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }

        myFile = new File("C://Users//Asus//Desktop//JavaCore//Games//src//Utils.java");
        try {
            if (myFile.createNewFile())
                log.append("Файл \"Utils.java\" создан" + "\n");
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }

        makeDirectory(pathDirectoryRes, "drawables");
        makeDirectory(pathDirectoryRes, "vectors");
        makeDirectory(pathDirectoryRes, "icons");

        myFile = new File("C://Users//Asus//Desktop//JavaCore//Games//temp//temp.txt");
        try {
            if (myFile.createNewFile())
                log.append("Файл \"temp.txt\" создан" + "\n");
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }
        log.append("End program" + "\n");

        try (FileWriter writer = new FileWriter("C://Users//Asus//Desktop//JavaCore//Games//temp//temp.txt", false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void makeDirectory(String pathDirectory, String nameNewDirectory) {
        StringBuilder newPathDirectory = new StringBuilder(pathDirectory);
        newPathDirectory.append("//");
        newPathDirectory.append(nameNewDirectory);

        File newDirectory = new File(newPathDirectory.toString());
        if (newDirectory.mkdir()) {
            log.append("Директория \"" + nameNewDirectory + "\" создана" + "\n");
        } else {
            log.append("Указанная директория \"" + nameNewDirectory + "\" существует" + "\n");
        }
    }
}

