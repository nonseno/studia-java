package properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Admin on 22.12.15.
 */
public class ConfigService {
    private static final File file = new File("properties.properties");
    private Properties prop = new Properties();

    public ConfigService() throws IOException {
        try (FileInputStream in = new FileInputStream(file)) {
            prop.load(in);
        }
    }

    public int getThreadAmount() {
        return Integer.parseInt(prop.getProperty("threadAmount"));
    }

}