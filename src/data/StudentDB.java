package data;

import student.Output;
import student.Student;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class contains methods to access the student tables data.
 *
 * @author Nico Tandyo
 * @author Yau Tsang
 * @author Loc Bui
 */
public class StudentDB {

    /**
     * Connection to the database.
     */
    private static Connection myConnection;
    /**
     * list of the second output.
     */
    private static List<Output> myAnotherOutputList;
    /**
     * List of student.
     */
    private List<Student> myStudentList;
    /**
     * List of output information.
     */
    private List<Output> myOutPutList;

    /**
     * Returns a output list that grouped by internship.
     *
     * @return a list that grouped by internship.
     * @throws SQLException if error occur.
     */
    public static List<Output> searchByInternship() throws SQLException {
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        String query = "Select Student.name, Student.sid, Student.gpa, Student.major, "
                + "Student.degree, Employment.salary, Employment.company, Employment.position,"
                + " Employment.type from Student Join Employment on Student.sid = Employment.sid"
                + " where Employment.type = 'Internship' order by Student.name asc;";
        myAnotherOutputList = new ArrayList<>();
        try {
            stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String sid = rs.getString("sid");
                double gpa = rs.getDouble("gpa");
                String major = rs.getString("major");
                String degree = rs.getString("degree");
                String company = rs.getString("company");
                String position = rs.getString("position");
                String type = rs.getString("type");
                int salary = rs.getInt("salary");
                Output output = null;
                output = new Output(name, sid, gpa, major, degree, salary, company, position, type);
                myAnotherOutputList.add(output);
            }
        } catch (SQLException e) {
//        	e.printStackTrace(); //For debugging.
            JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
                            + "\nPlease check your internet connection and restart the program!",
                    "Failed Warning", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return myAnotherOutputList;
    }

    /**
     * Returns an output list that grouped by job.
     *
     * @return a list are type of job.
     * @throws SQLException if error occur.
     */
    public static List<Output> searchByJob() throws SQLException {
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        String query = "Select Student.name, Student.sid, Student.gpa, Student.major, "
                + "Student.degree, Employment.salary, Employment.company, Employment.position,"
                + " Employment.type from Student Join Employment on Student.sid = Employment.sid"
                + " where Employment.type = 'Job' order by Student.name asc;";
        myAnotherOutputList = new ArrayList<>();
        try {
            stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String sid = rs.getString("sid");
                double gpa = rs.getDouble("gpa");
                String major = rs.getString("major");
                String degree = rs.getString("degree");
                String company = rs.getString("company");
                String position = rs.getString("position");
                String type = rs.getString("type");
                int salary = rs.getInt("salary");
                Output output = null;
                output = new Output(name, sid, gpa, major, degree, salary, company, position, type);
                myAnotherOutputList.add(output);
            }
        } catch (SQLException e) {
//        	e.printStackTrace(); //For debugging.!
            JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
                            + "\nPlease check your internet connection and restart the program!",
                    "Failed Warning", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return myAnotherOutputList;
    }

    /**
     * An output list that grouped by major or degree.
     *
     * @param theSearch the searching keyword.
     * @return a list that grouped by the keyword.
     * @throws SQLException if error occur.
     */
    public static List<Output> searchByMajorOrDegree(final String theSearch) throws SQLException {
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        String query = "Select Student.name, Student.sid, Student.gpa, Student.major, Student.degree,"
                + " Employment.salary, Employment.company, Employment.position, Employment.type "
                + "from Student Join Employment on Student.sid = Employment.sid order by Student.name asc;";

        myAnotherOutputList = new ArrayList<>();
        List<Output> filterList = new ArrayList<>();
        try {
            stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String sid = rs.getString("sid");
                double gpa = rs.getDouble("gpa");
                String major = rs.getString("major");
                String degree = rs.getString("degree");
                String company = rs.getString("company");
                String pos = rs.getString("position");
                String type = rs.getString("type");
                int salary = rs.getInt("salary");
                Output output = null;
                output = new Output(name, sid, gpa, major, degree, salary, company, pos, type);

                myAnotherOutputList.add(output);
            }
        } catch (SQLException e) {
//            e.printStackTrace(); //For debugging.
            JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
                            + "\nPlease check your internet connection and restart the program!",
                    "Failed Warning", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        //search by major
        for (Output out : myAnotherOutputList) {
            if (out.getMyStdMajor().equals(theSearch)) {
                filterList.add(out);
            }
        }
        //search by degree
        for (Output out : myAnotherOutputList) {
            if (out.getMyDegree().equals(theSearch)) {
                filterList.add(out);
            }
        }
        return filterList;
    }

    /**
     * Retrieves all students from the Student table.
     *
     * @return list of students.
     * @throws SQLException if error occur.
     */
    public List<Student> getStudents() throws SQLException {
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        String query = "select * " + "from Student ";

        myStudentList = new ArrayList<>();
        try {
            if (myConnection == null) {
                return null;
            }
            stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String sid = rs.getString("sid");
                String major = rs.getString("major");
                String term = rs.getString("gradTerm");
                String deg = rs.getString("degree");
                String year = rs.getString("year");
                double gpa = rs.getDouble("gpa");
                String email = rs.getString("email");
                Student student = null;
                student = new Student(name, sid, major, term, deg, year, gpa, email);
                myStudentList.add(student);
            }
        } catch (SQLException e) {
//            e.printStackTrace(); //For debugging.
            JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
                            + "\nPlease check your internet connection and restart the program!",
                    "Failed Warning", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return myStudentList;
    }

    /**
     * Returns all students that contain the search keyword in the name or description.
     *
     * @param theSearch search name.
     * @return list of student that match.
     * @throws SQLException if error occur.
     */
    public List<Student> getStudents(final String theSearch) throws SQLException {
        List<Student> filterList = new ArrayList<>();
        if (myStudentList == null) {
            getStudents();
        }
        String keyword = theSearch.toLowerCase();
        for (Student std : myStudentList) {
            if (std.getName().toLowerCase().contains(keyword) &&
                    !filterList.contains(std)) {
                filterList.add(std);
            }
        }
        for (Student std : myStudentList) {
            if (std.getID().toLowerCase().contains(keyword) &&
                    !filterList.contains(std)) {
                filterList.add(std);
            }
        }
        for (Student std : myStudentList) {
            if (std.getMajor().toLowerCase().contains(keyword) &&
                    !filterList.contains(std)) {
                filterList.add(std);
            }
        }
        for (Student std : myStudentList) {
            if (std.getTerm().toLowerCase().contains(keyword) &&
                    !filterList.contains(std)) {
                filterList.add(std);
            }
        }
        for (Student std : myStudentList) {
            if (std.getDegree().toLowerCase().contains(keyword) &&
                    !filterList.contains(std)) {
                filterList.add(std);
            }
        }
        for (Student std : myStudentList) {
            if (std.getYear().toLowerCase().contains(keyword) &&
                    !filterList.contains(std)) {
                filterList.add(std);
            }
        }
        for (Student std : myStudentList) {
            if (std.getEmail().toLowerCase().contains(keyword) &&
                    !filterList.contains(std)) {
                filterList.add(std);
            }
        }
        return filterList;
    }

    /**
     * It Gets output that sorted by GPA or Salary.
     *
     * @param theNumber 1 is GPA, 2 is Salary.
     * @return a output list.
     * @throws SQLException if error occur.
     */
    private List<Output> getOutputs(final int theNumber) throws SQLException {
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        String query = null;
        Statement stmt = null;
        if (theNumber == 1) {
            query = "Select Student.name, Student.sid, Student.gpa, Student.major, Student.degree,\n" +
                    "Employment.salary, Employment.company, Employment.position, Employment.type\n" +
                    "from Student Join Employment\n" +
                    "on Student.sid = Employment.sid\n" +
                    "order by Student.gpa desc, Student.name asc;";
        } else if (theNumber == 2) {
            query = "Select Student.name, Student.sid, Student.gpa, Student.major, Student.degree,\n" +
                    "Employment.salary, Employment.company, Employment.position, Employment.type\n" +
                    "from Student Join Employment\n" +
                    "on Student.sid = Employment.sid\n" +
                    "order by Employment.salary desc, Student.name asc;";
        }
        myOutPutList = new ArrayList<>();
        try {
            stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String sid = rs.getString("sid");
                double gpa = rs.getDouble("gpa");
                String major = rs.getString("major");
                String deg = rs.getString("degree");
                int salary = rs.getInt("salary");
                String company = rs.getString("company");
                String pos = rs.getString("position");
                String type = rs.getString("type");
                Output output = null;
                output = new Output(name, sid, gpa, major, deg, salary, company, pos, type);
                myOutPutList.add(output);
            }
        } catch (SQLException e) {
//            e.printStackTrace(); //For debugging.
            JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
                            + "\nPlease check your internet connection and restart the program!",
                    "Failed Warning", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return myOutPutList;
    }

    /**
     * Returns all students that contain the same GPA as the search keyword.
     *
     * @param theNumber 1 is GPA, 2 is Salary.
     * @return list of student that match.
     * @throws SQLException if error occur.
     */
    public List<Output> getOutput(final int theNumber) throws SQLException {
        getOutputs(theNumber);
        return myOutPutList;
    }

    /**
     * Adds a new student to the Student table.
     *
     * @param theStudent contains student information.
     * @return Returns "Added Student Successfully" or
     * "Error adding student: " with the sql exception.
     */
    public String addStudent(final Student theStudent) {
        String sql = "insert into Student(`name`,`sid`,`major`,`gradTerm`,"
                + "`degree`,`year`,`gpa`, `email`) values "
                + "(?, ?, ?, ?, ?, ?, ?, ?); ";

        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection.prepareStatement(sql);
            preparedStatement.setString(1, theStudent.getName());
            preparedStatement.setString(2, theStudent.getID());
            preparedStatement.setString(3, theStudent.getMajor());
            preparedStatement.setString(4, theStudent.getTerm());
            preparedStatement.setString(5, theStudent.getDegree());
            preparedStatement.setString(6, theStudent.getYear());
            preparedStatement.setDouble(7, theStudent.getGPA());
            preparedStatement.setString(8, theStudent.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//			e.printStackTrace(); //for debugging
            JOptionPane.showMessageDialog(null, "Student ID already exists!",
                    "Add failed", JOptionPane.WARNING_MESSAGE);
            return "Error adding student: " + e.getMessage();
        }
        return "Added Student Successfully";
    }

    /**
     * Modifies the data on a Student - only email can be changed
     *
     * @param theStudent contains student information that targeted.
     * @param theCol     the column that want to change.
     * @param theData    the new data want to change.
     * @return Returns a message with success or failure.
     */
    public String updateStudent(final Student theStudent,
                                final String theCol, final Object theData) {

        String sid = theStudent.getID();
        String sql = "update Student set `" + theCol
                + "` = ?  where sid= ?";
        // For debugging - System.out.println(sql);
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection.prepareStatement(sql);
            if (theData instanceof String)
                preparedStatement.setString(1, (String) theData);
            else if (theData instanceof Double)
                preparedStatement.setDouble(1, (Double) theData);
            preparedStatement.setString(2, sid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//			e.printStackTrace(); //for debugging
            return "Error updating student: " + e.getMessage();
        }
        return "Updated Student Successfully";

    }

}