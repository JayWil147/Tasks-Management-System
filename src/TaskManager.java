import java.util.ArrayList;

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
}