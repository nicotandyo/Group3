package test;

import employee.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the Employee class
 *
 * @author Nico Tandyo
 * @author Yau Tsang
 */
public class EmployeeTest {

    /**
     * Username.
     */
    private String myUserName = "EmployeeTest";

    /**
     * Password for login.
     */
    private String myPassword = "employee";

    /**
     * Role.
     */
    private int myRole = 1;

    /**
     * Student ID.
     */
    private String myId = "982345";

    /**
     * An Employee.
     */
    private Employee myEmployee;

    /**
     * Set up the employee.
     *
     * @throws Exception if error occur.
     */
    @Before
    public void setUp() throws Exception {
        myEmployee = new Employee(myUserName, myPassword);
        myEmployee.setMyRole(myRole);
        myEmployee.setMyId(myId);
    }

    /**
     * Test the constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor() {
        new Employee(null, null);
        new Employee("John", null);
    }

    /**
     * Test setMyUserName and getMyUserName methods.
     */
    @Test
    public void testSetGetName() {
        String test = "SetTest";
        myEmployee.setMyUserName(test);
        assertEquals(myEmployee.getMyUserName(), test);
    }

    /**
     * Test setMyPassword and getMyPassword methods.
     */
    @Test
    public void testSetGetPassword() {
        String test = "setpassword";
        myEmployee.setMyPassword(test);
        assertEquals(myEmployee.getMyPassword(), test);
    }

    /**
     * Test setMyRole and getMyRole methods.
     */
    @Test
    public void testSetGetRole() {
        int test = 0;
        myEmployee.setMyRole(test);
        assertEquals(myEmployee.getMyRole(), test);
    }

    /**
     * Test setMyID and getMyID methods.
     */
    @Test
    public void testSetGetID() {
        String test = "0987766";
        myEmployee.setMyId(test);
        assertEquals(myEmployee.getMyId(), test);
    }

}
