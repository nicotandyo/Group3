package test;

import org.junit.Before;
import org.junit.Test;
import student.Output;
import student.Student;
import student.StudentCollection;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the StudentCollection class.
 *
 * @author Nico Tandyo
 * @author Yau Tsang
 */
public class StudentCollectionTest {

    /**
     * A student that contains student's information.
     */
    private Student myInitialStudent;

    /**
     * A student name.
     */
    private String myName = "InitTest";

    /**
     * Degree major.
     */
    private String myMajor = "CSS";

    /**
     * Academic term.
     */
    private String myTerm = "Spring";

    /**
     * Academic degree.
     */
    private String myDegree = "Bachelor of Science";

    /**
     * Degree Year.
     */
    private String myYear = "2016";

    /**
     * GPA.
     */
    private double myGPA = 3.5;

    /**
     * Student's email.
     */
    private String myEmail = "anon@test.com";

    /**
     * Set up the student.
     *
     * @throws Exception if error occur.
     */
    @Before
    public void setUp() throws Exception {
        Random rd = new Random();
        int number = rd.nextInt(999999);
        String sid = "" + number;
//		String sidStr = Integer.parseInt(sid);
        myInitialStudent = new Student(myName, sid, myMajor, myTerm, myDegree, myYear, myGPA, myEmail);
    }

    /**
     * Test search any column by any keywords, using major.
     */
    @Test
    public void testSearchByAny1() {
        List<Student> filteredStudent = StudentCollection.search(myMajor);

        boolean found = false;
        for (Student std : filteredStudent) {
            if (std.getMajor().equals(myMajor)) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    /**
     * Test 2, search any column by any keywords, using degree.
     */
    @Test
    public void testSearchByAny2() {
        List<Student> filteredStudent = StudentCollection.search(myDegree);

        boolean found = false;
        for (Student std : filteredStudent) {
            if (std.getDegree().equals(myDegree)) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    /**
     * Test for the addStudent method using random student ID so there will be no duplicates.
     */
    @Test
    public void testAddSuccess() {
        boolean successfullAdd = StudentCollection.addStudent(myInitialStudent);
        assertTrue(successfullAdd);
    }

    /**
     * Testing showing all student.
     */
    @Test
    public void testShowAll() {
        List<Student> studentList = StudentCollection.showAll();
        int result = studentList.size();
        assertNotEquals(0, result);
    }

    /**
     * Testing search by GPA.
     */
    @Test
    public void testSearchbyGPA() {
        List<Output> gpaOutput = StudentCollection.searchByGPA();
        int result = gpaOutput.size();
        assertNotEquals(0, result);
    }

    /**
     * Testing search by Salary.
     */
    @Test
    public void testSearchbySalary() {
        List<Output> salaryOutput = StudentCollection.searchBySalary();
        int result = salaryOutput.size();
        assertNotEquals(0, result);
    }

    /**
     * Testing update a student's email.
     */
    @Test
    public void testUpdateStudent() {
        myInitialStudent.setID("123456");
        Random rd = new Random();
        int number = rd.nextInt(999999);
        String email = number + "@uw.edu";
        boolean result = StudentCollection.updateStudent(myInitialStudent, "email", email);
        assertTrue(result);
    }

    /**
     * Testing search by Internship.
     */
    @Test
    public void testSearchbyInternship() {
        List<Output> internshipOutput = null;
        internshipOutput = StudentCollection.searchByInternship();
        int result = internshipOutput.size();
        assertNotEquals(0, result);
    }

    /**
     * Testing search by Job.
     */
    @Test
    public void testSearchByJob() {
        List<Output> jobOutput = null;
        jobOutput = StudentCollection.searchByJob();
        int result = jobOutput.size();
        assertNotEquals(0, result);
    }

    /**
     * Testing search by Major.
     */
    @Test
    public void testSearchByMajor() {
        List<Output> majorOutput = null;
        majorOutput = StudentCollection.searchByMajorOrDegree(myMajor);
        int result = majorOutput.size();
        assertNotEquals(0, result);
    }
}