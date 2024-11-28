import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private Integer  taskId;
    private String taskDescription;
    private String dueDate;
    private String priority;
    private String taskStatus;
    private  User user;
    public Task(User user,int taskId, String taskDescription, String dueDate, String priority, String status) {
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.priority = priority;
        this.taskStatus = status;
        this.taskId = taskId;
        this.user = user;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId && Objects.equals(taskDescription, task.taskDescription) && Objects.equals(dueDate, task.dueDate) && Objects.equals(priority, task.priority) && Objects.equals(taskStatus, task.taskStatus) && Objects.equals(user, task.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskDescription, dueDate, priority, taskStatus, user);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", priority='" + priority + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", user=" + user +
                '}';
    }
}
