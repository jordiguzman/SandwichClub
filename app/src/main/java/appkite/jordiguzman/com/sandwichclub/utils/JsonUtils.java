package appkite.jordiguzman.com.sandwichclub.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import appkite.jordiguzman.com.sandwichclub.model.Sandwich;

/**
 * Created by Jordi Guzmán on 24/01/2018.
 */

public class JsonUtils {
    private static final String LOG_TAG = JsonUtils.class.getSimpleName();



    public static Sandwich parseSandwichJson(String json) {

        JSONObject jsonObject;
        String mainName = null;
        String placeOfOrigin = null;
        String description = null;
        String image = null;
        List<String> ingredients = new ArrayList<>();
        List<String> alsoKnownAs = new ArrayList<>();
        try {
            jsonObject = new JSONObject(json);
            JSONObject jsonObjectName = jsonObject.getJSONObject("name");
            mainName = jsonObjectName.getString("mainName");
            placeOfOrigin = jsonObject.getString("placeOfOrigin");
            description = jsonObject.getString("description");
            image = jsonObject.getString("image");
            alsoKnownAs = jsonArrayList(jsonObjectName.getJSONArray("alsoKnownAs"));
            ingredients = jsonArrayList(jsonObject.getJSONArray("ingredients"));

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problems with parse", e);
        }
        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }

    private static List<String> jsonArrayList(JSONArray jsonArray){
        List<String> list = new ArrayList<>(0);
        if (jsonArray!=null){
            for (int i=0; i<jsonArray.length();i++){
                try {
                    list.add(jsonArray.getString(i));
                } catch (JSONException e) {
                    Log.e(LOG_TAG, "Problems with array list", e);
                }
            }
        }
        return list;
    }
}
