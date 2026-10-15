package Chapter10;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteToExcel {
    public static void main(String[] args){
        String filePath = "src/test/resources/Cities.xlsx";

        try {
            OutputStream fileWriter = new FileOutputStream(filePath);
            //create a workbook object
            XSSFWorkbook workbook = new XSSFWorkbook();
            //create a spreadsheet inside the workbook
            XSSFSheet sheet = workbook.createSheet("Cities");
            //create a header row
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("City");
            header.createCell(1).setCellValue("Population");
            //create row 1
            XSSFRow row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("Centurion");
            row1.createCell(1).setCellValue("500000");

            XSSFRow row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("Kempton Park");
            row2.createCell(1).setCellValue("100000");

            workbook.write(fileWriter);
            fileWriter.close();
            workbook.close();
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
