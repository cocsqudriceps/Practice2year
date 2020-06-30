import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class Reader {
    public static void Read() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("C:/Users/Cocs/IdeaProjects/untitled/src/main/resources/Table.xlsx")));
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            boolean flag = false;

            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {

                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellType();

                if (cellType == NUMERIC)
                    arr[i] = (int) cell.getNumericCellValue();
                else if (cellType == STRING)
                    flag = true;
            }

            Dijkstra.graph.add(new Structure(arr[0], arr[1], arr[2]));
        }
    }
}

