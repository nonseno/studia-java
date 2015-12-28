package test;


import org.junit.Test;
import java.util.concurrent.TimeUnit;


/**
 * Created by Admin on 27.12.15.
 */
public class StatsWorkerTest {

    @Test(timeout = 11000)
    public void ShouldTakeMoreThanTenSeconds() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
    }

}