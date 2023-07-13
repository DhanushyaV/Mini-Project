package properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MedPropDao {
    public static void updateMedProperties(Connection con,BufferedReader br) throws IOException, SQLException {
        System.out.println("Enter the medicine name:");
        String medname = br.readLine();
        System.out.println("Enter the sideeffect(s)");
        String sideeff = br.readLine();
        System.out.println("Enter the benefit(s)");
        String benefits = br.readLine();
MedProp m = new MedProp();
m.setBenefits(benefits);
m.setSideEffects(sideeff);

        PreparedStatement st;
        String  query = "update medicines set benefits = '"+m.getBenefits()+"' , sideeffects = '"+m.getSideEffects()+"' where medicinename = '"+medname+"'";
        st  = con.prepareStatement(query);
        st.executeUpdate();
    }

    public static void getBenefitsSideeffects(Connection con,BufferedReader br) throws SQLException, IOException {
        System.out.print("Enter the medicine:");
        String medName = br.readLine();


        Statement st = con.createStatement();
        String query = "select benefits,sideeffects from medicines where medicinename='"+medName+"'";
        ResultSet rs = st.executeQuery(query);
        rs.next();

        String b = rs.getString("benefits");
        String s = rs.getString("sideeffects");

        System.out.println("medname: "+medName);
        System.out.println("Benefits: "+b);
        System.out.println("Sideeffects: "+s);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url="jdbc:mysql://localhost:3306/mysql";
        String uname="root";
        String pass="anirudh";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        //updateMedProperties(con,br);
        getBenefitsSideeffects(con,br);
    }
}
