package javaUtils;

import java.io.IOException;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public ConfigFileReader getConfigReader() throws IOException {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}
	
	 public JsonDataReader getJsonReader() throws IOException{
		 return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
		 }

}
