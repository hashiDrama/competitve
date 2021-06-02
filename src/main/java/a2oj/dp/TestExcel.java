package a2oj.dp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {

  public static void main(String[] args) throws IOException {
    String fileName = args[0];
    if(fileName.isEmpty()) {
      System.out.println("No file name provided. Run it like: java -jar testExcel.jar <file-name>");
      return;
    }
    FileInputStream fis = new FileInputStream(new File(fileName));
    XSSFWorkbook wb=new XSSFWorkbook(fis);
    XSSFSheet sheet=wb.getSheetAt(0);
    for(Row row : sheet) {
      if(row.getRowNum()==0)continue;
      Cell c1 = row.getCell(1);
      String v = c1.getStringCellValue();
      if(v.isEmpty())continue;
      int idx = v.indexOf("paymentDetails:");
      if(v.charAt(idx + "paymentDetails:".length()) == '[') {
        Cell c2 = row.getCell(2);
        Cell c0 = row.getCell(0);
        System.out.println(c2.getStringCellValue());
      }
//      for(Cell cell : row) {
//        String val = cell.getStringCellValue();
//        //System.out.println(val);
//        int idx = val.indexOf("paymentDetails:");
//        //System.out.println(val.charAt(idx + "paymentDetails:".length()));
//        if(val.charAt(idx + "paymentDetails:".length()) != '[') {
//          System.out.println(val);
//        }
//      }
    }
  }
}
