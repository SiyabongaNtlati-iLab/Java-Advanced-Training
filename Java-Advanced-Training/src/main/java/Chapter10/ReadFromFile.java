package Chapter10;

import java.io.*;

public class ReadFromFile {

    public static void main(String[] args){
        String filePath = "src/test/resources/Modules.txt";

        File moduleFile = new File(filePath);

        try {
            //FileReader reader = new FileReader(moduleFile);

            //opens file for reading
            FileReader fr = new FileReader(moduleFile);
            //reads contents of the file
            BufferedReader br = new BufferedReader(fr);
            //reads line for line
            String text = br.readLine();

            //readsallasstring
            while((text = br.readLine())!=null){
                System.out.println(text);
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
