import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TaskService {
    public static List<Task> tasks = new ArrayList<Task>();
    public static int count = 0;

    public void addTask() {
        if (!UserService.users.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Task Description: ");
            String taskName = "";
            for (int i = 0; i < 3; i++) {
                taskName = scanner.next();
                if (Validation.taskNameValidation(taskName)) {
                    break;
                }
                if(i==2){
                    throw new RuntimeException("User is blocked");
                }
                System.out.println("Try again: ");
            }

            System.out.println("Enter Due Date (YYYY-MM-DD): ");
            String dueDate = "";
            for (int i = 0; i < 3; i++) {
                dueDate = scanner.next();
                if (Validation.taskDueDateValidation(dueDate)) {
                    break;
                }
                if(i==2){
                    throw new RuntimeException("User is blocked");
                }
                System.out.println("Try again: ");
            }
            System.out.println("Enter Task Priority: ");
            String taskPriority = "";
            for (int i = 0; i < 3; i++) {
                taskPriority = scanner.next();
                if (Validation.taskPriorityValidation(taskPriority)) {
                    break;
                }
                if(i==2){
                    throw new RuntimeException("User is blocked");
                }
                System.out.println("Try again: ");
            }
            System.out.println("Enter Task Status: ");
            String taskStatus = "";
            for (int i = 0; i < 3; i++) {
                taskStatus = scanner.next();
                if (Validation.taskStatusValidation(taskStatus)) {
                    break;
                }
                if(i==2){
                    throw new RuntimeException("User is blocked");
                }
                System.out.println("Try again: ");

            }
            Task task = new Task(Storage.user, Storage.taskId++, taskName, dueDate, taskPriority, taskStatus);
            tasks.add(task);
            System.out.println("Task  successfully is added");
        } else {
            System.out.println("Not Logged In");
        }
    }

    public void getTasks() {
        if (Storage.user != null && !tasks.isEmpty()) {
            tasks.forEach(task -> {
                if(task.getUser().equals(Storage.user)){
                    System.out.println(task);
                }
            });
        } else {
            System.out.println("Not Logged In Or Task List Is Empty");
        }
    }

    public void updateTaskStatus() {
        if (Storage.user != null && !tasks.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Task ID: ");
            Integer taskID = scanner.nextInt();
            for (Task task : tasks) {
                if (task.getTaskId() ==taskID) {
                    System.out.println("Enter New Task Status: ");
                    for(int i=0; i<3;i++){
                        String newTaskStatus = scanner.next();
                        if(Validation.taskStatusValidation(newTaskStatus)){
                            task.setTaskStatus(newTaskStatus);
                            System.out.println("Task Status successfully updated");
                            break;
                        }
                        if(i==2){
                            throw new RuntimeException("User is blocked");
                        }
                        System.out.println("Try again: ");
                    }
                }
            }

        } else {
            System.out.println("Not Logged In or Task List Is Empty");
        }
    }

    public void deleteTask() {
        if (Storage.user != null && !tasks.isEmpty()) {
            System.out.println("show all tasks");
            getTasks();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Task ID: ");
            Integer taskID = scanner.nextInt();
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task item = iterator.next();
                if (item.getTaskId() == taskID) {
                    iterator.remove();
                    System.out.println("Task successfully deleted");
                }
            }
        } else {
            System.out.println("Not Logged In or Task List Is Empty");
        }
    }
}
