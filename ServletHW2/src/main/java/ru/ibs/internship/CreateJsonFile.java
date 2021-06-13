package ru.ibs.internship;

import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateJsonFile {

    static Path jsonPath = Path.of(System.getProperty("user.home") + "\\Desktop\\testFile.json");

    public static Path newJsonFile(PrintWriter out) {


        boolean file = false;

        try {
            if (Files.exists(jsonPath)) {
                out.println("File was already created.");
                file = true;
            } else {
                Files.createFile(jsonPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file) {
            out.println("Directory of the file is: " + jsonPath.toString());
        } else if (Files.exists(jsonPath)) {
            out.println("Created file \"testFile.json\" in the directory: " + jsonPath.toString());
        } else {
            out.println("File is not created");
        }

        return jsonPath;

    }

    public static JSONObject newJsonObject(String name, String surname) {
        JSONObject someJson = new JSONObject();
        someJson.put("name", name);
        someJson.put("surname", surname);
        return someJson;
    }
}
