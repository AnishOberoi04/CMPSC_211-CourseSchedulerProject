/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Timestamp;
/**
 *
 * @author Anish Oberoi
 */
public class ScheduleEntry {
    private String semester;
    private String courseCode;
    private String studentID;
    private String status;
    private Timestamp ts;
    
    public ScheduleEntry(String semester, String courseCode, String studentID, String status, Timestamp ts) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.studentID = studentID;
        this.status = status;
        this.ts = ts;
    }
    
    public String getSemester() {
        return semester;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Timestamp getTimestamp() {
        return ts;
    }
}
