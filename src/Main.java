import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       while(true) {
           try {
               Scanner sc = new Scanner(System.in);
               UserService userService = new UserService();
               TaskService taskService = new TaskService();
               System.out.println("1) Register");
               System.out.println("2) Login");
               System.out.println("3) change Password");
               System.out.println("4) update username");
               System.out.println("5) add task");
               System.out.println("6) see all tasks");
               System.out.println("7) change task status");
               System.out.println("8) delete task");
               System.out.println("9) logout");
               System.out.println("10) exit");
               int num = sc.nextInt();
               switch(num) {
                   case 1:userService.register();break;
                   case 2:userService.login();break;
                   case 3:userService.changePassword();break;
                   case 4:userService.updateUserList();break;
                   case 5:taskService.addTask();break;
                   case 6:taskService.getTasks();break;
                   case 7:taskService.updateTaskStatus();break;
                   case 8:taskService.deleteTask();break;
                   case 9:userService.logout();break;
                   case 10: System.exit(0);break;
                   default: break;
               }
           }
           catch (Exception e) {
               System.err.println(e.getMessage());
           }

       }
    }
}