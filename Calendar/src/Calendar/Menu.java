package Calendar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Arrays.asList;

/**
 * Created by Admin on 29.10.15.
 */
public class Menu{
  // private Scanner In = new Scanner(System.in);
   // private Screen Hlp = new Screen();


    public int ShowMenu() throws Exception {
        Scanner In = new Scanner(System.in);
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
        Scanner In = new Scanner(System.in);
        System.out.println(quest);
        String tmp=In.nextLine();
        return tmp;
    }

    public int QuestionInt(String quest)
    {
        Scanner In = new Scanner(System.in);
        System.out.println(quest);
        int tmp=In.nextInt();
        return tmp;
    }

    public int CategoryAsk(String Ask)
    {
        Scanner In = new Scanner(System.in);
        System.out.println(Ask);
        ShowCategories();
        int choice=In.nextInt();
        return choice;
    }

    public String TaskAsk(int choice, String text)
    {
        Scanner In = new Scanner(System.in);
        Screen Hlp = new Screen();
        System.out.println(text);
        Hlp.Calendar.get(choice-1).Tasks.forEach(s-> System.out.println(s));
        String Removal =In.nextLine();
        return Removal;

    }




    public void ShowCategories()
    {
        Screen Hlp = new Screen();
        clean();
        System.out.println("Wszystkie kategorie:  \n");
        for(int i=0; i<Hlp.Calendar.size(); i++)
        {
            System.out.println(1+i+") "+Hlp.Calendar.get(i).Name);
        }
        System.out.println("\n\n");
    }


    public void ShowCategoriesPriority()
    {
        Scanner In = new Scanner(System.in);
        Screen Hlp = new Screen();
        clean();
        System.out.println("Kategorie z ktorego priorytetu chcesz obejrzec (URGENT,NORMAL,LOW): ");
        String PrioTemp=In.nextLine();
        PrioTemp=PrioTemp.toLowerCase();
        clean();
        System.out.println("Oto wszystkie zadania przydzielone do danych kategori priorytetu "+PrioTemp+" :\n");
        for(int i=0; i<Hlp.Calendar.size(); i++)
        {
            if(PrioTemp.matches(Hlp.Calendar.get(i).Pro.name().toLowerCase()))
            {
                System.out.println("Kategoria: "+Hlp.Calendar.get(i).Name+"\nZadania: ");
                for(int j=0; j<Hlp.Calendar.get(i).Tasks.size(); j++)
                {
                    System.out.println(1+j+") "+Hlp.Calendar.get(i).Tasks.get(j).Name);
                }

            }
        }
        System.out.println("\n\n");
    }

    public void ShowUndoneTasks()
    {
        Screen Hlp = new Screen();
        clean();
        System.out.println("Oto wszystkie zadania, ktore jeszcze nie zostaly wykonane: ");
        Hlp.Calendar.forEach(s-> this.ShowUndoneTasks());

    }



    public void clean(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");}

}
