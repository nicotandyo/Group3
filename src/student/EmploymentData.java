package student;

import javax.swing.*;

/**
 * EmploymentData class represent the employment data with the company name, position, description,
 * skill used, start date, end date, and if it is an intern or a job.
 *
 * @author Nico Tandyo
 * @author Yau Tsang
 */
public class EmploymentData {

    /**
     * Student ID.
     */
    private String mySID;

    /**
     * Company's name.
     */
    private String myCompany;

    /**
     * Working position.
     */
    private String myPosition;

    /**
     * Position description.
     */
    private String myPosDescription;

    /**
     * Skill used for the job or internship.
     */
    private String mySkillUsed;

    /**
     * Salary amount.
     */
    private int mySalary;

    /**
     * Starting date.
     */
    private String myStartDate;

    /**
     * Ending date.
     */
    private String myEndDate;

    /**
     * Working myType, Job or internship.
     */
    private String myType;

    /**
     * Student's name that belong to the employment
     */
    private String myStudentName;

    /**
     * The unique number "Primary key" of the Employment table,
     * it auto generate and increments by 1 when a new employment
     * added into the table.
     */
    private String myEmploymentId;

    /**
     * Constructor for the EmploymentData.
     *
     * @param theCompany  name.
     * @param thePosition of the job or internship.
     * @param theDescr    description of the position.
     * @param theSkill    skill used for position.
     * @param theSalary   amount.
     * @param theStart    starting date.
     * @param theEnd      ending date.
     */
    public EmploymentData(final String theSID, final String theCompany, final String thePosition,
                          final String theDescr, final String theSkill, final int theSalary,
                          final String theType, final String theStart, final String theEnd) {
        if (theSID == null) {
            JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
                            + "\nPlease check your internet connection and restart the program!",
                    "Login failed", JOptionPane.WARNING_MESSAGE);
        }
        mySID = theSID;
        myCompany = theCompany;
        myPosition = thePosition;
        myPosDescription = theDescr;
        mySkillUsed = theSkill;
        mySalary = theSalary;
        myType = theType;
        myStartDate = theStart;
        myEndDate = theEnd;
    }


    /**
     * Gets SID.
     *
     * @return the SID.
     */
    public String getSID() {
        return mySID;
    }

    /**
     * Gets company name.
     *
     * @return the company name.
     */
    public String getCompany() {
        return myCompany;
    }

    /**
     * Sets company name.
     *
     * @param theCompany name.
     */
    public void setCompany(final String theCompany) {
        myCompany = theCompany;
    }

    /**
     * Gets position.
     *
     * @return the position.
     */
    public String getPosition() {
        return myPosition;
    }

    /**
     * Sets position.
     *
     * @param thePosition of the job or internship.
     */
    public void setPosition(final String thePosition) {
        myPosition = thePosition;
    }

    /**
     * Gets position description.
     *
     * @return the description.
     */
    public String getDescription() {
        return myPosDescription;
    }

    /**
     * Sets position description.
     *
     * @param theDesc of the position.
     */
    public void setDescription(final String theDesc) {
        myPosDescription = theDesc;
    }

    /**
     * Gets the skill used.
     *
     * @return the skill used.
     */
    public String getSkill() {
        return mySkillUsed;
    }

    /**
     * Sets skill used.
     *
     * @param theSkill for working.
     */
    public void setSkill(final String theSkill) {
        mySkillUsed = theSkill;
    }

    /**
     * Gets the salary.
     *
     * @return the salary amount.
     */
    public int getSalary() {
        return mySalary;
    }

    /**
     * Sets salary.
     *
     * @param theSalary amount.
     */
    public void setSalary(final int theSalary) {
        mySalary = theSalary;
    }

    /**
     * Checks if the employment is an internship.
     *
     * @return true if intern, false otherwise
     */
    public String getMyType() {
        return myType;
    }

    /**
     * Sets true if is intern, false otherwise.
     *
     * @param theType of Job or Internship.
     */
    public void setMyType(final String theType) {
        myType = theType;
    }

    /**
     * Gets the employment start date.
     *
     * @return the starting date.
     */
    public String getStartDate() {
        return myStartDate;
    }

    /**
     * Gets the employment end date.
     *
     * @return the end date.
     */
    public String getEndDate() {
        return myEndDate;
    }

    /**
     * Gets the student's name.
     *
     * @return the student's name that belong to this employment.
     */
    public String getMyStudentName() {
        return myStudentName;
    }

    /**
     * Sets the student's name.
     *
     * @param theStudentName the student's name that belong to this employment.
     */
    public void setMyStudentName(final String theStudentName) {
        this.myStudentName = theStudentName;
    }

    /**
     * Gets the Unique ID "Primary key" of the Employment
     *
     * @return the employment id.
     */
    public String getMyEmploymentId() {
        return myEmploymentId;
    }

    /**
     * Sets the Unique ID "Primary key" to the employment.
     *
     * @param theEmploymentId the number of the employment id.
     */
    public void setMyEmploymentId(final String theEmploymentId) {
        this.myEmploymentId = theEmploymentId;
    }
}