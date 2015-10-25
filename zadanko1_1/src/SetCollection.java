import java.util.*;

/**
 * Created by Admin on 06.10.15.
 */
public class SetCollection {
   private List<String> list;

    SetCollection()
    {
        list= new ArrayList<String>();
    }
    //1 metoda wprowadz

    //nie robimy system ouut w klasach wykonujących jakies zadanie

    //kod po angielsku

    public void setList(List list) {
        this.list = list;
    }


    //2 rozbicie na cyfry
    //nazwa kompletnie nie mówi co robi metoda
    public ArrayList<String> SplitNSort()
    {
        ArrayList<Integer> numbers;
        ArrayList<String> LastList= new ArrayList<String>();
        //nie zadziała dla duzych liczb. Zrób na stringach
        for(String o : list)
        {
            numbers=new ArrayList<Integer>();
           for(int i=0; i<o.length(); i++)
           {
               numbers.add(Integer.parseInt(String.valueOf(o.charAt(i))));
           }
            Collections.sort(numbers);
            Collections.reverse(numbers);
            LastList.add(numbers.toString().replace(", ","").replace("[","").replace("]",""));
        }
        return LastList;
    }


}
