package test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import service.FileSender;
import service.StatsService;
import worker.Printer;

import static org.junit.Assert.*;

/**
 * Created by Admin on 27.12.15.
 */
public class StatsServiceTest {

    StatsService statsService;

    @Test
    public void testGetStats(){

        FileSender fs = Mockito.mock(FileSender.class);
        statsService = new StatsService(fs);
        StatsService statsSerivce2 = new StatsService(fs);
        Assert.assertEquals(statsSerivce2.getStats(),statsService.getStats());
    }

    @Test
    public void ShouldBeEqual()
    {
        FileSender fs = Mockito.mock(FileSender.class);
        statsService = new StatsService(fs);
        Mockito.when(statsService.getStats()).thenReturn(0);
        Assert.assertEquals(0, statsService.getStats());
    }

}