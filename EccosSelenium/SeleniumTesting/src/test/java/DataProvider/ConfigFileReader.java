package DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties ; 
	private final String propertyFilePath = "./src/test/resources/Properties/Configuration.properities";
	
	
	public static ConfigFileReader  configFileReader ; 
	
	public  ConfigFileReader() {
		
		
		BufferedReader reader ;
		try {
			reader = new BufferedReader (new FileReader (propertyFilePath));
			properties = new Properties();
			
			try { 
				properties.load(reader);
				reader.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
		
	}
	
	
	public static ConfigFileReader getConfigFileReader() {
		
		if (configFileReader == null) {
			configFileReader = new ConfigFileReader();
		}
		return configFileReader;
		
	}
	
	public String getPropertyFromFile(String value) {
		String key = properties.getProperty(value);
		if (key != null) {
			return key;
		}
		else {
			throw new RuntimeException("Key is not specified in the Configuration.properties file.");
			
		}
	}
	

}
