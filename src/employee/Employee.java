package employee;

/**
 * Employee class represents a single employee with username, password,
 * and role.
 * @author Yau
 * @author Nico Tandyo
 */
public class Employee {

    /**
     * Employee's login username.
     */
    private String myUserName;

    /**
     * Employee's login password.
     */
    private String myPassword;

    /**
     * Employee's role.
     */
    private int myRole;

    /**
     * Employee's ID.
     */
    private String myId;

    /**
     * Creates an employee with the specified username and password.
     *
     * @param theUserName A String containing the employee's username.
     * @param thePassword A String containing the employee's password.
     */
    public Employee(final String theUserName, final String thePassword) {
        if (theUserName == null || thePassword == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.myUserName = theUserName;
        this.myPassword = thePassword;
    }

    /**
     * Gets the employee's username.
     *
     * @return A string representing the employee's username.
     */
    public String getMyUserName() {
        return myUserName;
    }

    /**
     * Sets the employee's username.
     *
     * @param myUserName A String containing
     *                   the employee's username.
     */
    public void setMyUserName(String myUserName) {
        this.myUserName = myUserName;
    }

    /**
     * Gets the employee's password.
     *
     * @return A string representing the employee's password.
     */
    public String getMyPassword() {
        return myPassword;
    }

    /**
     * Sets the employee's password.
     *
     * @param thePassword A String containing the employee's password.
     */
    public void setMyPassword(final String thePassword) {
        this.myPassword = thePassword;
    }

    /**
     * Gets the employee's role.
     *
     * @return An integer representing the employee's role.
     */
    public int getMyRole() {
        return myRole;
    }

    /**
     * Sets the employee's role.
     *
     * @param theRole An integer containing the employee's role.
     */
    public void setMyRole(final int theRole) {
        this.myRole = theRole;
    }

    /**
     * Gets the employee's ID.
     *
     * @return A String representing the employee's ID.
     */
    public String getMyId() {
        return myId;
    }

    /**
     * Sets the employee's ID.
     *
     * @param theId A String containing the employee's ID.
     */
    public void setMyId(final String theId) {
        this.myId = theId;
    }

//    /**
//     * It's for debugging.
//     *
//     * @return a String of all data
//     */
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "myUserName='" + myUserName + '\'' +
//                ", myPassword='" + myPassword + '\'' +
//                ", myRole=" + myRole +
//                '}';
//    }
}
