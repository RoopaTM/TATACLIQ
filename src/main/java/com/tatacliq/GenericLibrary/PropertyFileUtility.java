package com.tatacliq.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	 Properties property;
	 FileInputStream fis;
		/**
		 * this method is used to open the property file
		 * @throws IOExeception
		 */
		
		public  void openPropertyFile(String filePath) throws IOException
		{
			fis=new FileInputStream(filePath);
			
		}
		
		
		
		/**
		 * This method is used to get the data from the property file
		 * @param key
		 * @return
		 * @throws IOException 
		 */
		public String getDataFromPropertyFile(String key) throws IOException
		{
			Properties prop = new Properties();
			prop.load(fis);
			String value = prop.getProperty(key);
			return value;
		}
	
}
