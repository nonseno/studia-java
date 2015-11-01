import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

/**
 * Created by Admin on 06.10.15.
 */
public class SetCollection {
   private List<String> list;

    SetCollection()
    {
        list= new ArrayList<>();
    }


    public void setList(List<String> list) {
        this.list = list;
    }

//    public List<String> Sort()
//    {
//      //  list.forEach(n-> asList(n.split("")).stream().map(I->Integer.parseInt(I)).sorted(Comparator.<Integer>reverseOrder()));
//        //list.forEach(n-> System.out.println(asList(n.split("")).stream().sorted(Comparator.<String>reverseOrder()).collect(joining())));
////       int numbTmp=list.stream().map(I->Integer.parseInt(I)).sorted(Comparator.<Integer>reverseOrder()).get();
//
//        return list;
//    }




    public ArrayList<String> Sort()
    {
        ArrayList<Integer> numbers;
        ArrayList<String> LastList= new ArrayList<>();
        for(String o : list)
        {
            numbers=new ArrayList<>();
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
