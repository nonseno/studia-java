package Service;

/**
 * Created by nonseno on 2016-01-11.
 */
import java.util.*;

public class Keeper {

    private List<String> external = new ArrayList<>();
    private List<String> internal = new ArrayList<>();
    private List<String> sentences = new ArrayList<>();
    private String searchedWord;
    private int idLink=0;
    private int idSentence=0;


    public void addExternalLink(String link){
        external.add(link);
    }

    public void addInternalLink(String link){
        internal.add(link);
    }

    public void addSentence(String sentece){
        sentences.add(sentece);
    }

    public String getExternalLink(int index){
        return external.get(index);
    }

    public String getSentence(int index){
        return sentences.get(index);
    }

    public int getIdLink() {
        return idLink;
    }

    public int getIdSentence() {
        return idSentence;
    }

    public int getExternalSize() { return external.size();}

    public int getSentencesSize() { return sentences.size();}

    public void incrementIdLink()
    {
        idLink++;
    }

    public void incrementIdSentence()
    {
        idSentence++;
    }

    public void setSearchedWord(String searchedWord){
        this.searchedWord=searchedWord;
    }

    public String getSearchedWord(){
        return searchedWord;
    }

}

