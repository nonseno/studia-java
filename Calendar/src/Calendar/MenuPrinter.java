package Calendar;

import java.util.Scanner;


/**
 * Created by Admin on 29.10.15.
 */
public class MenuPrinter{
        Scanner In = new Scanner(System.in);

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
        int tmp=In.nextInt();
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
        String tmp=In.nextLine();
        return tmp;
    }


    public String CategoryAsk(String Ask, Worker hlp)
    {
        System.out.println(Ask);
        ShowCategories(hlp);
        String choice=In.nextLine();
        return choice;
    }


    public String TaskAsk(String choice, String text, Worker hlp)
    {
        System.out.println(text);
        for(int i=0; i<hlp.Calendar.get(Integer.parseInt(choice)-1).Tasks.size(); i++)
        {
            System.out.println(i+1+") "+hlp.Calendar.get(Integer.parseInt(choice)-1).Tasks.get(i).Name);
        }
        String indexOfRemoval =In.next();
        return indexOfRemoval;

    }
    

    public void ShowCategories(Worker hlp)
    {
        System.out.println("Wszystkie kategorie:  \n");
        for(int i=0; i<hlp.Calendar.size(); i++)
        {
            System.out.println(1+i+") "+hlp.Calendar.get(i).Name);
        }
        System.out.println("\n\n");
        Sleep();
    }


    public void ShowCategoriesPriority(Worker hlp)
    {
        System.out.println("Kategorie z ktorego priorytetu chcesz obejrzec (URGENT,NORMAL,LOW): ");
        String prioTemp=In.next();
        prioTemp=prioTemp.toLowerCase();
        System.out.println("Oto wszystkie zadania przydzielone do danych kategori priorytetu "+prioTemp+" :\n");
        for(int i=0; i<hlp.Calendar.size(); i++)
        {
            if(prioTemp.matches(hlp.Calendar.get(i).Pro.name().toLowerCase()))
            {
                System.out.println("Kategoria: "+hlp.Calendar.get(i).Name+"\nZadania: ");
                for(int j=0; j<hlp.Calendar.get(i).Tasks.size(); j++)
                {
                    System.out.println(1+j+") "+hlp.Calendar.get(i).Tasks.get(j).Name);
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
            for(int j=0; j<hlp.Calendar.get(i).Tasks.size(); j++)
            {
                if(!(hlp.Calendar.get(i).Tasks.get(j).IsDone))
                {
                    Task tmp=hlp.getUndoneTasks(i,j);
                    System.out.println(tmp.Name);
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
