package manfucturer;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ManufactureDao {
    public static void displayDetails(Connection con) throws SQLException {
        Statement st = con.createStatement();
        String query = "select * from medicines";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Integer id = rs.getInt("medicineid");
            String medname = rs.getString("medicinename");
            Integer manid = rs.getInt("manufacturerid");
            String manname = rs.getString("manufacturername");
            String phoneno = rs.getString("phoneno");
            String address = rs.getString("address");

           Manufacturer m = new Manufacturer();
           m.setManId(id);
           m.setManname(manname);
           m.setAddress(address);
           m.setManNo(phoneno);
            System.out.println("Id: "+id+"  "+"Name : "+medname+"manufacture id:"+m.getManId()+" manufacture name:"+m.getManname()+" phone no:"+m.getManNo()+"Adddress:"+m.getAddress());
        }
    }
        public static void  addManufactureDetails(Connection con, BufferedReader br) throws IOException, SQLException {
            System.out.println("Enter medicine id:");
            Integer medid = Integer.parseInt(br.readLine());
            System.out.println("Enter manufacture id:");
            Integer id = Integer.parseInt(br.readLine());
            System.out.println("Enter manufacture name:");
            String manname = br.readLine();
            System.out.println("Enter address:");
            String address = br.readLine();
            System.out.println("Enter phone no:");
            String phoneno = br.readLine();
            System.out.println("Enter dosage:");
            Integer dose = Integer.parseInt(br.readLine());
            PreparedStatement st;
            String  query = "update medicines set manufacturername ='"+manname+"',address ='"+address+"',manufacturerid = "+id+",dosage ="+dose+",phoneno ='"+phoneno+"' where medicineid = "+medid;
            st  = con.prepareStatement(query);
            st.executeUpdate();


        }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String url="jdbc:mysql://localhost:3306/mysql";
        String uname="root";
        String pass="anirudh";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);

        //displayDetails(con);

        addManufactureDetails(con,new BufferedReader(new InputStreamReader(System.in)));
    }
}
