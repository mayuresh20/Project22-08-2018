package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class util {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try{
			reader = new Xls_Reader("C:\\Users\\USER\\Desktop\\MaritalData.xlsx");
						
		}catch(Exception e){
			e.printStackTrace();
			}
		
		for (int rowNum = 2; rowNum <= reader.getColumnCount("testdata"); rowNum++){
		
			String ProfileFor = reader.getCellData("testdata", "ProfileFor", rowNum);
			String Name = reader.getCellData("testdata", "Name", rowNum);
			String Gender = reader.getCellData("testdata", "Gender", rowNum);
			String day = reader.getCellData("testdata", "day", rowNum);
			String month = reader.getCellData("testdata", "month", rowNum);
			String year = reader.getCellData("testdata", "year", rowNum);
			String Age = reader.getCellData("testdata", "Age", rowNum);
			String Religion = reader.getCellData("testdata", "Religion", rowNum);
			String MotherTongue = reader.getCellData("testdata", "MotherTongue", rowNum);
			
			
			Object ob[] = {ProfileFor, Name, Gender, day, month, year, Age, Religion, MotherTongue};
			myData.add(ob);
	
		}
		return myData;
		
	}
	
	
	
	
}
