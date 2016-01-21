package Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nonseno on 2016-01-18.
 */
public class Stats {

    private int wordsPerPage;
    private ScheduledExecutorService scheduledExecutorService;
    AtomicInteger linksPerTenSeconds = new AtomicInteger(0);
    private Printer printer;

    public Stats(Printer printer){
        this.printer =printer;
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(task,0,1,TimeUnit.SECONDS);

    }

    public void generateWordStats() { printer.displayLabelTwo("Zebrano : " + wordsPerPage + " slow/strone");}

    public void setWordsPerPage(int value){
        wordsPerPage = value;
    }

    public void generateLinkStats() {printer.displayLabelOne("Zebrano : " + linksPerTenSeconds.getAndSet(0) + " linkow/10s");}

    Runnable task = () -> {
        try{
            TimeUnit.SECONDS.sleep(10);
            generateLinkStats();
            generateWordStats();
        } catch (InterruptedException e) {
            printer.displayString(e.getMessage());
        }
    };

}
