package com.utils;

import org.testng.annotations.DataProvider;

import com.cleartrip.ConstantFilePaths;


public class TestDataProvider  {

		@DataProvider(name = "testdata")
		public Object[][] testData() {
			ExcelFileRead file = new ExcelFileRead(ConstantFilePaths.TESTDATA_FILE);
			int sheetIndex = 0;
			int rowCount = file.totalRowsinSheet(sheetIndex);
			int colCount = file.totalColsinSheet(sheetIndex);

			//System.out.println("Total number of row in test data: " + rowCount);
			//System.out.println("Total number of coloum in test data: " + colCount);

			Object[][] data = new Object[rowCount][colCount];

			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				for (int colIndex = 0; colIndex < colCount; colIndex++) {
					data[rowIndex][colIndex] = file.getData(sheetIndex, rowIndex+1 , colIndex);
				}
			}
			return data;
		}
			
}
		

