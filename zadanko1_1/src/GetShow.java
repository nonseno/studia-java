import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Admin on 25.10.15.
 */
public class GetShow {

    public List insert()
    {
        Scanner In= new Scanner(System.in);
        String Numbers = In.nextLine();
        String[] NumbTmp=Numbers.split(",");
        List list= Arrays.asList(NumbTmp);
        return list;
    }

    public void show(ArrayList<String> List)
    {
        List.forEach(s-> System.out.println(s));
    }

}
