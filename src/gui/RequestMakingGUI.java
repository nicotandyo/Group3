package gui;

import request.Request;
import request.RequestCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates the GUI for making a request to edit student's employment information.
 *
 * @author Loc Bui
 * @author Yau Tsang
 */
public class RequestMakingGUI extends JPanel implements ActionListener {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 1779520078061383929L;

    /**
     * Instruction button and add button.
     */
    private JButton myBtnInstruction, myAddBtn;

    /**
     * Main panel, information panel.
     */
    private JPanel myInfoPnl, myPnlContent, myInfoPanel;

    /**
     * Textfield's labels.
     */
    private JLabel[] myTxfLabel = new JLabel[5];

    /**
     * Text input fields.
     */
    private JTextField[] myTxfField = new JTextField[5];

    /**
     * Comment's label.
     */
    private JLabel myCommentLabel = new JLabel();

    /**
     * Information label.
     */
    private JLabel myInfoLabel;

    /**
     * Text area.
     */
    private JTextArea myTxfArea = new JTextArea();

    /**
     * Combo box for choosing date.
     */
    private JComboBox<String> myMonthStartComboBox, myMonthEndComboBox, myTypeComboBox;

    /**
     * Combo box for choosing year.
     */
    private JComboBox<String> myYearStartComboBox, myYearEndComboBox;

    /**
     * This constructor calls the method to create all of the components.
     */
    public RequestMakingGUI() {
        setLayout(new BorderLayout());
        createComponents();
        setVisible(true);
    }

    /**
     * Create the three panels to add to this GUI. One for making a request,
     * one for the instruction for making a request
     */
    private void createComponents() {
        myPnlContent = new JPanel();
        myPnlContent.setLayout(new BorderLayout());

        myBtnInstruction = new JButton("Information Needed For Making A Request");
        myBtnInstruction.addActionListener(this);

        addPanel();
        add(myPnlContent, BorderLayout.CENTER);
    }

    /**
     * Create the add panel for making a request.
     */
    public void addPanel() {
        // Add Panel
        myInfoPnl = new JPanel();
        myInfoPnl.setLayout(new GridLayout(9, 0));
        String labelNames[] = {"Name (First Last): *", "SID: *", "Company: *", "Position: *", "Salary: *"};
        for (int i = 0; i < labelNames.length; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 0));
            myTxfLabel[i] = new JLabel(labelNames[i]);
            myTxfField[i] = new JTextField(25);
            panel.add(myTxfLabel[i]);
            panel.add(myTxfField[i]);
            myInfoPnl.add(panel);
        }


        JPanel myCommentPnl = new JPanel(new GridLayout(3, 0));
        JPanel commentPanel = new JPanel();
        commentPanel.setLayout(new GridLayout(1, 0));
        myCommentLabel = new JLabel("Comment(Optional):");
        int rows = 9, columns = 10;
        myTxfArea = new JTextArea(rows, columns);
        myTxfArea.setLineWrap(true);
        myTxfArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(myTxfArea);
        commentPanel.add(myCommentLabel);
        commentPanel.add(scroll);

        myInfoPanel = new JPanel();
        String s = "Note: If you think you are not in the system yet, "
                + "please make an appointment with your advisor in order for them "
                + "to add your student information such as: name, sid, major... to "
                + "the system so you can make a request to update your employment information. Thank you.";

        //this is for wrapping the text in the JLabel
        String html1 = "<html><body style='width: ";
        String html2 = "px'>";

        int width = 500, height = 175, size = 17;
        myInfoLabel = new JLabel(html1 + "400" + html2 + s);
        myInfoLabel.setFont(new Font("DialogInput", Font.BOLD, size));
        myInfoPanel.add(myInfoLabel);
        myInfoPanel.setPreferredSize(new Dimension(width, height));
        myCommentPnl.add(commentPanel);


        JPanel panel = new JPanel();
        myAddBtn = new JButton("Create Request");
        myAddBtn.addActionListener(this);
        panel.add(myAddBtn);
        panel.add(myBtnInstruction);
        myCommentPnl.add(panel);

        JPanel comboPanel4 = new JPanel();
        comboPanel4.setLayout(new GridLayout(1, 2));
        String[] types = {"Job", "Internship"};
        myTypeComboBox = new JComboBox<>(types);
        myTypeComboBox.setSelectedIndex(0);
        comboPanel4.add(new JLabel("Type (Job or Intership): * "));
        comboPanel4.add(myTypeComboBox);
        myInfoPnl.add(comboPanel4);

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
        myInfoPnl.add(comboPanel2);

        JPanel comboPanel3 = new JPanel();
        comboPanel3.setLayout(new GridLayout(1, 2));
        myMonthEndComboBox = new JComboBox<>(months);
        myMonthEndComboBox.setSelectedIndex(0);
        myYearEndComboBox = new JComboBox<>(years);
        myYearEndComboBox.setSelectedIndex(0);
        comboPanel3.add(new JLabel("End Day (Month - Year): * "));
        comboPanel3.add(myMonthEndComboBox);
        comboPanel3.add(myYearEndComboBox);
        myInfoPnl.add(comboPanel3);

        myPnlContent.add(myInfoPanel, BorderLayout.NORTH);
        myPnlContent.add(myInfoPnl, BorderLayout.CENTER);
        myPnlContent.add(myCommentPnl, BorderLayout.SOUTH);
    }

    /**
     * Make the buttons work!
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (theEvent.getSource() == myBtnInstruction) {
            JOptionPane.showMessageDialog(null, "We would love to know about your position"
                            + " description and the skills used.\nIf you have time, please tell us"
                            + " about those information in the comment section.\nThank you.",
                    "Request Instruction", JOptionPane.INFORMATION_MESSAGE);
        } else if (theEvent.getSource() == myAddBtn) {
            performAddRequest();
        }
    }

    /**
     * Perform adding the request to the database.
     */
    public void performAddRequest() {
        String name = myTxfField[0].getText();
        if (name.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter Student Name (First Last)");
            myTxfField[0].setFocusable(true);
            return;
        }
        String sid = myTxfField[1].getText();
        if (sid.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter SID");
            myTxfField[1].setFocusable(true);
            return;
        }
        String company = myTxfField[2].getText();
        if (company.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter Company");
            myTxfField[2].setFocusable(true);
            return;
        }

        String position = myTxfField[3].getText();
        if (position.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter Position");
            myTxfField[3].setFocusable(true);
            return;
        }

        String salaryStr = myTxfField[4].getText();
        int salary = 0;

        if (salaryStr.length() != 0) {
            try {
                salary = Integer.parseInt(salaryStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter salary an integer");
                myTxfField[4].setFocusable(true);
                return;
            }
        }

        String content = myTxfArea.getText();
        if (content.length() == 0) {
            content = "NOT PROVIDED";
        }

        String type = (String) myTypeComboBox.getSelectedItem();

        String startDay = myMonthStartComboBox.getSelectedItem() + "-" + myYearStartComboBox.getSelectedItem();
        String endDay = myMonthEndComboBox.getSelectedItem() + "-" + myYearEndComboBox.getSelectedItem();

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
            Request request = new Request(sid, name, company, position, startDay, endDay, salary, type, content);

            String message = "Request add failed";
            if (RequestCollection.addRequest(request)) {
                message = "Request added successfully";
            }
            JOptionPane.showMessageDialog(null, message);

            if (myTxfArea.getText().length() != 0) {
                myTxfArea.setText("");
            }

            for (int i = 0; i < myTxfField.length; i++) {
                if (myTxfField[i].getText().length() != 0) {
                    myTxfField[i].setText("");
                }
            }
        }
    }
}
