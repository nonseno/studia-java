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


    public String questionString(String quest)
    {
        System.out.println(quest);
        String tmp=in.nextLine();
        return tmp;
    }


    public int categoryAsk(String Ask, Worker worker)
    {
        System.out.println(Ask);
        ShowCategories(worker);
        int choice=in.nextInt();
        return choice;
    }


    public int taskAsk(int choice, String text, Worker worker)
    {
        System.out.println(text);
        for(int i=0; i<worker.getCalendar().get(choice-1).getSize(); i++)
        {
            System.out.println(i+1+") "+worker.getCalendar().get(choice-1).getTask(i).getName());
        }
        int indexOfRemoval =in.nextInt();
        return indexOfRemoval;

    }
    

    public void ShowCategories(Worker worker)
    {
        System.out.println("Wszystkie kategorie:  \n");
        for(int i=0; i<worker.getSize(); i++)
        {
            System.out.println(1+i+") "+worker.getCalendar().get(i));
        }
        System.out.println("\n\n");
        Sleep();
    }


    public void ShowCategoriesPriority(Worker worker)
    {
        System.out.println("Kategorie z ktorego priorytetu chcesz obejrzec (URGENT,NORMAL,LOW): ");
        String prioTemp=in.next();
        prioTemp=prioTemp.toLowerCase();
        System.out.println("Oto wszystkie zadania przydzielone do danych kategori priorytetu "+prioTemp+" :\n");
        for(int i=0; i<worker.getSize(); i++)
        {
            if(prioTemp.matches(worker.getCalendar().get(i).getPro().name().toLowerCase()))
            {
                System.out.println("Kategoria: "+worker.getCalendar().get(i)+"\nZadania: ");
                for(int j=0; j<worker.getCalendar().get(i).getSize(); j++)
                {
                    System.out.println(1+j+") "+worker.getCalendar().get(i).getTask(j).getName());
                }

            }
        }
        System.out.println("\n\n");
        Sleep();
    }

    public void showUndoneTasks(Worker worker)
    {
        System.out.println("Oto wszystkie zadania, ktore jeszcze nie zostaly wykonane: ");
        for(int i=0; i<worker.getCalendar().size(); i++)
        {
            for(int j=0; j<worker.getCalendar().get(i).getSize(); j++)
            {
                if(!(worker.getCalendar().get(i).getTask(j).isDone()))
                {
                    Task tmp=worker.getDoneTasks(i,j);
                    System.out.println(tmp.getName());
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
