package Calendar;

import javax.swing.*;

/**
 * Created by Admin on 29.10.15.
 */
public class Printer{

    public void ShowCategories(Worker worker, JTextArea notepad)
    {
        notepad.setText(null);
        notepad.append("Wszystkie kategorie:  \n");
        for(int i=0; i<worker.Calendar.size(); i++)
        {
            notepad.append(1 + i + ") " + worker.Calendar.get(i).Name + "\n");
        }
    }

    public void ShowCategoryTasks(Worker worker, JTextArea notepad, int index)
    {
        notepad.setText(null);
        notepad.append("Wszystkie zadania z kategori "+worker.Calendar.get(index).Name + ": \n");
        for(int i=0; i<worker.Calendar.get(index).Tasks.size(); i++)
        {
            notepad.append(1 + i + ") " + worker.Calendar.get(index).Tasks.get(i).Name + "\n");
        }
    }


    public void ShowDoneTasks(Worker worker, JTextArea notepad)
    {
        notepad.setText(null);
        notepad.append("Oto wszystkie zadania,\nktore zostaly wykonane: \n\n");
        for(int i=0; i<worker.Calendar.size(); i++)
        {
            for(int j=0; j<worker.Calendar.get(i).Tasks.size(); j++)
            {
                if(worker.Calendar.get(i).Tasks.get(j).IsDone)
                {
                    Task tmp=worker.getUndoneTasks(i,j);
                    notepad.append(tmp.Name + "\n");
                }
            }
        }
    }

    public void ShowUndoneTasks(Worker worker, JTextArea notepad)
    {
        notepad.setText(null);
        notepad.append("Oto wszystkie zadania,\nktore jeszcze nie zostaly wykonane: \n\n");
        for(int i=0; i<worker.Calendar.size(); i++)
        {
            for(int j=0; j<worker.Calendar.get(i).Tasks.size(); j++)
            {
                if(!(worker.Calendar.get(i).Tasks.get(j).IsDone))
                {
                    Task tmp=worker.getUndoneTasks(i,j);
                    notepad.append(tmp.Name + "\n");
                }
            }
        }
    }

}
