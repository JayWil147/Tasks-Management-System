import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean hasTasks() {
        return tasks.size() > 0;
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public void viewTasks() {
        if (!hasTasks()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task #" + (i + 1));
            System.out.println(tasks.get(i));
            System.out.println();
        }
    }

    public void searchTasks(String keyword) {
        boolean found = false;
        String lowerKeyword = keyword.toLowerCase();

        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);

            if (currentTask.getTitle().toLowerCase().contains(lowerKeyword)
                    || currentTask.getDescription().toLowerCase().contains(lowerKeyword)
                    || currentTask.getCategory().toLowerCase().contains(lowerKeyword)
                    || currentTask.getPriority().toLowerCase().contains(lowerKeyword)
                    || currentTask.getDueDate().toLowerCase().contains(lowerKeyword)) {
                System.out.println("Task #" + (i + 1));
                System.out.println(currentTask);
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching tasks found.");
        }
    }

    public void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markComplete();
            System.out.println("Task marked as complete.");
        }
        else {
            System.out.println("Invalid task number.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully.");
        }
        else {
            System.out.println("Invalid task number.");
        }
    }

    public void saveTasksToFile(String fileName) {
        try {
            PrintWriter output = new PrintWriter(fileName);

            for (int i = 0; i < tasks.size(); i++) {
                output.println(tasks.get(i).toFileString());
            }

            output.close();
            System.out.println("Tasks saved successfully.");
        }
        catch (Exception e) {
            System.out.println("Error saving tasks to file.");
        }
    }

    public void loadTasksFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner fileInput = new Scanner(file);

            tasks.clear();

            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] parts = line.split("\\|");

                if (parts.length == 6) {
                    String title = parts[0];
                    String description = parts[1];
                    String category = parts[2];
                    String priority = parts[3];
                    String dueDate = parts[4];
                    boolean completed = Boolean.parseBoolean(parts[5]);

                    Task loadedTask = new Task(title, description, category,
                            priority, dueDate, completed);

                    tasks.add(loadedTask);
                }
            }

            fileInput.close();
            System.out.println("Tasks loaded successfully.");
        }
        catch (Exception e) {
            System.out.println("Error loading tasks from file.");
        }
    }
}