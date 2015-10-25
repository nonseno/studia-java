import java.util.*;

/**
 * Created by Admin on 06.10.15.
 */
public class SetCollection {
    //set powinien być typizowany tzn Set<String> ^
    public Set<String> list;
    public ArrayList<String> LastList;

    SetCollection()
    {
        list= new HashSet<String>();
        LastList= new ArrayList<String>();
    }
    //1 metoda wprowadz

    //nie robimy system ouut w klasach wykonujących jakies zadanie

    //kod po angielsku
    public void insert()
    {
        Scanner In= new Scanner(System.in);
        String Numbers = In.nextLine();
        String[] NumbTmp=Numbers.split(",");
        for( String s:NumbTmp)
        {
            list.add(s);
        }
    }


    //2 rozbicie na cyfry
    //nazwa kompletnie nie mówi co robi metoda
    public void SplitNSort()
    {
        ArrayList<Integer> numbers;
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
    }

}
