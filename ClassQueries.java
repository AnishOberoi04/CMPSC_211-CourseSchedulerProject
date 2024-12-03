/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Anish Oberoi
 */
public class ClassQueries {
    private static Connection connection;
    private static PreparedStatement addClass;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getClassSeats;
    private static ResultSet resultSet;
    
    public static void addClass(ClassEntry entry)
    {
        connection = DBConnection.getConnection();
        
        try
        {
            addClass = connection.prepareStatement("insert into app.class (semester, coursecode, seats) values (?, ?, ?)");
            addClass.setString(1, entry.getSemester());
            addClass.setString(2, entry.getCourseCode());
            addClass.setInt(3, entry.getSeats());
            addClass.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getAllCourseCodes(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        
        try
        {
            getAllCourseCodes = connection.prepareStatement("select coursecode from app.class where semester = ?");
            getAllCourseCodes.setString(1, semester);
            resultSet = getAllCourseCodes.executeQuery();
            
            while(resultSet.next()) {
                courseCodes.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return courseCodes;
    }
    
    public static int getClassSeats(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        int seats = 0;
        
        try
        {
            getClassSeats = connection.prepareStatement("select seats from app.class where semester = ? and coursecode = ?");
            getClassSeats.setString(1, semester);
            getClassSeats.setString(2, courseCode);
            resultSet = getClassSeats.executeQuery();
            resultSet.next();
            seats = resultSet.getInt(1);
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return seats;
    }
}
