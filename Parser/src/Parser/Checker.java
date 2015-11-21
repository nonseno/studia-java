package Parser;

/**
 * Created by Admin on 15.11.15.
 */
public class Checker {
    StringBuilder builder;

    public String[] Length(String[] tab)
    {
        builder = new StringBuilder();
        if(tab[0].length()<11)
        {
            for(int i=0; i<11-tab[0].length(); i++)
            {
              builder.append('0');
            }
            builder.append(tab[0]);
            tab[0]=builder.toString();
        }
        return tab;
    }


    public boolean Pesel(String[] tab)
    {
        String[] tmp=tab[0].split("");
        if(tmp.length>11)
            return false;
        int[] numbers= new int[tmp.length];
        for(int i=0; i<tmp.length; i++)
            numbers[i]=Integer.parseInt(tmp[i]);
        int checkValue = numbers[0] + 3*numbers[1] + 7*numbers[2] + 9*numbers[3] + numbers[4]
                + 3*numbers[5] + 7*numbers[6] + 9*numbers[7] + numbers[8] + 3*numbers[9];
        checkValue=checkValue%10;
        if((checkValue==0 && checkValue==numbers[10]) || 10-checkValue==numbers[10] )
            return true;
        return false;
    }
}
