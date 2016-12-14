package gui;

import javax.swing.*;
import java.sql.SQLException;

/**
 * The GUI for Home with features for user to use
 * based on their permission of access.
 *
 * @author Loc Bui
 * @author Yau Tsang
 * @author Nico Tandyo
 */
public class HomeGUI {

    /**
     * Width of Home GUI.
     */
    public static final int WIDTH = 1200;

    /**
     * Height of Home GUI.
     */
    public static final int HEIGHT = 700;

    /**
     * JFrame of the GUI
     */
    private static JFrame myFrame;

    /**
     * Tab Pane for the GUI.
     */
    private JTabbedPane myTabbedPane;

    /**
     * This constructors calls the method to create the GUI.
     *
     * @throws SQLException if error occur.
     */
    public HomeGUI() throws SQLException {
        myFrame = new JFrame("Home");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        myFrame.setSize(WIDTH, HEIGHT);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    /**
     * This method is used for closing the GUI.
     */
    public static void close() {
        myFrame.dispose();
    }

    /**
     * This method creates several tabs for different features for user to use.
     *
     * @throws SQLException if error occur.
     */
    private void createComponents() throws SQLException {
        myTabbedPane = new JTabbedPane();
        JComponent addDataPanel = makeTextPanel("Add or Update Student's Data");
        myTabbedPane.addTab("Add or Update Student's Data", addDataPanel);
        JComponent addEmploymentPanel = makeTextPanel("Add or Update Student's Employment Information");
        myTabbedPane.addTab("Add or Update Student's Employment Information", addEmploymentPanel);
        JComponent genePanel = makeTextPanel("Generates Outputs");
        myTabbedPane.addTab("Generates Outputs", genePanel);
        JComponent requestPanel = makeTextPanel("Request to Edit Student's Data");
        myTabbedPane.addTab("Request to Edit Student's Data", requestPanel);
        JComponent requestViewPanel = makeTextPanel("View Students' Request");
        myTabbedPane.addTab("View Student Request", requestViewPanel);
        JComponent logOutPanel = makeTextPanel("Log Out");
        myTabbedPane.addTab("Log out", logOutPanel);
        myFrame.add(myTabbedPane);
    }

    /**
     * Create the the particular part to add to the tab based on the type.
     *
     * @param theType the tab's type.
     * @return the panel.
     * @throws SQLException if error occur.
     */
    private JComponent makeTextPanel(final String theType) throws SQLException {
        JPanel panel = new JPanel();
        if (theType.equalsIgnoreCase("Add or Update Student's Data")) {
            panel.add(new StudentGUI());
        } else if (theType.equalsIgnoreCase("Generates Outputs")) {
            panel.add(new OutputGUI());
        } else if (theType.equalsIgnoreCase("Request to Edit Student's Data")) {
            panel.add(new RequestMakingGUI());
        } else if (theType.equalsIgnoreCase("View Students' Request")) {
            panel.add(new ViewRequestGUI());
        } else if (theType.equalsIgnoreCase("Add or Update Student's Employment Information")) {
            panel.add(new StudentEmploymentGUI());
        } else if (theType.equalsIgnoreCase("Log Out")) {
            panel.add(new LogoutGUI());
        }
        return panel;
    }

    /**
     * This method restricts the permission for user as a student.
     */
    public void studentPermission() {
        myTabbedPane.setSelectedIndex(3);
        myTabbedPane.setEnabledAt(0, false);
        myTabbedPane.setEnabledAt(1, false);
        myTabbedPane.setEnabledAt(2, false);
        myTabbedPane.setEnabledAt(4, false);
    }

    /**
     * This method restricts the permission for user as an advisor.
     */
    public void advisorPermission() {
        myTabbedPane.setSelectedIndex(0);
        myTabbedPane.setEnabledAt(2, false);
        myTabbedPane.setEnabledAt(3, false);
    }

    /**
     * This method restricts the permission for user as a faculty.
     */
    public void facultyPermission() {
        myTabbedPane.setSelectedIndex(2);
        myTabbedPane.setEnabledAt(0, false);
        myTabbedPane.setEnabledAt(1, false);
        myTabbedPane.setEnabledAt(3, false);
        myTabbedPane.setEnabledAt(4, false);
    }

    /**
     * This method restricts the permission for user as an administrative staff.
     */
    public void adminPermission() {
        myTabbedPane.setSelectedIndex(0);
        myTabbedPane.setEnabledAt(3, false);
    }
}