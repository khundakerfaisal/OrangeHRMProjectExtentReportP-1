package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static Config.BasePage.test;

public class Utils {
   public static ExtentReports extent;
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

    public static ExtentReports getInstance(){
        if (extent==null){
            ExtentSparkReporter sparkReporter=new ExtentSparkReporter("reports/ExtentReport.html");
            extent=new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
    public static void getScreenShot(WebDriver driver,String message) throws IOException {
        Random randNumber = new Random();
        int generateAutoNumber = randNumber.nextInt(9999) + 1111;
        File srcFilePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = "reports/screenshots/";
        new File(screenshotDir).mkdirs(); // Ensure directory exists
        String imageFileName = "screenshot_" + generateAutoNumber + ".png";
        String fullScreenshotPath = screenshotDir + imageFileName;
        File destFile = new File(fullScreenshotPath);
        FileUtils.copyFile(srcFilePath, destFile);
        // Use RELATIVE path from HTML file (ExtentReport.html is in /reports/)
        String relativePath = "screenshots/" + imageFileName;
        test.pass(message,
                MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());

    }

}
