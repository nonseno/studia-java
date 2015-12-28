package worker;

import service.StatsService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 22.12.15.
 */

public class StatsWorker{

    private StatsService statsService;
    private ScheduledExecutorService scheduledExecutorService;
    private Printer printer;

    public StatsWorker(StatsService statsService, Printer printer) {
        this.statsService = statsService;
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(task,0,1,TimeUnit.SECONDS);
        this.printer=printer;
    }



    public void generateStats(){printer.displayLabel("Wyslano : "+statsService.getStats()+" plikow/10s");}

    Runnable task = () -> {
        try{
            TimeUnit.SECONDS.sleep(10);
            generateStats();
        } catch (InterruptedException e) {
           printer.displayString(e.getMessage());
        }
    };
}


