package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class UserDao {


    public static void checkMedicine(Connection con,BufferedReader br) throws IOException, SQLException {
        System.out.print("Enter the medicine:");
        String medName = br.readLine();
        Statement st = con.createStatement();
        String query = "select medicinename from medicines";
        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            String medNamedb = rs.getString("medicinename");
            if(medNamedb.equals(medName)) {
                System.out.println("Entered medicine is Available");
                return;
            }

        }
        System.out.println("Entered medicine is not Available");
        //  user can check the medicine present or not;
    }
    public static void checkDosage(Connection con,BufferedReader br) throws IOException, SQLException {
        System.out.print("Enter the medicine:");
        String medName = br.readLine();
        System.out.println("Enter the dosage priscribed:");
        Integer dose = Integer.parseInt(br.readLine());

        Statement st = con.createStatement();
        String query = "select dosage from medicines where medicinename='"+medName+"'";
        ResultSet rs = st.executeQuery(query);
        rs.next();

         Integer dosedb = rs.getInt("dosage");

         if(dosedb==dose)
             System.out.println("Entered dosage mathes with the correct dosage");
         else
             System.out.println("NO!! please confirm about the dosage with doctor the correct dosage for "+medName+" is "+dosedb);


    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url="jdbc:mysql://localhost:3306/mysql";
        String uname="root";
        String pass="anirudh";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        //checkDosage(con,br);
        checkMedicine(con,br);
    }
}
