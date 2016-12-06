package student;


/**
 * Student class represent a student with name, student id,
 * major, term, degree, year, GPA, email, and a list of employment.
 *
 * @author Nico Tandyo
 * @author Yau
 */
public class Student {

    /**
     * Student's name.
     */
    private String myStdName;

    /**
     * Student ID.
     */
    private String myStdID;

    /**
     * Student major.
     */
    private String myStdMajor;

    /**
     * Term of the degree.
     */
    private String myGradTerm;

    /**
     * Academic Degree.
     */
    private String myDegree;

    /**
     * Degree year.
     */
    private String myYear;

    /**
     * GPA.
     */
    private double myGPA;

    /**
     * Student's email.
     */
    private String myEmail;

    /**
     * Constructor for the student.
     *
     * @param theName   Student's name.
     * @param theID     Student ID.
     * @param theMajor  Major.
     * @param theTerm   of degree.
     * @param theDegree Academic degree.
     * @param theYear   degree year.
     * @param theGPA    GPA.
     * @param theEmail  Student's email.
     */
    public Student(final String theName, final String theID, final String theMajor,
                   final String theTerm, final String theDegree, final String theYear,
                   final double theGPA, final String theEmail) {
        myStdName = theName;
        myStdID = theID;
        myStdMajor = theMajor;
        myGradTerm = theTerm;
        myDegree = theDegree;
        myYear = theYear;
        myGPA = theGPA;
        myEmail = theEmail;
    }

    /**
     * Get the student's name.
     *
     * @return the student's name
     */
    public String getName() {
        return myStdName;
    }

    /**
     * Set the student's name.
     *
     * @param theName of the student.
     */
    public void setName(final String theName) {
        myStdName = theName;
    }

    /**
     * Get the student's ID.
     *
     * @return the student's ID
     */
    public String getID() {
        return myStdID;
    }

    /**
     * Set the student's ID.
     *
     * @param theID of the student.
     */
    public void setID(final String theID) {
        myStdID = theID;
    }

    /**
     * Get the student's major.
     *
     * @return the student's major
     */
    public String getMajor() {
        return myStdMajor;
    }

    /**
     * Set the student's major.
     *
     * @param theMajor of the student.
     */
    public void setMajor(final String theMajor) {
        myStdMajor = theMajor;
    }

    /**
     * Get the student's graduation term.
     *
     * @return the student's graduation term
     */
    public String getTerm() {
        return myGradTerm;
    }

    /**
     * Get the student's degree.
     *
     * @return the student's degree
     */
    public String getDegree() {
        return myDegree;
    }

    /**
     * Get the student's year.
     *
     * @return the student's year
     */
    public String getYear() {
        return myYear;
    }

    /**
     * Get the student's GPA.
     *
     * @return the student's GPA
     */
    public double getGPA() {
        return myGPA;
    }

    /**
     * Get the student's email.
     *
     * @return the student's email
     */
    public String getEmail() {
        return myEmail;
    }

    /**
     * Set the student's email.
     *
     * @param theEmail of the student.
     */
    public void setEmail(final String theEmail) {
        myEmail = theEmail;
    }

}