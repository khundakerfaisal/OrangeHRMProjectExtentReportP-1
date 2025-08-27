package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void SaveEmployee(String firstName,String lastName,String userName,String password) throws IOException, ParseException {
        String filePath="./src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray addedArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject addedObject=new JSONObject();
        addedObject.put("FirstName",firstName);
        addedObject.put("LastName",lastName);
        addedObject.put("UserName",userName);
        addedObject.put("Password",password);
        addedArray.add(addedObject);
        FileWriter writer=new FileWriter(filePath);
        writer.write(addedArray.toJSONString());
        writer.flush();
        writer.close();


    }

    public static JSONObject getUserCred() throws IOException, ParseException {
        String filePath="./src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray getArrayValue= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject getLastObject= (JSONObject) getArrayValue.get(getArrayValue.size()-1);
        return getLastObject;


    }

    public static void scrollBy(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)");
    }


}
