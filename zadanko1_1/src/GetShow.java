import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Admin on 25.10.15.
 */
public class GetShow {

    String numbers;

    public void Insert()
    {
        Scanner In= new Scanner(System.in);
        this.numbers = In.nextLine();
    }

    public List<String> Split()
    {
        String[] NumbTmp=this.numbers.split(",");
        List<String> list = Arrays.asList(NumbTmp);
        return list;
    }

    public void show(List<String> List)
    {
        List.forEach(s-> System.out.println(s));
    }

}
