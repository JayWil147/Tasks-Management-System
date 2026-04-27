import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        int choice = 0;

        while (choice != 8) {
            displayMenu();
            choice = getMenuChoice(input);

            switch (choice) {
                case 1:
                    addTaskMenu(manager, input);
                    break;
                case 2:
                    manager.viewTasks();
                    break;
                case 3:
                    searchTaskMenu(manager, input);
                    break;
                case 4:
                    markTaskCompleteMenu(manager, input);
                    break;
                case 5:
                    removeTaskMenu(manager, input);
                    break;
                case 6:
                    System.out.println("Save feature will be added next.");
                    break;
                case 7:
                    System.out.println("Load feature will be added next.");
                    break;
                case 8:
                    System.out.println("Exiting Task Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu choice. Please try again.");
            }

            System.out.println();
        }

        input.close();
    }

    public static void displayMenu() {
        System.out.println("===== TASK MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Search Tasks");
        System.out.println("4. Mark Task Complete");
        System.out.println("5. Remove Task");
        System.out.println("6. Save Tasks to File");
        System.out.println("7. Load Tasks from File");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    public static int getMenuChoice(Scanner input) {
        int choice;

        try {
            choice = input.nextInt();
        }
        catch (Exception e) {
            input.nextLine();
            return -1;
        }

        input.nextLine();
        return choice;
    }

    public static void addTaskMenu(TaskManager manager, Scanner input) {
        System.out.print("Enter task title: ");
        String title = input.nextLine();

        System.out.print("Enter task description: ");
        String description = input.nextLine();

        System.out.print("Enter task category: ");
        String category = input.nextLine();

        System.out.print("Enter task priority: ");
        String priority = input.nextLine();

        System.out.print("Enter task due date: ");
        String dueDate = input.nextLine();

        Task newTask = new Task(title, description, category, priority, dueDate, false);
        manager.addTask(newTask);

        System.out.println("Task added successfully.");
    }

    public static void searchTaskMenu(TaskManager manager, Scanner input) {
        System.out.print("Enter keyword to search: ");
        String keyword = input.nextLine();
        manager.searchTasks(keyword);
    }

    public static void markTaskCompleteMenu(TaskManager manager, Scanner input) {
        if (!manager.hasTasks()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.print("Enter task number to mark complete: ");

        try {
            int taskNumber = input.nextInt();
            input.nextLine();
            manager.markTaskComplete(taskNumber - 1);
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
        }
    }

    public static void removeTaskMenu(TaskManager manager, Scanner input) {
        if (!manager.hasTasks()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.print("Enter task number to remove: ");

        try {
            int taskNumber = input.nextInt();
            input.nextLine();
            manager.removeTask(taskNumber - 1);
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
        }
    }
}