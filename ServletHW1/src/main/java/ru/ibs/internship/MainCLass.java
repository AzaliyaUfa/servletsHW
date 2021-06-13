package ru.ibs.internship;

import org.json.JSONObject;

public class MainCLass {

    public static JSONObject createIson() {
        JSONObject someJson = new JSONObject();
        someJson.put("name", "Ivan");
        someJson.put("surname", "Ivanov");
        return someJson;
    }



}
