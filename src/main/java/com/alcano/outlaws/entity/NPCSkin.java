package com.alcano.outlaws.entity;

import com.alcano.outlaws.net.URLConnectionReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NPCSkin {

    public String texture;
    public String signature;

    public NPCSkin(String texture, String signature) {
        this.texture = texture;
        this.signature = signature;
    }

    public static NPCSkin ofPlayer(String uuid) {
        String texture = "";
        String signature = "";

        String jsonString = URLConnectionReader.getText("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");

        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            JSONArray propertiesArray = (JSONArray) jsonObject.get("properties");
            JSONObject properties = (JSONObject) propertiesArray.get(0);

            texture = (String) properties.get("value");
            signature = (String) properties.get("signature");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new NPCSkin(texture, signature);
    }

}
