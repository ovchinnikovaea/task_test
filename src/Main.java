import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 24));
        users.add(new User("Petr", 40));
        users.add(new User("Roman", 14));
        users.add(new User("Elena", 35));
        users.add(new User("Nikita", 23));

        User oldestUser = findOldestUser(users);
        System.out.println("Самый старый: " + oldestUser);

    }

    public static User findOldestUser(Collection<User> users) {
        return users.stream()
                .distinct()
                .sorted(Comparator.comparingInt(User::getAge).thenComparing(User::getName))
                .max(Comparator.comparingInt(User::getAge))
                .orElseThrow();

    }

}
