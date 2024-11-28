import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserService extends Storage {
    public static List<User> users = new ArrayList<User>();

    public void register() {
        User u = enterUser();
        if(Validation.emailValidation(u.getEmail()) && Validation.passwordValidation(u.getPassword())) {
            for (User u1 : users) {
                if (u.getEmail().equals(u1.getEmail())) {
                    System.out.println("User already registered");
                    return;
                }
            }
            users.add(u);
            Storage.user=u;
            System.out.println("User registered successfully");
        }
        else {
            throw new RuntimeException("Email ve parolu duzgun daxil edin");
        }

    }

    public void login() {
        User u = enterUser();
        for(User u1 : users) {
            if (u1.getEmail().equals(u.getEmail()) && u1.getPassword().equals(u.getPassword())) {
                System.out.println("User logged in");
                Storage.user=u;
                return;
            }
        }
        throw new RuntimeException("User not found");
    }

    public void changePassword() {
        Scanner scanner = new Scanner(System.in);
        User user = enterUser();
        for(User u1 : users) {
            if (u1.getEmail().equals(user.getEmail()) && u1.getPassword().equals(user.getPassword())) {
                System.out.println("Change Password");
                String newPassword = scanner.nextLine();
                if(Validation.passwordValidation(newPassword)) {
                    u1.setPassword(newPassword);
                    System.out.println("Password changed successfully");
                    return;
                }

            }
        }
        throw new RuntimeException("User or password is incorrect");
    }

    public void updateUserList() {
        User user = enterUser();
        Scanner scanner = new Scanner(System.in);
        for(User u1 : users) {
            if (u1.getEmail().equals(user.getEmail()) && u1.getPassword().equals(user.getPassword())) {
                System.out.println("Enter new email");
                String newEmail = scanner.nextLine();
                u1.setEmail(newEmail);
                System.out.println("Email changed successfully");
                return;
            }
        }
        throw new RuntimeException("User not found");
    }

    public User enterUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        return new User(username, password);
    }
    public void logout() {
        Storage.user=null;
        System.out.println("Logged out successfully");
    }

}
