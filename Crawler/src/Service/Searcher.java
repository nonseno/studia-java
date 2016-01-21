package Service;

import reader.Reader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nonseno on 2016-01-13.
 */
public class Searcher implements Callable {
    private Reader reader;
    private String source;
    private Keeper keeper;
    private Stats stats;

    public Searcher(Reader reader, Keeper keeper, Stats stats){
        this.reader = reader;
        this.keeper = keeper;
        this.stats = stats;
    }


    public void setSource() throws IOException {
        source = reader.read();
    }

    public void findLinks() {
        String pattern = "\\<a[^>]*?href=\"(.*?)\"";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        Matcher m = p.matcher(source);
        while(m.find()) {
            String res = m.group(1);
            if (res.startsWith("#")  || !(res.toLowerCase().startsWith("http") || res.toLowerCase().startsWith("https") || res.toLowerCase().startsWith("//")))
                keeper.addInternalLink(res);
            else
            keeper.addExternalLink(res);
            stats.linksPerTenSeconds.incrementAndGet();
        }
    }

    public void findWords()
    {
        Matcher m = Pattern.compile("[^.]*" + Pattern.quote(keeper.getSearchedWord().toLowerCase())+ "[^.]*\\.?",
                Pattern.CASE_INSENSITIVE)
                .matcher(source);
        int wordsPerPage=0;
        while(m.find()) {
            String res = m.group();
            wordsPerPage++;
            if(!(res.equals(null)))
                keeper.addSentence(res);
        }
        stats.setWordsPerPage(wordsPerPage);
    }


    @Override
    public Void call() throws Exception {
        setSource();
        findLinks();
        findWords();
        return null;
    }
}
