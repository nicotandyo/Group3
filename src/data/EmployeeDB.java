package data;

import gui.HomeGUI;
import gui.MainGUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class contains methods to access Employee table.
 * Created by Yau Tsang on 11/27/2016.
 */
public class EmployeeDB {

    /**
     * It's a connection for connecting to the database.
     */
    private Connection myConnection;


    /**
     * It login to the system by given Employee information.
     *
     * @param theUser An Employee login username.
     * @param thePass Am Employee login password
     * @param theRole if 1, it's employee. If 2, it's student.
     * @return A string message that telling user success or not.
     */
    public String login(final String theUser, final String thePass,
                        final int theRole) throws SQLException {
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        try {
            if (theRole == 1 && theUser != null && thePass != null) {
                String sql = "Select * from Login where username ='" +
                        theUser + "' and password='" + thePass + "'";
                if (myConnection == null) {
                    return null;
                }
                stmt = myConnection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    //in this case enter when at least one result comes it means user is valid
                    int role = rs.getInt("role");
                    HomeGUI home = new HomeGUI();
                    if (role == 1) {
                        home.advisorPermission();
                        JOptionPane.showMessageDialog(null, "You are logged in as an Advisor",
                                "Login success", JOptionPane.INFORMATION_MESSAGE);
                        return "Sucess";
                    } else if (role == 2) {
                        home.adminPermission();
                        JOptionPane.showMessageDialog(null, "You are logged in as an Administrative Staff",
                                "Login success", JOptionPane.INFORMATION_MESSAGE);
                        return "Sucess";
                    } else {
                        home.facultyPermission();
                        JOptionPane.showMessageDialog(null, "You are logged in as a Faculty",
                                "Login success", JOptionPane.INFORMATION_MESSAGE);
                        return "Sucess";
                    }
                } else {
                    //in this case enter when  result size is zero  it means user is invalid
                    JOptionPane.showMessageDialog(null, "Invalid username or password",
                            "Login failed", JOptionPane.INFORMATION_MESSAGE);
                    new MainGUI();
                    return null;
                }
            } else if (theRole == 2) {
                if (myConnection == null) {
                    return null;
                }
                HomeGUI home = new HomeGUI();
                home.studentPermission();
                JOptionPane.showMessageDialog(null, "You are logged in as a Student",
                        "Login success", JOptionPane.INFORMATION_MESSAGE);
                return "Sucess";
            }
            // You can also validate user by result size if its comes zero user is invalid else user is valid

        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
                            + "\nPlease check your internet connection and restart the program!",
                    "Failed Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
}
