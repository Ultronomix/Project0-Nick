import java.util.Scanner;

public class ToDo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String task = "";
        boolean more = false;

        System.out.print("Menu for Task:\n1. See Tasks\n2. Add Task\n3. Clear Task\nEnter number: ");
        String menuOption = sc.nextLine();

        do {
            switch(menuOption){
                case "1":
                    // Display task
                    System.out.println("Tasks are:\n" + task);
                    break;
                case "2":
                    System.out.println("Enter Task:");
                    if(task == ""){
                        task = sc.nextLine();
                    } else {
                        task = task + "\n" + sc.nextLine();
                    }
                    break;
                case "3":
                    //remove task
                    System.out.println(task);
                    break;
            }
            
            System.out.print("Repeat: ");
            menuOption = sc.nextLine();

            switch(menuOption){
                case "1":
                case "2":
                case "3":
                    more = true;
                    break;
                default:
                    more = false;
            }
        } while (more);
        
        //System.out.println("Enter ToDo task:");
        //task = sc.nextLine();

        System.out.println("Option is: " + menuOption);
        System.out.println("Task are : " + task);
        sc.close();
        }
}