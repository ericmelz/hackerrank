package hackerrank.problems.compareuserlists;

import java.util.*;

public class CompareUserLists {
    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Result {
        List<User> insertions = new ArrayList<>();
        List<User> updates = new ArrayList<>();
    }

    public static Result compareLists(List<User> current, List<User> updates) {
        Result result = new Result();

        // Put all current users into a set, this will be used to check if we need to update
        Set<User> currentSet = new HashSet<>(current);
        for (User user: updates) {
            if (user.id == 0) {
                result.insertions.add(user);
            } else {
                if (!currentSet.contains(user)) {
                    result.updates.add(user);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("hey");
        List<User> current = new ArrayList<>();
        User u1 = new User(1, "User1");
        User u2 = new User(2, "User2");
        current.add(u1);
        current.add(u2);

        List<User> updates = new ArrayList<>();
        User u3 = new User(1, "User4");
        User u4 = new User(0, "User5");
        User u5 = new User(2, "User2");
        updates.add(u3);
        updates.add(u4);
        updates.add(u5);

        Result result = compareLists(current, updates);
        System.out.println("Insertions:");
        for (User user: result.insertions) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println("Updates:");
        for (User user: result.updates) {
            System.out.println(user);
        }
    }
}
