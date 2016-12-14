package employee;

import data.EmployeeDB;

import java.sql.SQLException;

/**
 * It's a collection of all the employees login.
 * @author Yau
 * @author Nico Tandyo
 */
public class EmployeeCollection {

    /**
     * Employee collection's database for connecting to the data base.
     */
    private static EmployeeDB myEmployeeDB;

    /**
     * A login to find employee is in the system or not.
     *
     * @param theUsername An employee's username.
     * @param thePassword An employee's password.
     * @param theRole     A role 1 is employee, 2 is student.
     * @return true if found, otherwise return false.
     * @throws SQLException if query is not correct.
     */
    public static boolean login(final String theUsername,
                                final String thePassword,
                                final int theRole) throws SQLException {
        if (myEmployeeDB == null) {
            myEmployeeDB = new EmployeeDB();
        }

        String message = myEmployeeDB.login(theUsername, thePassword, theRole);
        return message != null;
    }
}
