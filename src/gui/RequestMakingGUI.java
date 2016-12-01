package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import request.Request;
import request.RequestCollection;

/**
 * This class creates the GUI for making a request to edit student's employment information.
 * @author Loc Bui
 *
 */
public class RequestMakingGUI extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1779520078061383929L;
	private JButton myBtnInstruction, myAddBtn;
	private JPanel myInfoPnl, myPnlContent, myInfoPanel;
	private JLabel[] myTxfLabel = new JLabel[2];
	private JTextField[] myTxfField = new JTextField[2];
	private JLabel myCommentLabel = new JLabel();
	private JLabel myInfoLabel;
	private JTextArea myTxfArea = new JTextArea();

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
		myInfoPnl.setLayout(new GridLayout(3, 0));
		String labelNames[] = { "Name (First Last):", "SID: "};
		for (int i = 0; i < labelNames.length; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0));
			myTxfLabel[i] = new JLabel(labelNames[i]);
			myTxfField[i] = new JTextField(25);
			panel.add(myTxfLabel[i]);
			panel.add(myTxfField[i]);
			myInfoPnl.add(panel);
		}

		
		JPanel myCommentPnl = new JPanel(new GridLayout(2, 0));
		JPanel commentPanel = new JPanel();
		commentPanel.setLayout(new GridLayout(1,0));
		myCommentLabel = new JLabel("Comment: ");
		myTxfArea = new JTextArea(10, 10);
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

		myInfoLabel = new JLabel(html1 + "400" + html2 + s);
		myInfoLabel.setFont(new Font("DialogInput", Font.BOLD, 17));
		myInfoPanel.add(myInfoLabel);
		myInfoPanel.setPreferredSize(new Dimension(500, 300));
		myCommentPnl.add(commentPanel);
		
		
		JPanel panel = new JPanel();
		myAddBtn = new JButton("Create Request");
		myAddBtn.addActionListener(this);
		panel.add(myAddBtn);
		panel.add(myBtnInstruction);
		myCommentPnl.add(panel);

		myPnlContent.add(myInfoPnl, BorderLayout.NORTH);
		myPnlContent.add(myCommentPnl, BorderLayout.CENTER);
		myPnlContent.add(myInfoPanel, BorderLayout.SOUTH);
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnInstruction) {
			JOptionPane.showMessageDialog(null, "Name: \nSID: \nCompany: "
					+ "\nPosition: \nDescription: \nSkill used: \nSalary: "
					+ "\nStart day: \nEnd day: \nType (Job or Internship): ", 
    				"Request Instruction" , JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == myAddBtn) {
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
		String content = myTxfArea.getText();
		if (content.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter the information you want to update");
			myTxfArea.setFocusable(true);
			return;
		}
		
		Request request = new Request(sid, name, content);
		
		String message = "Student add failed";
		if (RequestCollection.addRequest(request)) {
			message = "Student added successfully";
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
