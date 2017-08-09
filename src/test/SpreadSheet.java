package test;

import java.util.List;

public class SpreadSheet {
	
	public void spreadSheet(){
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "Testdata.xlsx");
        List<String> row = sheetReader.readRow(1, "Input Data");

        for(String cell : row){
            System.out.println(cell);
        }


    }

}
