package Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nonseno on 2016-01-18.
 */
public class Stats {

    private int wordsPerPage=0;
    AtomicInteger linksPerTenSeconds = new AtomicInteger(0);



    public int getWordStats() { return wordsPerPage;}

    public void setWordsPerPage(int value){
        wordsPerPage = value;
    }

    public int getLinkStats() {return linksPerTenSeconds.getAndSet(0);}



}
