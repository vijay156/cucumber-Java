package javaUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import testDataTypes.Registration;

public class JsonDataReader {
	
	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Registration.json";

	private Registration registrationData;
	
	public JsonDataReader() throws IOException{
		registrationData = getRegistrationData();
	}
	
	public Registration getRegistrationData() throws FileNotFoundException {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;

			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			registrationData = gson.fromJson(bufferReader, Registration.class);
			return registrationData;		
	}

}
