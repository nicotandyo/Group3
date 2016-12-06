package gui;

import data.EmploymentDB;
import student.EmploymentData;
import student.Student;
import student.StudentCollection;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


/**
 * This class creates the GUI for Adding and Editing Student's Data
 *
 * @author Loc Bui
 * @author Yau Tsang
 */
public class StudentEmploymentGUI extends JPanel implements ActionListener,
        TableModelListener {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = -7520370128176444786L;

    /**
     * Employment database.
     */
    private static EmploymentDB myEmploymentDB;

    /**
     * All buttons that in the panel.
     */
    private JButton myBtnList, myBtnAdd, myBtnSearch, myAddBtn, mySearchBtn;

    /**
     * All panels.
     */
    private JPanel myPnlButtons, myPnlAdd, myPnlContent, myPnlSearch;

    /**
     * All labels.
     */
    private JLabel[] txfLabel = new JLabel[5];

    /**
     * All Textfields.
     */
    private JTextField[] txfField = new JTextField[5];

    /**
     * List of the Employments.
     */
    private List<EmploymentData> myList;

    /**
     * Put myList into a 2d Array,
     * and it will use in the myTable for displaying
     * the list of the Employments.
     */
    private Object[][] myData;

    /**
     * Table that list the information.
     */
    private JTable myTable;

    /**
     * Scrollpane for the table.
     */
    private JScrollPane myScrollPane;

    /**
     * Columns name of the Employment Table.
     */
    private String[] myEmploymentColumnNames = {"name", "sid", "company", "position",
            "description", "skillUsed", "salary", "startDay", "endDay", "type",};

    /**
     * Combo box that contains choices.
     */
    private JComboBox<String> myStudentComboBox, myTypeComboBox;

    /**
     * All students in array.
     */
    private String[] myStudentArrays;

    /**
     * Combo box for choosing Date.
     */
    private JComboBox<String> myMonthStartComboBox, myMonthEndComboBox;

    /**
     * Combo box for choosing Year.
     */
    private JComboBox<String> myYearStartComboBox, myYearEndComboBox;

    /**
     * Label fot title.
     */
    private JLabel mylblTitle;

    /**
     * Textfield for input.
     */
    private JTextField myTxfTitle;

    /**
     * This constructor calls the method to create all of the components
     */
    public StudentEmploymentGUI() {
        setLayout(new BorderLayout());
        if (myEmploymentDB == null) {
            myEmploymentDB = new EmploymentDB();
        }
        myList = getData(null);
        createComponents();
        setVisible(true);
    }

    /**
     * Returns the data 2d to use in the list as well as the search panels.
     *
     * @param theSearchKey the searching keyword.
     * @return a list of employment data.
     */
    private List<EmploymentData> getData(final String theSearchKey) {
        if (theSearchKey != null) {
            try {
                myList = myEmploymentDB.searchEmployments(theSearchKey);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                myList = myEmploymentDB.getEmployments();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (myList != null) {
            myData = new Object[myList.size()][myEmploymentColumnNames.length];
            for (int i = 0; i < myList.size(); i++) {
                myData[i][0] = myList.get(i).getMyStudentName();
                myData[i][1] = myList.get(i).getSID();
                myData[i][2] = myList.get(i).getCompany();
                myData[i][3] = myList.get(i).getPosition();
                myData[i][4] = myList.get(i).getDescription();
                myData[i][5] = myList.get(i).getSkill();
                myData[i][6] = myList.get(i).getSalary();
                myData[i][7] = myList.get(i).getStartDate();
                myData[i][8] = myList.get(i).getEndDate();
                myData[i][9] = myList.get(i).getMyType();
            }
        }
        return myList;
    }


    /**
     * Create the three panels to add to this GUI. One for list, one for search,
     * one for add.
     */
    private void createComponents() {
        // A button panel at the top for list, search, add
        myPnlContent = new JPanel();
        myPnlButtons = new JPanel();
        myBtnList = new JButton("Student Employment List");
        myBtnList.addActionListener(this);

        myBtnSearch = new JButton("Student Employment Search");
        myBtnSearch.addActionListener(this);

        myBtnAdd = new JButton("Add Student Employment");
        myBtnAdd.addActionListener(this);

        myPnlButtons.add(myBtnList);
        myPnlButtons.add(myBtnSearch);
        myPnlButtons.add(myBtnAdd);

        add(myPnlButtons, BorderLayout.NORTH);

        // instant focus on the employment data list
        myTable = new JTable(myData, myEmploymentColumnNames);
        myScrollPane = new JScrollPane(myTable);
        myScrollPane.setPreferredSize(new Dimension(StudentGUI.WIDTH, StudentGUI.HEIGHT));
        myPnlContent.add(myScrollPane);
        // Adding listener for updating or modifying the myTable.
        myTable.getModel().addTableModelListener(this);

        myPnlSearch = new JPanel();
        mylblTitle = new JLabel("Enter Search Key: ");
        myTxfTitle = new JTextField(25);
        mySearchBtn = new JButton("Search");
        mySearchBtn.addActionListener(this);
        myPnlSearch.add(mylblTitle);
        myPnlSearch.add(myTxfTitle);
        myPnlSearch.add(mySearchBtn);
        add(myPnlContent, BorderLayout.CENTER);
    }

    /**
     * Create the add student employment information panel.
     */
    public void addPanel() {
        // Add Panel
        myPnlAdd = new JPanel();
        myPnlAdd.setLayout(new GridLayout(10, 0));

        JPanel comboPanel1 = new JPanel();
        comboPanel1.setLayout(new GridLayout(1, 0));

        List<Student> studentList = StudentCollection.showAll();
        myStudentArrays = new String[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            myStudentArrays[i] = studentList.get(i).getName() + " - SID: " + studentList.get(i).getID();
        }

        myStudentComboBox = new JComboBox<>(myStudentArrays);
        comboPanel1.add(new JLabel("Choose a student: "));
        comboPanel1.add(myStudentComboBox);
        myPnlAdd.add(comboPanel1);

        String labelNames[] = {"Company: *", "Position: * ", "Description: ", "Skill Used: ",
                "Salary per year: * "};
        for (int i = 0; i < labelNames.length; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 0));
            txfLabel[i] = new JLabel(labelNames[i]);
            txfField[i] = new JTextField(25);
            panel.add(txfLabel[i]);
            panel.add(txfField[i]);
            myPnlAdd.add(panel);
        }

        JPanel comboPanel4 = new JPanel();
        comboPanel4.setLayout(new GridLayout(1, 2));
        String[] types = {"Job", "Internship"};
        myTypeComboBox = new JComboBox<>(types);
        myTypeComboBox.setSelectedIndex(0);
        comboPanel4.add(new JLabel("Type (Job or Intership): * "));
        comboPanel4.add(myTypeComboBox);
        myPnlAdd.add(comboPanel4);

        JPanel comboPanel2 = new JPanel();
        comboPanel2.setLayout(new GridLayout(1, 2));

        String[] months = {"01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12"};
        myMonthStartComboBox = new JComboBox<>(months);
        myMonthStartComboBox.setSelectedIndex(0);

        String[] years = {"2001", "2002", "2003", "2004", "2005",
                "2006", "2007", "2008", "2009", "2010", "2011", "2012",
                "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};

        myYearStartComboBox = new JComboBox<>(years);
        myYearStartComboBox.setSelectedIndex(0);
        comboPanel2.add(new JLabel("Start Day (Month - Year): * "));
        comboPanel2.add(myMonthStartComboBox);
        comboPanel2.add(myYearStartComboBox);
        myPnlAdd.add(comboPanel2);

        JPanel comboPanel3 = new JPanel();
        comboPanel3.setLayout(new GridLayout(1, 2));
        myMonthEndComboBox = new JComboBox<>(months);
        myMonthEndComboBox.setSelectedIndex(0);
        myYearEndComboBox = new JComboBox<>(years);
        myYearEndComboBox.setSelectedIndex(0);
        comboPanel3.add(new JLabel("End Day (Month - Year): * "));
        comboPanel3.add(myMonthEndComboBox);
        comboPanel3.add(myYearEndComboBox);
        myPnlAdd.add(comboPanel3);

        JPanel panel = new JPanel();
        myAddBtn = new JButton("Add");
        myAddBtn.addActionListener(this);
        JLabel label = new JLabel("(*) = Required Fields");
        panel.add(myAddBtn);
        panel.add(label);
        myPnlAdd.add(panel);
        myPnlContent.add(myPnlAdd);
    }

    /**
     * Make the buttons work!
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (theEvent.getSource() == myBtnAdd) {
            myPnlContent.removeAll();
            addPanel();
            myPnlContent.add(myPnlAdd);
            myPnlContent.revalidate();
            this.repaint();
        } else if (theEvent.getSource() == myAddBtn) {
            performAddStudent();
        } else if (theEvent.getSource() == myBtnList) {
            myList = getData(null);
            myPnlContent.removeAll();
            myTable = new JTable(myData, myEmploymentColumnNames);
            myTable.getModel().addTableModelListener(this);
            myScrollPane = new JScrollPane(myTable);
            myScrollPane.setPreferredSize(new Dimension(StudentGUI.WIDTH, StudentGUI.HEIGHT));
            myPnlContent.add(myScrollPane);
            myPnlContent.revalidate();
            this.repaint();
        } else if (theEvent.getSource() == myBtnSearch) {
            myPnlContent.removeAll();
            myPnlContent.add(myPnlSearch);
            myPnlContent.revalidate();
            this.repaint();
        } else if (theEvent.getSource() == mySearchBtn) {
            String title = myTxfTitle.getText();
            if (title.length() > 0) {
                myList = getData(title);
                myPnlContent.removeAll();
                myTable = new JTable(myData, myEmploymentColumnNames);
                myTable.getModel().addTableModelListener(this);
                myScrollPane = new JScrollPane(myTable);
                myScrollPane.setPreferredSize(new Dimension(StudentGUI.WIDTH, StudentGUI.HEIGHT));
                myPnlContent.add(myScrollPane);
                myPnlContent.revalidate();
                this.repaint();
                myTxfTitle.setText("");
            }
        }
    }

    /**
     * Perform adding a student's data.
     */
    private void performAddStudent() {
        String company = txfField[0].getText();
        if (company.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter Company Name");
            txfField[0].setFocusable(true);
            return;
        }

        String position = txfField[1].getText();
        if (position.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter Position");
            txfField[1].setFocusable(true);
            return;
        }

        String posDescription = txfField[2].getText();
        if (posDescription.length() == 0) {
            posDescription = "NOT PROVIDED";
        }

        String skillUsed = txfField[3].getText();
        if (skillUsed.length() == 0) {
            skillUsed = "NOT PROVIDED";
        }

        String salaryStr = txfField[4].getText();
        int salary = 0;

        if (salaryStr.length() != 0) {
            try {
                salary = Integer.parseInt(salaryStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter salary");
                txfField[2].setFocusable(true);
                return;
            }
        }

        String type = (String) myTypeComboBox.getSelectedItem();

        String startDay = myMonthStartComboBox.getSelectedItem() + "-" + myYearStartComboBox.getSelectedItem();
        String endDay = myMonthEndComboBox.getSelectedItem() + "-" + myYearEndComboBox.getSelectedItem();

        String name = (String) myStudentComboBox.getSelectedItem();

        if (name == null) {
            JOptionPane.showMessageDialog(null, "Unable to retrieve student names from the server!"
                            + "\nPlease add a student or check your internet connection and restart the program!",
                    "Failed Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int index = name.indexOf(":");
            String sid = name.substring(index + 2);

            //check for invalid start day and end day.
            int index2 = startDay.indexOf("-");
            int index1 = endDay.indexOf("-");
            int start = Integer.parseInt(startDay.substring(index2 + 1));
            int end = Integer.parseInt(endDay.substring(index1 + 1));
            int startMonth = Integer.parseInt(startDay.substring(0, index2));
            int endMonth = Integer.parseInt(endDay.substring(0, index1));
            if (start > end) {
                JOptionPane.showMessageDialog(null, "Invalid start day and end day",
                        "Add failed", JOptionPane.WARNING_MESSAGE);
            } else if (start == end && startMonth > endMonth) {
                JOptionPane.showMessageDialog(null, "Invalid start day and end day",
                        "Add failed", JOptionPane.WARNING_MESSAGE);
            } else {
                EmploymentData empData;

                empData = new EmploymentData(sid, company, position, posDescription, skillUsed,
                        salary, type, startDay, endDay);

                String message = "Student add failed";
                if (EmploymentDB.addEmployment(empData)) {
                    message = "Student added successfully";
                }
                JOptionPane.showMessageDialog(null, message);

                // Clear all text fields.
                for (int i = 0; i < txfField.length; i++) {
                    if (txfField[i].getText().length() != 0) {
                        txfField[i].setText("");
                    }
                }
            }
        }
    }

    /**
     * Listen to the cell changes on the myTable.
     */
    @Override
    public void tableChanged(final TableModelEvent theEvent) {
        int row = theEvent.getFirstRow();
        int column = theEvent.getColumn();
        TableModel model = (TableModel) theEvent.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        if (columnName.matches("name") ||
                columnName.matches("sid") ||
                columnName.matches("startDay") ||
                columnName.matches("endDay") ||
                columnName.matches("type")) {

            JOptionPane.showMessageDialog(null,
                    "Update failed, " + columnName + " CANNOT BE EDITED!!!");
        } else if (data != null && ((String) data).length() != 0) {
            EmploymentData employment = myList.get(row);
            if (!EmploymentDB.updateEmployment(employment, columnName, data)) {
                JOptionPane.showMessageDialog(null,
                        "Update failed, Please check your input!!!");
            }
        }
    }
}