package com.insurance.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * This is the method to read the data from property file.
	 * @author Anamika
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
	}

}
