package Chapter10;
import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        //File path
        String filePath = "src/test/resources/Hobbies.txt";

        //Create a file resource
        File hobbiesFile = new File(filePath);

        try {
            PrintStream pen = new PrintStream(new FileOutputStream(hobbiesFile,true));
            //FileOutputStream b = new FileOutputStream(hobbiesFile);

                //write to a file
                //hobbiesFile.createNewFile();
                pen.println("Tennis");
                pen.println("Soccer");
                pen.println("Hiking");
            pen.close();

        } catch (FileNotFoundException ex) {
            System.err.println("File not found..." + ex.getMessage());
        } catch (IOException e) {
            System.err.println("Cannot write to the file");
        }


        System.out.println("Abs Path: " + hobbiesFile.getAbsolutePath());
        System.out.println("Path: " + hobbiesFile.getPath());

    }
}
