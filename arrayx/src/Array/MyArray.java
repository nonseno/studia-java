package Array;


import java.util.Arrays;

/**
 * Created by Admin on 22.10.15.
 */
public class MyArray <T>{
    private Object[] tab;
    private int size=0, counter=0;
    private T item;

    public MyArray()
    {
        this.size=10;
        tab = new Object[size];
    }

    public MyArray(int initial)
    {
        this.size=initial;
        tab = new Object[initial];
    }

    //1
    public void add(T item)
    {
        this.item=item;
        if(counter>=size)
        {
            tab = Arrays.copyOf(tab, size * 2);
        }
        tab[counter]=this.item;
        counter++;
    }

//2
    public T remove()
    {
        if(counter<=0)
        {
            System.out.println("There are no more elements ");
            System.exit(0);
        }

        tab[counter-1]=null;
        counter--;
        T tmp= this.item;
        this.item=null;
        return tmp;

    }


    //3
    public Object get(int index)
    {
        if (index < 0 || index >= counter){
            throw new ArrayIndexOutOfBoundsException("index: "+index);
        }
        return tab[index];
    }


    //4
    public String toString ()
    {
        String tmp="";

            for(int i=0; i<size; i++)
            {
                if(tab[i]!=null) {
                    tmp = tmp + tab[i] + ",";
                }
            }

       String tmp1=tmp.substring(0, tmp.length()-1);

        return "["+tmp1+"]";
    }

    //5
    public boolean isEmpty()
    {
        if(counter==0)
        {
            return true;
        }
        else
            return false;
    }

    //6
    public int size()
    {
        return counter;
    }

    //7
    public void clear()
    {
        for(int i=0; i<counter; i++)
        {
            tab[i]=null;
        }
        counter=0;
    }

    //8
    public void set(int index, T val)
    {
        if(index>=size)
        {
            System.out.println("Wykroczyles poza zakres pamieci ");
            System.exit(0);
        }
        tab[index]=val;
    }

}
