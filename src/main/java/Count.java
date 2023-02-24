import java.util.ArrayList;
import java.util.Collections;

public class Count {
    public static void main(String[] args) {
        System.out.println("");
        User user1 = UserCreater.GetCreater().CreateUser("BBB");
        User user2 = UserCreater.GetCreater().CreateUser("BBB");
        User user3 = UserCreater.GetCreater().CreateUser("BBB");
        User user4 = UserCreater.GetCreater().CreateUser("BBB");
        User user5 = UserCreater.GetCreater().CreateUser("BBB");
        System.out.println(user5.id);
    }


}
class User {
    int id;
    String firstName;

    public User(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}

class UserCreater {
    static private UserCreater Creater;
    private Repo repo;

    public static UserCreater GetCreater() {
        if (Creater == null) {
            Creater = new UserCreater();
        }
        return Creater;
    }
    public User CreateUser(String firstName) {
        int id = repo.getLastId();
        return new User(id, firstName);
    }
    private UserCreater() {
        repo = new Repo();
    }
}

class Repo {
    ArrayList<Integer> liId = new ArrayList<>();
    public int getLastId() {
        if (liId.size() > 0) {
            liId.add(Collections.max(liId) + 1);
            return Collections.max(liId);
        } else {
            liId.add(1);
            return 1;
        }
    }
}