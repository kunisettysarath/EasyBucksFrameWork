package com.mindtree.kalinga.EasyBucks.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.DocFlavor.STRING;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	/*
	 * variable created for the excel file reading initialized with null
	 */
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	/*
	 * Zero argument constructor, it will locate the excel sheet through the
	 * property file
	 */
	public ExcelUtil() {
		try {
			fis = new FileInputStream(PropertyUtil.getData("testData"));
			workbook = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/*
	 * This method will fetch cell data according to the parameters provided It
	 * takes Sheet name, Column name and Row name These three parameters will
	 * locate the particular cell to be fetched and return a string data
	 */
	public String getCellData(String sheetName, String colName, String rowName, String keyword) {
		try {
			sheet = workbook.getSheet(sheetName);

			row = sheet.getRow(0);
			int row_Num = 0;
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {

				row = sheet.getRow(i);
				if (row.getCell(1).getStringCellValue().trim().trim().equalsIgnoreCase(rowName.trim())) {

					row_Num = i;

				}
			}
			ExcelUtil excel = new ExcelUtil();
			int startNum = excel.getStartRow(sheetName, keyword);
			int col_Num = 0;
			row = sheet.getRow(startNum - 1);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().trim().equalsIgnoreCase(colName.trim()))
					col_Num = i;
			}

			row = sheet.getRow(row_Num);
			cell = row.getCell(col_Num);

			return String.valueOf(cell.getStringCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	/*
	 * This method will enter the cell data into excel sheet It takes parameter
	 * for the sheet name, column name, row name and the data to be sent
	 */
	public void setCellData(String sheetName, String colName, String rowName, String data) {
		try {
			sheet = workbook.getSheet(sheetName);

			row = sheet.getRow(0);
			int row_Num = 0;
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().trim().equalsIgnoreCase(rowName.trim())) {
					row_Num = i;
				}
			}
			int col_Num = 0;

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}

			row = sheet.getRow(row_Num + 1);
			cell = row.getCell(col_Num);

			cell.setCellValue(data);
			fos = new FileOutputStream(PropertyUtil.getData("output"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * This method is provided to create an excel sheet for a report creation It
	 * will create a report with a file name format as "Report_date_time.xlsx"
	 */
	public void createReportExcelFile() throws IOException {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH.mm.ss");
		Date dateobj = new Date();
		String dateNtime = df.format(dateobj);
		String fileToBeCreated = "./src/test/resources/Result_" + dateNtime + ".xlsx";
		FileOutputStream fos = new FileOutputStream(fileToBeCreated);
		fos.close();
	}

	/*
	 * This method is provided to create an excel sheet with a custom file name
	 * It will take a parameter for the custom filename, and it will create a
	 * file in the location specified
	 */
	public void createExcelFile(String filename) throws IOException {
		String fileLocation = "./src/test/resources/" + filename + ".xlsx";
		FileOutputStream fos = new FileOutputStream(fileLocation);
		fos.close();
	}
	/*
	 * This method is to get the start row of the excel sheet
	 */

	public int getStartRow(String sheetname, String keyword) {

		XSSFSheet sheet1 = workbook.getSheet(sheetname);
		int rowSize = sheet1.getLastRowNum();
		//System.out.println(rowSize);
		int startIndex = 0;
		for (int i = 1; i <= rowSize; i++) {

			String data = sheet1.getRow(i).getCell(0).getStringCellValue();

			if (data.trim().equalsIgnoreCase(keyword)) {
				startIndex = i;
				break;
			}
		}

		return startIndex;
	}

	public int getLastColNum(String sheetname, String keyword) {
		XSSFSheet sheet1 = workbook.getSheet(sheetname);
		int rowSize = sheet1.getLastRowNum();
		int startIndex = 0;
		for (int i = 0; i < rowSize; i++) {

			String data = sheet1.getRow(i).getCell(0).getStringCellValue();
			if (data.trim().equalsIgnoreCase(keyword)) {
				startIndex = i;
				break;
			}
		}
		//System.out.println("startIndes is" + startIndex);
		XSSFRow rows = sheet1.getRow(startIndex);
		//System.out.println("last cell" + rows.getPhysicalNumberOfCells());
		return (rows.getLastCellNum());
	}

	/*
	 * This method is to get the end row of the test case from excel sheet
	 */
	public int getEndRow(String sheetName, int reqRow) {
		XSSFSheet sheet1 = workbook.getSheet(sheetName);
		String rowName = sheet1.getRow(reqRow).getCell(0).getStringCellValue();

		int i = reqRow;
		while (sheet1.getRow(i).getCell(0).getStringCellValue().trim().equalsIgnoreCase(rowName)) {
			reqRow++;
			i++;
		}
		while (sheet1.getRow(i).getCell(0).getStringCellValue().trim().equalsIgnoreCase(rowName)) {

		}

		return reqRow - 1;

	}
	/*
	 * This method will return the data from excel by entering sheet name, row
	 * number and column name
	 */

	public String getRowNumData(String sheetName, int rowNum, String coloumnName) throws IOException {
		String data = "";
		int colNum = 1;
		XSSFSheet sheet1 = workbook.getSheet(sheetName);
		XSSFRow rows = sheet1.getRow(0);
		/*
		 * //System.out.println(coloumnName+"----------------coloumnName");
		 * //System.out.println(sheetName+"----------------sheetName");
		 * //System.out.println(rowNum+"----------------rowNum");
		 */
		for (int j = 0; j < rows.getLastCellNum(); j++) {
			if (rows.getCell(j).getStringCellValue().trim().equalsIgnoreCase(coloumnName)) {
				colNum = j;
				break;
			}
		}
		data = sheet1.getRow(rowNum).getCell(colNum).getStringCellValue();
		// //System.out.println("data---->"+data+" "+coloumnName);

		workbook.close();
		return data;
	}

	/*
	 * This method will return data from excel by giving the Sheet Name, Row
	 * Number, Column Number.
	 */

	public String getColNumData(String sheetName, int rowNum, int colNum) throws IOException {
		String result = "";
		XSSFSheet sheet1 = workbook.getSheet(sheetName);
		XSSFRow rows = sheet1.getRow(rowNum);

		if (rows.getCell(colNum).getCellTypeEnum() == CellType.STRING) {
			workbook.close();
			result = rows.getCell(colNum).getStringCellValue();
		} else if (rows.getCell(colNum).getCellTypeEnum() == CellType.NUMERIC) {
			workbook.close();
			long data1 = (long) rows.getCell(colNum).getNumericCellValue();
			result = String.valueOf(data1);
			// return rows.getCell(colNum).getNumericCellValue();
		} else if (rows.getCell(colNum).getCellTypeEnum() == CellType.BOOLEAN) {
			workbook.close();
			boolean data2 = rows.getCell(colNum).getBooleanCellValue();
			result = String.valueOf(data2);
		}
		return result;

	}
}
