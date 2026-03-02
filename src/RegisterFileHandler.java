import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStream;

public class RegisterFileHandler extends LibrarySystem {
    UserType userType;
    String userName;

    RegisterFileHandler(UserType userType, String userName) {
        this.userType = userType;
        this.userName = userName;
    }

    public void registerNewUser() throws Exception {
        try(BufferedWriter out = new BufferedWriter(new FileWriter("users.txt"))) {
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
