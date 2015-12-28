package test;

import org.junit.Assert;
import org.junit.Test;
import properties.ConfigService;
import java.io.IOException;


/**
 * Created by Admin on 27.12.15.
 */
public class ConfigServiceTest {

    @Test
    public void ShouldReturn10() throws Exception {
        ConfigService configService = new ConfigService();
        Assert.assertSame(10,configService.getThreadAmount());
    }

    @Test
    public void ShouldNotBeEqual() throws IOException {
        ConfigService configService1 = new ConfigService();
        ConfigService configService2 = new ConfigService();
        Assert.assertNotEquals(configService1,configService2);
    }



}