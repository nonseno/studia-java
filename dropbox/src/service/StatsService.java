package service;

/**
 * Created by Admin on 22.12.15.
 */
public class StatsService {

    private FileSender sender;

    public StatsService(FileSender sender) {
        this.sender =sender;
    }

    public int getStats(){
        return sender.getStats();
    }
}