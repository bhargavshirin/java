import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public TodoListApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("=== To-Do List Application ===");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View Tasks");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added!");
    }

    public void removeTask() {
        System.out.print("Enter task number to remove: ");
        int taskNumber = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume the newline
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber);
            System.out.println("Task removed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TodoListApp todoListApp = new TodoListApp();
        int choice;

        do {
            todoListApp.displayMenu();
            choice = todoListApp.scanner.nextInt();
            todoListApp.scanner.nextLine();

            switch (choice) {
                case 1:
                    todoListApp.addTask();
                    break;
                case 2:
                    todoListApp.removeTask();
                    break;
                case 3:
                    todoListApp.viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        todoListApp.scanner.close();
    }
}
