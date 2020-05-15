package com.mindtree.kalinga.EasyBucks.base;

import java.io.IOException;
import java.util.ArrayList;

import com.mindtree.kalinga.EasyBucks.utils.ExcelUtil;

public class RowDataReader {

	public ArrayList rowDataReader(String keyword, String testCase) throws IOException {
		int rowNum = 0;
		ArrayList<String> al = new ArrayList<String>();
		ExcelUtil excel = new ExcelUtil();
		int startNum = excel.getStartRow("Data", keyword);
		int endNum = excel.getEndRow("Data", startNum);
		//System.out.println(startNum+"***"+endNum);
		for (int i = startNum; i <= endNum; i++) {
			String data = excel.getRowNumData("Data", i, testCase);
			//System.out.println(data);
			if (testCase.trim().equalsIgnoreCase(data)) {
				rowNum = i;
				
				

			}
		}
		
		int colNum = excel.getLastColNum("Data", keyword);
		
		for (int col = 2; col < colNum; col++) {
			String data = excel.getColNumData("Data", rowNum, col);
			
			al.add(data);
		}

		return al;
	}

	/*public static void main(String[] args) {
		RowDataReader row = new RowDataReader();
		try {
			////System.out.println(row.rowDataReader("AddProductsStocks", "Adding Stocks product"));
			////System.out.println(row.rowDataReader("AddProductsMF", "Adding mutual funds product"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
