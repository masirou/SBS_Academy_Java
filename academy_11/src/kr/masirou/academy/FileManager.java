package kr.masirou.academy;

import java.io.*;

public class FileManager {
    private static FileManager instance;

    public static FileManager getInstance() {
        if (instance == null) instance = new FileManager();
        return instance;
    }

    private File file;

    private FileManager() {
        file = new File("test.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("파일이 생성됬습니다");
            } catch (IOException e) {
                file = null;
                System.out.println("파일을 생성할 수 없습니다");

            }
        }

    }

    public void writeString(String string) throws FileException {
        if (file == null) {
            throw new FileException("파일이 null 값입니다");
        }

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(string + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new FileException("파일에 \"" + string + "\" 문자열을 쓸 수 없습니다");
        }

    }

    public void readString() throws FileException {
        if (file == null) {
            throw new FileException("파일이 null 값입니다");
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            String string = bufferedReader.readLine();
            while (string != null) {
                System.out.println(string);
                string = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getString() throws FileException {
        if (file == null) {
            throw new FileException("파일이 null 값입니다");
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return bufferedReader.readLine();


        } catch (Exception e) {
            throw new RuntimeException(e);


        }
    }
}