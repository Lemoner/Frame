package edu.hdu.lab.checkIn.utils;

public class FormVerify{
	
	public static String TextFilter(String strInput)
	{
		//去除字符串左右的空格
		String strTemp = strInput.trim();
		
		/**
		 * TODO Special Character Filter < > % ...
		 */
		return strTemp;
	}
}
