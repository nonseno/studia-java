package service;

import com.dropbox.core.*;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Admin on 24.12.15.
 */
public class Client {
    private  DbxRequestConfig config;
    private final String accessToken = "1LZyHe-4IvoAAAAAAAAGZYCGH35E2t9hukKUw0wKXoKrhNmoSBqSAkojDVj1WuVo";
    public static DbxClient client;

    public Client() throws DbxException {
        setConfig();
    }



    public void setConfig(){
        this.config = new DbxRequestConfig(
                "My-Own-Dropbox", Locale.getDefault().toString());
        try {
            setClient();
        } catch (DbxException e) {
            e.printStackTrace();
        }
    }

    public void setClient() throws DbxException {
        this.client = new DbxClient(config, accessToken);
    }

    public static DbxClient getClient() {
        return client;
    }

}
