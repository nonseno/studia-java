package Calendar;

/**
 * Created by Admin on 24.10.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();
        MenuPrinter menuPrinter= new MenuPrinter();
        int choice=0;
        while(choice!=8) {
            choice=menuPrinter.ShowMenu();
            switch(choice)
            {
                case 1:
                    worker.addCategory();
                    break;
                case 2:
                    worker.addTask();
                    break;
                case 3:
                    menuPrinter.ShowCategories(worker);
                    break;
                case 4:
                    menuPrinter.ShowCategoriesPriority(worker);
                    break;
                case 5:
                    worker.removeTask();
                    break;
                case 6:
                    worker.markTask();
                    break;
                case 7:
                    menuPrinter.showUndoneTasks(worker);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

    }
}
