package Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Admin on 01.12.15.
 */
public class CalendarGUI extends JFrame implements ActionListener{

    private JTextArea taShow;
    private JButton bAddCat;
    private JButton bAddTask;
    private JButton bDelete;
    private JButton bShowAllCat;
    private JButton bShowAllTasks;
    private JButton bShowDone;
    private JButton bShowUndone;
    private JButton bMark;
    private JLabel lDone;
    private JLabel lUndone;
    private Handler handler;
    private Worker worker;
    private Printer printer;
    private PieChart pieChart;
    private int[] numberOfDoneUndone;
    private ArrayList<Double> values;
    private ArrayList<Color> colors;




    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new CalendarGUI());
    }




    CalendarGUI()
    {
        super("Task planner");
        worker= new Worker();
        handler = new Handler(worker);
        printer = new Printer();
        numberOfDoneUndone = new int[2];
        values = new ArrayList<>();
        colors = new ArrayList<>();
        createUIComponents();
    }


    private void createUIComponents() {
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        taShow = new JTextArea();
        JScrollPane spShow = new JScrollPane(taShow);
        spShow.setBounds(10,10,250,300);
        add(spShow);


        bAddCat = new JButton("Add Category");
        bAddCat.setBounds(10,350,110,20);
        add(bAddCat);
        bAddCat.addActionListener(this);

        bAddTask = new JButton("Add Task");
        bAddTask.setBounds(130,350,100,20);
        add(bAddTask);
        bAddTask.addActionListener(this);

        bDelete = new JButton("Delete");
        bDelete.setBounds(240,350,90,20);
        add(bDelete);
        bDelete.addActionListener(this);

        bMark = new JButton("Mark");
        bMark.setBounds(340,350,80,20);
        add(bMark);
        bMark.addActionListener(this);

        bShowAllCat = new JButton("Show All Categories");
        bShowAllCat.setBounds(10,380,200,20);
        add(bShowAllCat);
        bShowAllCat.addActionListener(this);

        bShowAllTasks = new JButton("Show all tasks");
        bShowAllTasks.setBounds(220,380,200,20);
        add(bShowAllTasks);
        bShowAllTasks.addActionListener(this);

        bShowDone = new JButton("Show done tasks");
        bShowDone.setBounds(10,410,200,20);
        add(bShowDone);
        bShowDone.addActionListener(this);

        bShowUndone = new JButton("Show undone tasks");
        bShowUndone.setBounds(220,410,200,20);
        add(bShowUndone);
        bShowUndone.addActionListener(this);

        numberOfDoneUndone=worker.returnNumberofDoneUndone();
        values.add(new Double(numberOfDoneUndone[0]));
        values.add(new Double(numberOfDoneUndone[1]));

        colors.add(Color.blue);
        colors.add(Color.red);

        pieChart = new PieChart(values, colors);
        pieChart.setBounds(290,10,180,180);
        add(pieChart);

        lDone = new JLabel("Done: "+ (int)(((double)numberOfDoneUndone[0]/(numberOfDoneUndone[0]+numberOfDoneUndone[1]))*100)+"%");
        lDone.setBounds(290,200,100,20);
        lDone.setForeground(Color.blue);
        add(lDone);
        lUndone = new JLabel("Undone: "+ (100-(int)(((double)numberOfDoneUndone[0]/(numberOfDoneUndone[0]+numberOfDoneUndone[1]))*100))+"%");
        lUndone.setBounds(390,200,100,20);
        lUndone.setForeground(Color.red);
        add(lUndone);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source==bAddCat)
        {
           worker.AddCategory(handler.HandleCategory(this));
        }
        if(source==bAddTask)
        {
            worker.AddTask(handler.HandleTask(this));
            UpdatePieChart();
        }
        if(source==bDelete)
        {
            worker.DeleteTask(handler.HandleDelete(this));
            UpdatePieChart();
        }
        if(source==bMark)
        {
            worker.MarkTask(handler.HandleMark(this));
            UpdatePieChart();
        }
        if(source==bShowAllCat)
        {
            printer.ShowCategories(worker, taShow);
        }
        if(source==bShowAllTasks)
        {
            try {
                printer.ShowCategoryTasks(worker,taShow,handler.WhichCategory(this));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if(source==bShowDone) {
            printer.ShowDoneTasks(worker, taShow);
        }
        if(source==bShowUndone)
        {
            printer.ShowUndoneTasks(worker, taShow);
        }


    }

    public void UpdatePieChart()
    {

        numberOfDoneUndone=worker.returnNumberofDoneUndone();
        values = new ArrayList<>();
        colors = new ArrayList<>();
        values.add(new Double(numberOfDoneUndone[0]));
        values.add(new Double(numberOfDoneUndone[1]));
        remove(pieChart);
        colors.add(Color.blue);
        colors.add(Color.red);
        pieChart = new PieChart(values, colors);
        pieChart.setBounds(290,10,180,180);
        remove(lDone);
        remove(lUndone);
        revalidate();
        lDone = new JLabel("Done: "+ (int)(((double)numberOfDoneUndone[0]/(numberOfDoneUndone[0]+numberOfDoneUndone[1]))*100)+"%");
        lDone.setBounds(290,200,100,20);
        lDone.setForeground(Color.blue);
        lUndone = new JLabel("Undone: "+ (100-(int)(((double)numberOfDoneUndone[0]/(numberOfDoneUndone[0]+numberOfDoneUndone[1]))*100))+"%");
        lUndone.setBounds(390,200,100,20);
        lUndone.setForeground(Color.red);
        add(pieChart);
        add(lDone);
        add(lUndone);
        repaint();
    }




}
