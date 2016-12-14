package student;

/**
 * Output class represent the output with student name, student id, GPA, major, degree,
 * salary, company, position, and the type of employment.
 * @author Yau
 * @author Nico Tandyo
 */
public class Output {

    /**
     * Student's name.
     */
    private String myStdName;

    /**
     * Student ID.
     */
    private String myStdID;

    /**
     * GPA.
     */
    private double myGPA;

    /**
     * Student's major.
     */
    private String myStdMajor;

    /**
     * Student's degree.
     */
    private String myDegree;

    /**
     * Salary amount.
     */
    private int mySalary;

    /**
     * Company's name.
     */
    private String myCompany;

    /**
     * working position.
     */
    private String myPosition;

    /**
     * Employment type, job or internship.
     */
    private String myType;

    /**
     * The constructor of the Output class.
     *
     * @param theStdName  student name.
     * @param theStdID    student ID.
     * @param theGPA      GPA.
     * @param theStdMajor student's major.
     * @param theDegree   degree.
     * @param theSalary   amount.
     * @param theCompany  company name.
     * @param thePosition working position.
     * @param theType     employment type.
     */
    public Output(final String theStdName, final String theStdID, final double theGPA,
                  final String theStdMajor, final String theDegree, final int theSalary,
                  final String theCompany, final String thePosition, final String theType) {
        this.myStdName = theStdName;
        this.myStdID = theStdID;
        this.myGPA = theGPA;
        this.myStdMajor = theStdMajor;
        this.myDegree = theDegree;
        this.mySalary = theSalary;
        this.myCompany = theCompany;
        this.myPosition = thePosition;
        this.myType = theType;
    }

    /**
     * Get the student name.
     *
     * @return the student name
     */
    public String getMyStdName() {
        return myStdName;
    }

    /**
     * Get the student ID.
     *
     * @return the student ID
     */
    public String getMyStdID() {
        return myStdID;
    }

    /**
     * Get the GPA.
     *
     * @return GPA
     */
    public double getMyGPA() {
        return myGPA;
    }

    /**
     * Get the student major.
     *
     * @return major
     */
    public String getMyStdMajor() {
        return myStdMajor;
    }

    /**
     * Get the student degree.
     *
     * @return degree
     */
    public String getMyDegree() {
        return myDegree;
    }

    /**
     * Get the student salary.
     *
     * @return salary
     */
    public int getMySalary() {
        return mySalary;
    }

    /**
     * Get the company.
     *
     * @return company
     */
    public String getMyCompany() {
        return myCompany;
    }

    /**
     * Get the position.
     *
     * @return position
     */
    public String getMyPosition() {
        return myPosition;
    }

    /**
     * Get the employment type.
     *
     * @return employment
     */
    public String getMyType() {
        return myType;
    }
}
