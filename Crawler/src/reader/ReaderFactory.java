package reader;

import properties.ConfigService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * Created by nonseno on 2016-01-11.
 */
public class ReaderFactory {
    private ConfigService configService;
    private String path;

    public ReaderFactory() throws IOException {
        configService = new ConfigService();
        path=configService.getStartingLink();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void appendPath(String word) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
//        path = path + URLEncoder.encode(word, "UTF-8");
        path = stringBuilder.append(path).append(word).toString();
    }

    public String getPath() { return path;}

    public  Reader create(){
        return new WebPageReader(path);
    }


}
