package resources;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class readJson {
	public static JSONObject readJson(String folder, String file) throws IOException, JSONException {

		String path = new File(".").getCanonicalPath();
		JsonParser jsonParser = new JsonParser();
		FileReader reader = new FileReader(path + "/src/test/java/payload/" + folder + "/" + file);
		JsonObject jsonLido = (JsonObject) jsonParser.parse(reader);
		JSONObject newJson = new JSONObject(jsonLido.toString());

		return newJson;
	}
}
