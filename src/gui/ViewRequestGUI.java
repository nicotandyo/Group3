package gui;

import request.Request;
import request.RequestCollection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * This class creates the GUI for viewing all of the student requests
 * and delete the request after updating the student's employment information of that request.
 *
 * @author Loc Bui
 * @author Yau Tsang
 * @author Nico Tandyo
 */
public class ViewRequestGUI extends JPanel implements ActionListener {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = -8173105788916568140L;

    /**
     * View and delete button.
     */
    private JButton myBtnView, myBtnDelete;

    /**
     * Button panel.
     */
    private JPanel myBtnPanel;

    /**
     * List of the Request.
     */
    private List<Request> myList;

    /**
     * Data that for making the table.
     */
    private Object[][] myData;

    /**
     * Column's name.
     */
    private Object[] mItemColumnNames = {"SID: ", "Name", "Company", "Position", "Salary",
            "StartDay", "EndDay", "Type", "Comment", "RequestID"};

    /**
     * Content of the panel.
     */
    private Container myPnlContent;

    /**
     * TableModel that make a list into a table.
     */
    private TableModel myTableModel;

    /**
     * Table that represent the data.
     */
    private JTable myTable;

    /**
     * Scroll pane that used in the table.
     */
    private JScrollPane myScrollPane;

    /**
     * The constructor to call the method to create all of the components
     */
    public ViewRequestGUI() {
        setLayout(new BorderLayout());
        myList = getData();
        createComponents();
        setVisible(true);
    }

    /***
     * Gets data for making myData.
     * @return a list that contains requests.
     */
    public List<Request> getData() {
        myList = RequestCollection.showTheList();

        if (myList != null) {
            myData = new Object[myList.size()][mItemColumnNames.length];
            for (int i = 0; i < myList.size(); i++) {
                myData[i][0] = myList.get(i).getMySid();
                myData[i][1] = myList.get(i).getMyName();
                myData[i][2] = myList.get(i).getMyCompany();
                myData[i][3] = myList.get(i).getMyPosition();
                myData[i][4] = myList.get(i).getMySalary();
                myData[i][5] = myList.get(i).getMyStartDay();
                myData[i][6] = myList.get(i).getMyEndDay();
                myData[i][7] = myList.get(i).getMyType();
                myData[i][8] = myList.get(i).getMyContent();
                myData[i][9] = myList.get(i).getMyRequestId();
            }
        }
        return myList;
    }

    /**
     * This method creates the panel for viewing all of the request
     * and delete button for deleting request after updating.
     */
    private void createComponents() {
        myPnlContent = new JPanel();
        myBtnView = new JButton("View all request");
        myBtnView.addActionListener(this);
        myBtnDelete = new JButton("Delete request");
        myBtnDelete.setEnabled(false);
        myBtnDelete.addActionListener(this);

        createListPanel();

        myBtnPanel = new JPanel();
        myBtnPanel.add(myBtnView);
        myBtnPanel.add(myBtnDelete);
        add(myBtnPanel, BorderLayout.NORTH);
        add(myPnlContent, BorderLayout.CENTER);
    }

    /**
     * Making a list panel.
     */
    public void createListPanel() {
        myList = getData();
        if (myList.size() == 0) {
            myBtnDelete.setEnabled(false);
        } else {
            myBtnDelete.setEnabled(true);
        }
        myTableModel = new DefaultTableModel(myData, mItemColumnNames);
        myTable = new JTable(myTableModel);
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int commentColumnWidth = 372;
        int columnWidth = 100;
        myTable.getColumnModel().getColumn(8).setPreferredWidth(commentColumnWidth);
        myTable.getColumnModel().getColumn(2).setPreferredWidth(columnWidth);
        myTable.getColumnModel().getColumn(3).setPreferredWidth(columnWidth);
        myScrollPane = new JScrollPane(myTable);
        myScrollPane.setPreferredSize(new Dimension(StudentGUI.WIDTH, StudentGUI.HEIGHT));
        myPnlContent.add(myScrollPane);
    }

    /**
     * Make the buttons work!
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (theEvent.getSource() == myBtnView) {
            myList = getData();
            if (myList.size() == 0) {
                myBtnDelete.setEnabled(false);
            } else {
                myBtnDelete.setEnabled(true);
            }
            myPnlContent.removeAll();
            createListPanel();
            myPnlContent.revalidate();
            myPnlContent.setVisible(true);
            this.repaint();
        } else if (theEvent.getSource() == myBtnDelete) {
            myList = getData();
            if (myList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Nothing to delete!",
                        null, JOptionPane.INFORMATION_MESSAGE);
                myBtnDelete.setEnabled(false);
            } else {
                myBtnDelete.setEnabled(true);
                int viewIndex = myTable.getSelectedRow();
                if (viewIndex != -1) {
                    int changableColumn = 9;
                    int modelIndex = myTable.convertRowIndexToModel(viewIndex);
                    DefaultTableModel model = (DefaultTableModel) myTable.getModel();
                    model.removeRow(modelIndex);
                    String id = (String) myData[viewIndex][changableColumn];
                    RequestCollection.removeRequest(id);
                }
            }
        }
    }
}
