package worker;

import properties.ConfigService;
import service.FileSender;
import worker.FileWorker;
import worker.Printer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
/**
 * Created by Admin on 22.12.15.
 */



public class FileListener extends Thread{

    private FileSender sender;

    private ExecutorService pool;

    private Path myDir;

    private Printer printer;

    public FileListener(FileSender sender, String path, Printer printer) throws IOException {
        this.sender = sender;
        this.myDir = Paths.get(path);
        pool = Executors.newFixedThreadPool(new ConfigService().getThreadAmount());
        this.printer=printer;
    }


    public void preStart()
    {
        File file = new File(myDir.toString());
        File[] files = file.listFiles();
        if(files!=null)
            for(File f : files)
                sendInThread(f.toString());
    }

    public void listen(){
           try {
               WatchService watcher = myDir.getFileSystem().newWatchService();
               myDir.register(watcher, ENTRY_CREATE);

               WatchKey watchKey = watcher.take();

               List<WatchEvent<?>> events = watchKey.pollEvents();
               for (WatchEvent event : events) {
                   if (event.kind() == ENTRY_CREATE) {
                       WatchEvent<Path> ev = (WatchEvent<Path>) event;
                       Path filename = ev.context();
                       sendInThread(myDir.toString() + "/" + filename.toString());
                   }
               }
           } catch (Exception e) {
               printer.displayString(e.getMessage());
           }
    }

    public void sendInThread(String path){
        pool.submit(new FileWorker(sender, path));

    }
    public void run()
    {
        preStart();
        while(true)
            listen();
    }
}
