import java.util.Scanner;
import java.util.ArrayList;

public class ToDo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        final String menu = "Menu for Task:\n1. See Tasks\n2. Add Task\n3. Clear Task";
        ArrayList<String> tasks = new ArrayList<String>();
        boolean more = false;
        String menuOption;
        String taskNum;

        System.out.println(menu.concat("\nEnter a number:"));
        menuOption = sc.nextLine();

        do {
            // Clear CDL
            for(int s = 0; s < 6; s++) {
                System.out.println("\n");
            }

            switch(menuOption){
                case "1":
                    // Display task
                    if(!(tasks.isEmpty())) {
                        System.out.println("Task List:");
                        for(int i = 0; i < tasks.size(); i++) {
                            System.out.println((i +1) + ". " + tasks.get(i));
                        }
                    } else {
                        System.out.println("Task list is empty.");
                    }
                    break;
                case "2":
                    // Add task to list
                    System.out.println("Enter Task:");
                    tasks.add(sc.nextLine());
                    break;
                case "3":
                    // Remove task from list
                    if(!tasks.isEmpty()) {
                        System.out.println("Which task to remove:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        taskNum = sc.nextLine();
                        int num = Integer.parseInt(taskNum);
                        System.out.println("Task removed\n" + tasks.get(num - 1));
                        tasks.remove(num - 1);
                    } else {
                        System.out.println("List already empty");
                    }
                    break;
            }
            
            // Space
            System.out.println("\n");
            
            System.out.println(menu.concat("\n4. Exit\nEnter a number"));
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
        
        // Test section 
        /* 
        System.out.println(more);
        System.out.println("Option is: " + menuOption);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
        */
        sc.close();
        }
}