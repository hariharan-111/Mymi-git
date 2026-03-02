import javax.swing.*;

public class LibrarySystem {
    UserType userType;
    String userName;

    LibrarySystem(UserType userType, String userName) {
        this.userType = userType;
        this.userName = userName;
    }

    LibrarySystem() {}


    public boolean login() {
        return true;
    }

    public boolean logout() {
        return true;
    }

    public void Register() {
        RegisterFileHandler register = new RegisterFileHandler(this.userType, this.userName);
    }
}
