package Chapter10;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromExcel {

    public static void main(String[] args){
        String filePath = "src/test/resources/Results-v2.xlsx";
        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for(int i = 0; i < sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);
                for(int col = 0; col < row.getLastCellNum(); col++){
                    Cell cell = row.getCell(col);
                    System.out.println(cell + "\t");
                }
                System.out.println();
            }
            fileInput.close();
            workbook.close();


        }catch(IOException e){
            System.err.println(e.getMessage());
        }

    }
}
