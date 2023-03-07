package resources;

import org.json.JSONException;
import org.json.JSONObject;

public class validators {
    public boolean jsonIsValid(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }
}
