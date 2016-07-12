package sqlite;

import java.sql.*;

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:/home/oracle/stu.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Student;" );
      while ( rs.next() ) {
         int Gradeid = rs.getInt("Gradeid");
         String  studentID = rs.getString("studentID");
         String assignmentname=rs.getString("AssignmentNAME");
         String type=rs.getString("type");
         String gradedate=rs.getString("gradedate");
         float grade=rs.getFloat("grade");
       
         System.out.println( "gradeID = " + Gradeid );
         System.out.println( "Studentid = " + studentID );
         System.out.println( "assignmentname = " + assignmentname );
         System.out.println( "type = " + type );
         System.out.println( "gradedate = " + gradedate );
         System.out.println( "grade = " + grade );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
}