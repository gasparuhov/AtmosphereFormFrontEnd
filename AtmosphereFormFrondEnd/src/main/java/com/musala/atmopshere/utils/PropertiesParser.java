package com.musala.atmopshere.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesParser {
	private static String workingDir = System.getProperty("user.dir");

	private static String separator = System.getProperty("file.separator");
	private static String defaultFile = "domainConfig.properties";
	private static String domainFile = workingDir + separator
			+ "domainConfig.properties";

	public static File setDomainFile() {

		File configFile = new File(domainFile);

		try {
			if (!configFile.exists()) {

				ClassLoader classLoader = PropertiesParser.class.getClassLoader();
				File defaultconfigFile = new File(classLoader.getResource(defaultFile).getFile());
				return defaultconfigFile;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return configFile;
	}

	public static String getDomaain() {
		File configDomainFile = setDomainFile();
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(configDomainFile);
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop.getProperty("domain");
	}
}
