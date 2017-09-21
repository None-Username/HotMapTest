/**
 * Created by Jason_Liu on 2017/9/15.
 */
import  java.io.*;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

public class ChangeTSV  {
    public static void read() throws Exception{
        jxl.Workbook readwb = null;
        InputStream instream = new FileInputStream("basketball statics.xls");
        readwb = Workbook.getWorkbook(instream);

        Sheet readsheet = readwb.getSheet(0);
        int rsColumns = readsheet.getColumns();
        int rsRows = readsheet.getRows();

        FileWriter fw = new FileWriter("data_heatmap.tsv");

        fw.write("row_idx\tcol_idx\tlog2ratio\r\n");
        for (int j = 1; j < rsColumns; j++){
            for (int i = 1; i < rsRows; i++){
                Cell cell = readsheet.getCell(j, i);
                fw.write(j+"\t"+i+"\t"+cell.getContents()+"\r\n");
                if(j>=16){
                    System.out.print(cell.getContents()+" ");
                }
                fw.flush();
            }
            System.out.println(j);
        }
        fw.close();
    }
    public static void name() throws Exception{
        jxl.Workbook readwb = null;
        InputStream instream = new FileInputStream("basketball statics.xls");
        readwb = Workbook.getWorkbook(instream);

        Sheet readsheet = readwb.getSheet(0);
        int rsColumns = readsheet.getColumns();
        int rsRows = readsheet.getRows();

        FileWriter fw = new FileWriter("namearr.txt");

        fw.write("[");
        System.out.print("[");
        for (int i = 1; i < rsColumns; i++){
            Cell cell = readsheet.getCell(i, 0);
            fw.write("\'"+cell.getContents()+"\'");
            System.out.print("\'"+cell.getContents()+"\'");
            if(i != rsColumns-1){
                fw.write(",");
                System.out.print(",");
            }
        }

        fw.write("]");
        System.out.println("]");
    }
    public static void pnum(int num){
        System.out.print("[");
        for (int i = 1; i <= num; i++){
            System.out.print(i);
            if(i != num){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    public static void main(String args[]){
        try {
            read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
