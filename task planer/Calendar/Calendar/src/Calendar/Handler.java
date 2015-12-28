package Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 15.11.15.
 */
public class Handler{
    String[] HandleStringArray ;
    Worker worker;
    String[] possibilities = {"URGENT", "NORMAL", "LOW"};

    public Handler(Worker worker)
    {
        HandleStringArray = new String[2];
        this.worker=worker;
    }


    public Category HandleCategory(JFrame frame)  {

            JPanel p = new JPanel(new BorderLayout(5,5));

            JPanel labels = new JPanel(new GridLayout(0,1,2,2));
            labels.add(new JLabel("Podaj nazwe kategori ", SwingConstants.RIGHT));
            labels.add(new JLabel("Wybierz priorytet", SwingConstants.RIGHT));
            p.add(labels, BorderLayout.WEST);

            JPanel controls = new JPanel(new GridLayout(0,1,2,2));
            JTextField catName = new JTextField();
            controls.add(catName);

            JComboBox cbPriority = new JComboBox(possibilities);
            controls.add(cbPriority);

            p.add(controls, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(
                    frame, p, "Add Category", JOptionPane.QUESTION_MESSAGE);
            HandleStringArray[0]= catName.getText();
            HandleStringArray[1]= cbPriority.getSelectedItem().toString();

        HandleStringArray[1]=HandleStringArray[1].toLowerCase();
        if(HandleStringArray[1].matches(Priority.URGENT.name().toLowerCase()))
        {
            return new Category(HandleStringArray[0],Priority.URGENT);
        }
        else if(HandleStringArray[1].matches(Priority.NORMAL.name().toLowerCase()))
        {
            return new Category(HandleStringArray[0],Priority.NORMAL);
        }
        else
        {
            return new Category(HandleStringArray[0],Priority.LOW);
        }

    }

    public String[] HandleTask(JFrame frame) {

        String[] catNames = new String[worker.Calendar.size()];
        for(int i=0 ; i<worker.Calendar.size(); i++)
        {
            catNames[i] = worker.Calendar.get(i).Name;
        }

        JPanel p = new JPanel(new BorderLayout(5,5));

        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("Wybierz kategorie ", SwingConstants.RIGHT));
        labels.add(new JLabel("Podaj nazwe zadania", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
        JComboBox cbCat = new JComboBox(catNames);
        controls.add(cbCat);
        JTextField taskName = new JTextField();
        controls.add(taskName);
        p.add(controls, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(
                frame, p, "Add Task", JOptionPane.QUESTION_MESSAGE);
        HandleStringArray[0]= String.valueOf(cbCat.getSelectedIndex());
        HandleStringArray[1]= taskName.getText();
      return HandleStringArray;
    }

    public Integer WhichCategory(JFrame frame) throws Exception {
        String[] catNames = new String[worker.Calendar.size()];
        for(int i=0 ; i<worker.Calendar.size(); i++)
            catNames[i] = worker.Calendar.get(i).Name;

        String name = (String)JOptionPane.showInputDialog(
                frame,
                "Z ktorej kategori chcesz zobaczyc zadania ",
                "Wybierz kategorie",
                JOptionPane.PLAIN_MESSAGE,
                null,
                catNames,catNames[0]);
        if(name==null)
            throw new Exception("You haven't chose a proper task.");
        for(int i=0 ; i<worker.Calendar.size(); i++)
            if(name.equals(worker.Calendar.get(i).Name))
                return i;
        return null;
    }

    public int[] HandleMark(JFrame frame)
    {
        int[] HandleStringArray = new int[2];
        String[] catNames = getCategoryNames();


        JPanel p = new JPanel(new BorderLayout(5,5));

        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("Wybierz kategorie ", SwingConstants.RIGHT));
        labels.add(new JLabel("Wybierz zadanie", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
        JComboBox cbCat = new JComboBox(catNames);
        controls.add(cbCat);

        String[] tskNames = new String[worker.Calendar.get(cbCat.getSelectedIndex()).Tasks.size()];
        for(int i=0; i<worker.Calendar.get(cbCat.getSelectedIndex()).Tasks.size() ; i++)
        {
            if(!(worker.Calendar.get(cbCat.getSelectedIndex()).Tasks.get(i).IsDone))
                tskNames[i] = worker.Calendar.get(cbCat.getSelectedIndex()).Tasks.get(i).Name;
        }

        JComboBox cbTask = new JComboBox(tskNames);
        controls.add(cbTask);

        cbCat.addActionListener(e -> {
           int index = cbCat.getSelectedIndex();
            int HandleStringArrayHlp=0;
            cbTask.removeAllItems();
            String[] tskNames1 = new String[worker.Calendar.get(index).Tasks.size()];
            for(int i=0; i<worker.Calendar.get(index).Tasks.size() ; i++)
            {
                if(!(worker.Calendar.get(index).Tasks.get(i).IsDone)) {
                    tskNames1[HandleStringArrayHlp] = worker.Calendar.get(index).Tasks.get(i).Name;
                    HandleStringArrayHlp++;
                }
            }
            for(String name: tskNames1)
            {
                cbTask.addItem(name);
            }
        });

        p.add(controls, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(
                frame, p, "Add Category", JOptionPane.QUESTION_MESSAGE);
        HandleStringArray[0]= cbCat.getSelectedIndex();
        HandleStringArray[1]= cbTask.getSelectedIndex();
        return HandleStringArray;
    }

    private String[] getCategoryNames() {
        String[] catNames = new String[worker.Calendar.size()];
        for (int i = 0; i < worker.Calendar.size(); i++) {
            catNames[i] = worker.Calendar.get(i).Name;
        }
        return catNames;
    }

    public int[] HandleDelete(JFrame frame)
    {
       return HandleMark(frame);
    }

}
