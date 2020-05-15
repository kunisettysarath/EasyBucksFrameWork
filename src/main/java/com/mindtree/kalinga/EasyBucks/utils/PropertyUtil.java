package com.mindtree.kalinga.EasyBucks.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PropertyUtil {
	/*
	 * This method will help to get the data from the property file using the
	 * name of the property
	 */
	public static String getData(String name) {
		File file = new File("./src/main/resources/configure.properties");
		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (prop.getProperty(name));

	}

	/*
	 * This method will help to add data to the property file according to their
	 * key and value
	 */
	public static void addData(String key, String val) {
		try {
			File file = new File("./src/main/resources/configure.properties");
			Properties properties = new Properties();
			properties.load(new FileInputStream(file));
			FileOutputStream obj = new FileOutputStream(file);
			properties.setProperty(key, val);
			properties.store(obj, "Update data into file ");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
