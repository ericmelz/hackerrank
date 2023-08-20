package hackerrank.problems.compareuserlists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;


/**
 * Try with this input
 * 4
 * 1,0,First0,Last0,40,1993.05.23,email0@gmail.com,Male,Country0,City0,Address0,ZipCode0,PhoneNumber0,Department0,Role0,2016.07.18,656,Active
 * 2,7984,First1,Last1,50,1997.01.05,email1@gmail.com,Female,Country1,City1,Address1,ZipCode1,PhoneNumber1,Department1,Role1,2018.10.08,778,Inactive
 * 3,5968,First2,Last2,0,1999.03.20,email2@gmail.com,Male,Country2,City2,Address2,ZipCode2,PhoneNumber2,Department2,Role2,2019.10.16,734,Active
 * 4,3952,First3,Last3,10,1989.04.02,email3@gmail.com,Female,Country3,City3,Address3,ZipCode3,PhoneNumber3,Department3,Role3,2016.11.05,858,Inactive
 * 2
 * 1,0,First0,Last0,40,1993.05.09,email0@gmail.com,Male,Country0,City0,Address0,ZipCode0,PhoneNumber0,Department0,Role0,2017.02.24,176,Active
 * 2,7984,First1,Last1,50,1997.01.05,email1@gmail.com,Female,Country1,City1,Address1,ZipCode1,PhoneNumber1,Department1,Role1,2018.10.08,778,Inactive
 *
 * Expected output:
 * Updated Users:1
 * Inserted Users:0
 */
public class Solution2 {
    /*
     * Complete the 'CompareUsers' function below.
     *
     * The function is expected to return two lists which are updated and inserted.
     * The function accepts two lists usersListInDB and newUsersList as parameter.
     */
    public static List<User>[] compareUsers(List<User> usersListInDB, List<User> newUsersList) {
        List<User> insertions = new ArrayList<>();
        List<User> updates = new ArrayList<>();

        Map<Integer, User> db = new HashMap<>();
        for (User oldUser: usersListInDB) {
            db.put(oldUser.getId(), oldUser);
        }

        try {
            for (User newUser: newUsersList) {
                if (newUser.getId() == 0) {
                    insertions.add(newUser);
                } else {
                    User oldUser = db.get(newUser.getId());
                    if (!areEqual(newUser, oldUser)) {
                        updates.add(newUser);
                    }
                }
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return List.of(updates, insertions).toArray(new List[0]);
    }

    public static boolean areEqual(Object o1, Object o2) throws IllegalAccessException {
        Class<?> clazz1 = o1.getClass();
        Class<?> clazz2 = o2.getClass();
        if (!clazz1.equals(clazz2)) {
            return false;
        }

        // Get all declared fields, including private ones
        Field[] fields = clazz1.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Make the private field accessible
            String name = field.getName();
            Object value1 = field.get(o1);
            Object value2 = field.get(o2);

            if (!Objects.equals(value1, value2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter writer = new PrintWriter(System.getenv("OUTPUT_PATH"), "UTF-8");
        PrintWriter writer = new PrintWriter(System.out);

        List<User> usersListInDB = new ArrayList<>();
        List<User> newUsersList = new ArrayList<>();

        int userInDbCount = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < userInDbCount; i++) {
            String[] u = reader.readLine().trim().split(",");
            User usr = new User();
            usr.setId(u[0].isEmpty() ? 0 : Integer.parseInt(u[0]));
            usr.setIdentityNumber(u[1]);
            usr.setFirstName(u[2]);
            usr.setLastName(u[3]);
            usr.setAge(u[4].isEmpty() ? 0 : Integer.parseInt(u[4]));
            usr.setBirthDate(u[5].isEmpty() ? null : LocalDate.of(Integer.parseInt(u[5].split("\\.")[0]), Integer.parseInt(u[5].split("\\.")[1]), Integer.parseInt(u[5].split("\\.")[2])));
            usr.setEmail(u[6]);
            usr.setGender(u[7]);
            usr.setCountry(u[8]);
            usr.setCity(u[9]);
            usr.setAddress(u[10]);
            usr.setZipCode(u[11]);
            usr.setPhoneNumber(u[12]);
            usr.setDepartment(u[13]);
            usr.setRoles(u[14]);
            usr.setJoinDate(u[15].isEmpty() ? null : LocalDate.of(Integer.parseInt(u[15].split("\\.")[0]), Integer.parseInt(u[15].split("\\.")[1]), Integer.parseInt(u[15].split("\\.")[2])));
            usr.setCredit(u[16].isEmpty() ? 0.0 : Double.parseDouble(u[16]));
            usr.setStatus(u[17]);
            usersListInDB.add(usr);
        }

        int newUsersCount = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < newUsersCount; i++) {
            String[] u = reader.readLine().trim().split(",");
            User usr = new User();
            usr.setId(u[0].isEmpty() ? 0 : Integer.parseInt(u[0]));
            usr.setIdentityNumber(u[1]);
            usr.setFirstName(u[2]);
            usr.setLastName(u[3]);
            usr.setAge(u[4].isEmpty() ? 0 : Integer.parseInt(u[4]));
            usr.setBirthDate(u[5].isEmpty() ? null : LocalDate.of(Integer.parseInt(u[5].split("\\.")[0]), Integer.parseInt(u[5].split("\\.")[1]), Integer.parseInt(u[5].split("\\.")[2])));
            usr.setEmail(u[6]);
            usr.setGender(u[7]);
            usr.setCountry(u[8]);
            usr.setCity(u[9]);
            usr.setAddress(u[10]);
            usr.setZipCode(u[11]);
            usr.setPhoneNumber(u[12]);
            usr.setDepartment(u[13]);
            usr.setRoles(u[14]);
            usr.setJoinDate(u[15].isEmpty() ? null : LocalDate.of(Integer.parseInt(u[15].split("\\.")[0]), Integer.parseInt(u[15].split("\\.")[1]), Integer.parseInt(u[15].split("\\.")[2])));
            usr.setCredit(u[16].isEmpty() ? 0.0 : Dozuble.parseDouble(u[16]));
            usr.setStatus(u[17]);
            newUsersList.add(usr);
        }

        List<User> res[] = Solution2.compareUsers(usersListInDB, newUsersList);
        writer.println("Updated Users:" + res[0].size());
        writer.println("Inserted Users:" + res[1].size());
        writer.flush();
        writer.close();
    }
}
