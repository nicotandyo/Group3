package gui;

import student.Output;
import student.StudentCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

/**
 * This class creates the GUI for generating outputs
 * based on the criterion that the user has chosen to view by.
 *
 * @author Loc Bui
 * @author Yau Tsang
 * @author Nico Tandyo
 */
public class OutputGUI extends JPanel implements ActionListener {

    /**
     * 1 for GPA.
     */
    public static final int GPA = 1;

    /**
     * 2 for Salary.
     */
    public static final int SALARY = 2;

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 7655286335054538989L;

    /**
     * 3 for Internship.
     */
    private static final int INTERNSHIP = 3;

    /**
     * 4 for Job.
     */
    private static final int JOB = 4;

    /**
     * Button for generating output.
     */
    private JButton myBtnView;

    /**
     * Combo box that contains different choice.
     */
    private JComboBox<String> myComboBox;

    /**
     * Main panel and combo boc panel.
     */
    private JPanel myComboBoxPnl, myPnlContent;

    /**
     * List of the output.
     */
    private List<Output> myList;

    /**
     * Combo boc choices.
     */
    private String[] myComboBoxValues = {"GPA", "Salary", "Major - CSS", "Major - CES", "Major - IT",
            "Degree - BA", "Degree - BS", "Degree - MS", "Internship", "Job"};

    /**
     * Name of the columns.
     */
    private String[] myColumnNames = {"name", "sid", "gpa",
            "major", "degree", "salary", "company", "position", "type"};

    /**
     * Data for making the table.
     */
    private Object[][] myData;

    /**
     * JTable for the table represent of the output.
     */
    private JTable myTable;

    /**
     * Scrollpane for the table.
     */
    private JScrollPane myScrollPane;

    /**
     * The constructor to call the method to create all of the components
     *
     * @throws SQLException if error occur.
     */
    public OutputGUI() throws SQLException {
        setLayout(new BorderLayout());
        createComponents();
        setVisible(true);
    }

    /**
     * Get the output data.
     *
     * @param theNumber is the selection
     * @return a list of output
     * @throws SQLException if error occur.
     */
    private List<Output> getData(final int theNumber) throws SQLException {
        if (theNumber == 1) {
            myList = StudentCollection.searchByGPA();
            myData = new Object[myList.size()][myColumnNames.length];
        } else if (theNumber == 2) {
            myList = StudentCollection.searchBySalary();
            myData = new Object[myList.size()][myColumnNames.length];
        } else if (theNumber == 3) {
            myList = StudentCollection.searchByInternship();
            myData = new Object[myList.size()][myColumnNames.length];
        } else if (theNumber == 4) {
            myList = StudentCollection.searchByJob();
            myData = new Object[myList.size()][myColumnNames.length];
        }
        if (myList != null) {
            for (int i = 0; i < myList.size(); i++) {
                myData[i][0] = myList.get(i).getMyStdName();
                myData[i][1] = myList.get(i).getMyStdID();
                myData[i][2] = myList.get(i).getMyGPA();
                myData[i][3] = myList.get(i).getMyStdMajor();
                myData[i][4] = myList.get(i).getMyDegree();
                myData[i][5] = myList.get(i).getMySalary();
                myData[i][6] = myList.get(i).getMyCompany();
                myData[i][7] = myList.get(i).getMyPosition();
                myData[i][8] = myList.get(i).getMyType();
            }
        }
        return myList;
    }

    /**
     * Get a list of output with desired major.
     *
     * @param theSearch that's searching keyword.
     * @return a list of Output with desired major
     * @throws SQLException if error occur.
     */
    public List<Output> getMajorOrDegree(final String theSearch) throws SQLException {
        myList = StudentCollection.searchByMajorOrDegree(theSearch);

        if (myList != null) {
            myData = new Object[myList.size()][myColumnNames.length];
            for (int i = 0; i < myList.size(); i++) {
                myData[i][0] = myList.get(i).getMyStdName();
                myData[i][1] = myList.get(i).getMyStdID();
                myData[i][2] = myList.get(i).getMyGPA();
                myData[i][3] = myList.get(i).getMyStdMajor();
                myData[i][4] = myList.get(i).getMyDegree();
                myData[i][5] = myList.get(i).getMySalary();
                myData[i][6] = myList.get(i).getMyCompany();
                myData[i][7] = myList.get(i).getMyPosition();
                myData[i][8] = myList.get(i).getMyType();
            }
        }
        return myList;
    }

    /**
     * This method creates the panel for generating outputs.
     */
    private void createComponents() {
        myPnlContent = new JPanel();
        myComboBoxPnl = new JPanel();
        JLabel label = new JLabel("Select a criterion to view by: ");
        myComboBoxPnl.add(label);
        myComboBox = new JComboBox<>();
        for (int i = 0; i < myComboBoxValues.length; i++) {
            myComboBox.addItem(myComboBoxValues[i]);
        }
        myComboBoxPnl.add(myComboBox);
        myBtnView = new JButton("View");
        myBtnView.addActionListener(this);
        myComboBoxPnl.add(myBtnView);
        add(myComboBoxPnl, BorderLayout.NORTH);
        add(myPnlContent, BorderLayout.CENTER);
    }

    /**
     * Changing table.
     */
    public void changeTable() {
        myPnlContent.removeAll();
        myTable = new JTable(myData, myColumnNames);
        myScrollPane = new JScrollPane(myTable);
        myScrollPane.setPreferredSize(new Dimension(StudentGUI.WIDTH, StudentGUI.HEIGHT));
        myPnlContent.add(myScrollPane);
        myPnlContent.revalidate();
        myPnlContent.setVisible(true);
        this.repaint();
    }

    /**
     * Print this message when our system is unable to find the student�s information that match the criteria.
     */
    public void printMessage() {
        JOptionPane.showMessageDialog(null, "Unable to retrieve student's information from the input!"
                        + "\nPlease select a different criterion to view by.",
                null, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Perform an action based on the event.
     *
     * @param theEvent is the event
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (theEvent.getSource() == myBtnView) {
            if (myComboBox.getSelectedItem().equals("GPA")) {
                try {
                    myList = getData(GPA);
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Salary")) {
                try {
                    myList = getData(SALARY);
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Internship")) {
                try {
                    myList = getData(INTERNSHIP);
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Job")) {
                try {
                    myList = getData(JOB);
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Major - CSS")) {
                try {
                    myList = getMajorOrDegree("CSS");
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Major - CES")) {
                try {
                    myList = getMajorOrDegree("CES");
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Major - IT")) {
                try {
                    myList = getMajorOrDegree("IT");
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Degree - BA")) {
                try {
                    myList = getMajorOrDegree("Bachelor of Arts");
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Degree - BS")) {
                try {
                    myList = getMajorOrDegree("Bachelor of Science");
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Degree - MS")) {
                try {
                    myList = getMajorOrDegree("Master of Science");
                    if (myList.size() == 0) {
                        printMessage();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                changeTable();
            }
        }
    }
}