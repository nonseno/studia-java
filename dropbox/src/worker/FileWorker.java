package worker;
import service.FileSender;

import java.util.concurrent.Callable;

/**
 * Created by Admin on 22.12.15.
 */


public class FileWorker implements Callable{

    private FileSender fileSender;
    String  path;
    public FileWorker(FileSender fileSender, String path) {
        this.fileSender = fileSender;
        this.path = path;
    }

    @Override
    public Void call() throws Exception {
        fileSender.send(path);
        return null;
    }
}