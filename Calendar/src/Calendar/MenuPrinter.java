package Calendar;

import java.util.Scanner;


/**
 * Created by Admin on 29.10.15.
 */
public class MenuPrinter{
        Scanner in = new Scanner(System.in);

    public int ShowMenu() throws Exception {
        System.out.println("Wybierz z menu: ");
        System.out.println("1) Dodaj kategorie");
        System.out.println("2) Dodaj zadanie");
        System.out.println("3) Wyswietl wszystkie kategorie");
        System.out.println("4) Wyswietl zadania z kategorii o zadanym priorytecie");
        System.out.println("5) Usun zadanie");
        System.out.println("6) Oznacz zadanie jako zrobione");
        System.out.println("7) Pokaz niedokonczone zadania");
        System.out.println("8) Koniec programu\n");
        System.out.println("Podaj numer: ");
        int tmp=in.nextInt();
        Check(tmp);
        return tmp;
    }

    public void Check(int tmp) throws Exception {
        if(tmp<1||tmp>8)
            throw new Exception("Warning: wrong number !");
    }


    public String QuestionString(String quest)
    {
        System.out.println(quest);
        String tmp=in.nextLine();
        return tmp;
    }


    public int CategoryAsk(String Ask, Worker hlp)
    {
        System.out.println(Ask);
        ShowCategories(hlp);
        int choice=in.nextInt();
        return choice;
    }


    public int TaskAsk(String choice, String text, Worker hlp)
    {
        System.out.println(text);
        for(int i=0; i<hlp.Calendar.get(Integer.parseInt(choice)-1).tasks.size(); i++)
        {
            System.out.println(i+1+") "+hlp.Calendar.get(Integer.parseInt(choice)-1).tasks.get(i).name);
        }
        int indexOfRemoval =in.nextInt();
        return indexOfRemoval;

    }
    

    public void ShowCategories(Worker hlp)
    {
        System.out.println("Wszystkie kategorie:  \n");
        for(int i=0; i<hlp.Calendar.size(); i++)
        {
            System.out.println(1+i+") "+hlp.Calendar.get(i).name);
        }
        System.out.println("\n\n");
        Sleep();
    }


    public void ShowCategoriesPriority(Worker hlp)
    {
        System.out.println("Kategorie z ktorego priorytetu chcesz obejrzec (URGENT,NORMAL,LOW): ");
        String prioTemp=in.next();
        prioTemp=prioTemp.toLowerCase();
        System.out.println("Oto wszystkie zadania przydzielone do danych kategori priorytetu "+prioTemp+" :\n");
        for(int i=0; i<hlp.Calendar.size(); i++)
        {
            if(prioTemp.matches(hlp.Calendar.get(i).pro.name().toLowerCase()))
            {
                System.out.println("Kategoria: "+hlp.Calendar.get(i).name+"\nZadania: ");
                for(int j=0; j<hlp.Calendar.get(i).tasks.size(); j++)
                {
                    System.out.println(1+j+") "+hlp.Calendar.get(i).tasks.get(j).name);
                }

            }
        }
        System.out.println("\n\n");
        Sleep();
    }

    public void ShowUndoneTasks(Worker hlp)
    {
        System.out.println("Oto wszystkie zadania, ktore jeszcze nie zostaly wykonane: ");
        for(int i=0; i<hlp.Calendar.size(); i++)
        {
            for(int j=0; j<hlp.Calendar.get(i).tasks.size(); j++)
            {
                if(!(hlp.Calendar.get(i).tasks.get(j).isDone))
                {
                    Task tmp=hlp.getUndoneTasks(i,j);
                    System.out.println(tmp.name);
                }
            }
        }
    }

    private void Sleep()
    {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}
