package javaUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "src/test/resources/configs/Configuation.properties";

	public ConfigFileReader() throws IOException {
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(propertyFilePath));
		
		properties = new Properties();
		properties.load(reader);
		reader.close();
	}
	
	public String getDriverPath(){
		 String driverPath = properties.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
	
	public String getApplicationUrl() {
		 String url = properties.getProperty("url");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
	
	 public DriverType getBrowser() {
		 String browserName = properties.getProperty("browser");
		 if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		 else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		 else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		 else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		 }
	 
	 public EnvironmentType getEnvironment() {
			String environmentName = properties.getProperty("environment");
			if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
			else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
			else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		}
	 
	 public Boolean getBrowserWindowSize() {
			String windowSize = properties.getProperty("windowMaximize");
			if(windowSize != null) return Boolean.valueOf(windowSize);
			return true;
		}
	 
	 public long getImplicitlyWait() {		
			String implicitlyWait = properties.getProperty("implicitlyWait");
			if(implicitlyWait != null) {
				try{
					return Long.parseLong(implicitlyWait);
				}catch(NumberFormatException e) {
					throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
				}
			}
			return 30;		
		}
	 
	 public String getTestDataResourcePath(){
		 String testDataResourcePath = properties.getProperty("testDataResourcePath");
		 if(testDataResourcePath!= null) return testDataResourcePath;
		 else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
		}
}
