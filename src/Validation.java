import java.util.regex.Pattern;

public class Validation {

    public static boolean emailValidation(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(email.matches(regex)) {
            return true;
        };
        System.out.println("Enter a valid email (e.g., for@example).");
        return false;
    }
    public static boolean passwordValidation(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&+])[A-Za-z\\d@$!%*?&+]{8,}$";
        if(password.matches(regex)) {
            return true;
        }
        System.out.println("The password must consist of at least 8 characters" +
                " (uppercase and lowercase letters, numbers, and special symbols). ");
        return false;
    }
    public static boolean taskNameValidation(String name) {
        if(!name.isEmpty()){
            return true;
        }
        System.out.println("Enter a valid task name.");
        return false;
    }
    public static boolean taskDueDateValidation(String dueDate) {
        String regex = "^\\d{4}\\.(0[1-9]|1[0-2])\\.(0[1-9]|[12]\\d|3[01])$";
       if(dueDate.matches(regex)) {
           return true;
       }
       System.out.println("Enter a valid due date.");
       return false;
    }
    public static boolean taskPriorityValidation(String priority) {
        if(!priority.isEmpty() && checkPriority(priority)){
            return true;
        }
        System.out.println("Enter a valid task priority.");
        return false;
    }

    private static boolean checkPriority(String priority) {
        return priority.equals("high") || priority.equals("medium") || priority.equals("low");
    }
    public static boolean taskStatusValidation(String status) {
        if(!status.isEmpty() && checkStatus(status)){
            return true;
        }
        System.out.println("Enter a valid task status.");
        return false;
    }
    private static boolean checkStatus(String status) {
        return status.equals("pending") || status.equals("completed") || status.equals("done");
    }
}
