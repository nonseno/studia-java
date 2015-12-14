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
    public T remove() throws Exception {
        if(counter<=0)
        {
            throw new Exception("There are no more elements ");
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
        StringBuilder build= new StringBuilder();

            for(int i=0; i<size; i++)
            {
                if(tab[i]!=null) {
                    build.append(tab[i]);
                    build.append(",");
                }
            }

        return "["+build.toString().substring(0,build.length()-1)+"]";
    }

    //5
    public boolean isEmpty()
    {
        return counter==0;
    }


    //6
    public void clear()
    {
        tab = new Object[size];
        counter=0;
    }

    //7
    public void set(int index, T val) throws Exception {
        if(index>=size)
        {
            throw new Exception("Wykroczyles poza zakres pamieci ");
        }
        tab[index]=val;
    }

}
