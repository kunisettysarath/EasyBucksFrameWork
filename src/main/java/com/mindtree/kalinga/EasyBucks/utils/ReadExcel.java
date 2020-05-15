package com.mindtree.kalinga.EasyBucks.utils;

import java.io.IOException;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		ExcelUtil excel= new ExcelUtil();
		
		System.out.println(excel.getCellData("Data", "Email", "InvalidEmail","SignUp"));
		System.out.println(excel.getLastColNum("Data", "SignUp"));
		System.out.println(excel.getColNumData("Data", 2,1));
		System.out.println(excel.getStartRow("Data", "Login"));
		
	}
}
