package Config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginCsvDataSet {
    @DataProvider(name = "loginCsvData")
    public Object[][] getCsvUserData() throws IOException {
        String filePath="src/test/resources/login.csv";
        List<Object> getObject=new ArrayList<>();
        CSVParser csvParser=new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());

        for (CSVRecord csvRecord:csvParser){
            String username=csvRecord.get("username");
            String password=csvRecord.get("password");
            getObject.add(new Object[]{username,password});

        }
        return getObject.toArray(new Object[0][]);

    }
}
