package ru.ibs.internship;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainServletHW2 extends HttpServlet {

    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        count++;

        PrintWriter out = resp.getWriter();
        out.println("Method doGet was called " + count + " times");
        out.println(Files.readString(CreateJsonFile.jsonPath));

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        Path jsonPath = Path.of(System.getProperty("user.home") + "\\Desktop\\testFile.json");
        Files.delete(jsonPath);
        if (!Files.exists(jsonPath)) {
            out.println("Deleted file \"testFile.json\" in the directory: " + jsonPath.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String originalJson = CreateJsonFile.newJsonObject("Ivan", "Ivanov").toString();

        Files.writeString(CreateJsonFile.newJsonFile(out), originalJson);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String updateJson = CreateJsonFile.newJsonObject("Petr", "Petrov").toString();
        Files.writeString(CreateJsonFile.jsonPath, updateJson);
        out.println("File \"testFile.json\" in the directory: " + CreateJsonFile.jsonPath.toString() + " was updated");
    }
}