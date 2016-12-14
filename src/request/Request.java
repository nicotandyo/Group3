package request;

/**
 * Request class represents a request with student's ID number and request string.
 * @author Nico Tandyo
 * @author Yau
 */
public class Request {

    /**
     * Student's ID number in string.
     */
    private String mySid;

    /**
     * Student's name.
     */
    private String myName;

    /**
     * A request for editing in String.
     */
    private String myContent;

    /**
     * A request ID.
     */
    private String myRequestId;

    /**
     * A company's name.
     */
    private String myCompany;

    /**
     * Starting date.
     */
    private String myStartDay;

    /**
     * Ending date.
     */
    private String myEndDay;

    /**
     * Data type, Job or Internship.
     */
    private String myType;

    /**
     * Working position.
     */
    private String myPosition;

    /**
     * Salary amount.
     */
    private int mySalary;


    /**
     * A constructor creating a new request.
     *
     * @param theSid      Student's ID.
     * @param theName     Student's name.
     * @param theCompany  Company's name.
     * @param thePosition Job position.
     * @param theStart    Starting date.
     * @param theEnd      Ending date.
     * @param theSalary   Salary amount.
     * @param theType     Job or Internship.
     * @param theContent  Content of comment.
     */
    public Request(final String theSid, final String theName, final String theCompany,
                   final String thePosition, final String theStart, final String theEnd,
                   final int theSalary, final String theType, final String theContent) {
        if (theSid == null) {
            throw new IllegalArgumentException("Please input your student ID number.");
        }
        this.mySid = theSid;
        this.myName = theName;
        this.myCompany = theCompany;
        this.myPosition = thePosition;
        this.myStartDay = theStart;
        this.myEndDay = theEnd;
        this.mySalary = theSalary;
        this.myType = theType;
        this.myContent = theContent;
    }

    /**
     * Gets the request student's id.
     *
     * @return A string of the student's id.
     */
    public String getMySid() {
        return mySid;
    }

    /**
     * Gets the student's name.
     *
     * @return A string of the student's name.
     */
    public String getMyName() {
        return myName;
    }

    /**
     * Gets the request's string.
     *
     * @return A string of the request.
     */
    public String getMyContent() {
        return myContent;
    }

    /**
     * Gets the request's ID.
     *
     * @return A string of the request ID.
     */
    public String getMyRequestId() {
        return myRequestId;
    }

    /**
     * Sets the request's ID.
     *
     * @param theRequestId A string containing the request's ID.
     */
    public void setMyRequestId(final String theRequestId) {
        this.myRequestId = theRequestId;
    }

    /**
     * Gets the company's name.
     *
     * @return name of the company.
     */
    public String getMyCompany() {
        return myCompany;
    }

    /**
     * Gets starting date.
     *
     * @return the starting date.
     */
    public String getMyStartDay() {
        return myStartDay;
    }

    /**
     * Gets ending date.
     *
     * @return the ending date.
     */
    public String getMyEndDay() {
        return myEndDay;
    }

    /**
     * Gets the working type.
     *
     * @return Job or internship for the type.
     */
    public String getMyType() {
        return myType;
    }

    /**
     * Gets the working position.
     *
     * @return the position.
     */
    public String getMyPosition() {
        return myPosition;
    }

    /**
     * Gets the salary amount.
     *
     * @return the amount.
     */
    public int getMySalary() {
        return mySalary;
    }
}
