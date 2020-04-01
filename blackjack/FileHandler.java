package blackjack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * This class is going to be used as main class to read the file where all info is stored
 */
public class FileHandler {
	
	// path where the file will be
	protected String path;
	
	
	/**
	 * The constructor will create the file in case this is not created
	 * @throws FileNotFoundException 
	 * @throws Exception 
	 */
	protected FileHandler(String filePath) throws FileNotFoundException {
		this.path = filePath;
		// Check if the database file exists
		if(!this.doesDatabaseFileExists()) {
			// create the file in case it does not exists
			throw new FileNotFoundException("Deck File doesn't exists. Import it to continue");
		}
	}
	
	/**
	 * Method to check is the database file exists
	 * @return
	 */
	protected boolean doesDatabaseFileExists() {
		// instantiate the file
		File databaseFile = new File(this.path);
		
		// check is the file exists and returns the response
		return databaseFile.exists();
	}

	/**
	 * Getter of the path of the file
	 * @return
	 */
	protected String getPath() {
		return path;
	}
	
	/**
	 * Read the database file and returns the info of a specific part of the file
	 * @param index_name
	 * @return info returned as a JSON Array
	 * @throws IOException
	 * @throws ParseException
	 */
	protected JSONArray readJSONFile() throws IOException, ParseException {
		// Read the file
		FileReader reader = new FileReader(this.path);
		
		// Initialize the JSON parser to get all info of the file
		JSONParser jsonParser = new JSONParser();
		
		// parse the info of the database file and store it in a JSON Object file
		return (JSONArray) jsonParser.parse(reader);

	}
	
}
