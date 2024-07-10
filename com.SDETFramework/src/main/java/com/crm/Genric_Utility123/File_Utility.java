package com.crm.Genric_Utility123;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility 
{

/**
 * this method is use to launch the application
 * @param key
 * @return
 * @author MADHU
 * @throws Throwable 
 */
		public String getPropertyKeyValue(String key) throws Throwable 
		{
			FileInputStream fis=new FileInputStream("./src/test/resources/Common_Data.properties.txt");
			Properties pro=new Properties();
			pro.load(fis);
		
			String value =pro.getProperty(key);
			return value;
		}
	}
