package Login;

import java.util.List;

public class dataReaders {

	public static String filenameCsv = "C:\\Selenium\\UserAccounts.csv";
	public static String filenameXls = "C:\\Selenium\\UserLogin.xls";
	
	public static void main(String[] args) {
		 readCSV();
		 readXLS();
	}
	
	//----
	public static void readCSV() {
		List <String[]> records = utilities.csvImport.read(filenameCsv);
		for (String[] record : records) {
			//System.out.println(count);
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	//----
	
	public static void readXLS() {
		String[][] data = utilities.ExcelReader.getXLS(filenameXls);
			for (String[] record : data) {
				System.out.print("\nNEW RECORD\n");
				System.out.println(record[0]);
				System.out.println(record[1]);
				System.out.println(record[2]);
			}
	}
	
}
