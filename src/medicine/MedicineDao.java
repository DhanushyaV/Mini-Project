package medicine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MedicineDao {
   public static void listAllMedicineNames(Connection con) throws SQLException {
       Statement st = con.createStatement();
       String query = "select * from medicines";
       ResultSet rs = st.executeQuery(query);
       while (rs.next()) {
           Integer id = rs.getInt("medicineid");
           String medname = rs.getString("medicinename");

           System.out.println("Id: "+id+"  "+"Name : "+medname);
       }
   }


    public static void addMedicine(Connection con, BufferedReader br) throws SQLException, IOException {
        System.out.println("Enter med id:");
       Integer id = Integer.parseInt(br.readLine());
       System.out.println("Enter med name:");
       String medname = br.readLine();
        System.out.println("Enter state:");
       String state = br.readLine();
        System.out.println("Enter quantity:");
        Integer quantity = Integer.parseInt(br.readLine());
        System.out.println("Enter cost:");
        Integer cost = Integer.parseInt(br.readLine());


        PreparedStatement stmt=con.prepareStatement("insert into medicines values(?,?,?,?,?,null,null,null,null,null,null,null,null)");
        stmt.setInt(1,id);//1 specifies the first parameter in the query
        stmt.setString(2,medname);
        stmt.setString(3,state);
        stmt.setInt(4,quantity);
        stmt.setInt(5,cost);

        int i=stmt.executeUpdate();
        System.out.println(i+" records inserted");

        //user can add medicine in database
    }

    public void deleteMedicine()
    {
        // user can delete medicine
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url="jdbc:mysql://localhost:3306/mysql";
        String uname="root";
        String pass="anirudh";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        listAllMedicineNames(con);
        addMedicine(con,br);

    }

}
