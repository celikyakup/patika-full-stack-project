import java.sql.*;

public class DBOperations {
    public static final String DB_URL="jdbc:mysql://localhost/university";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="mysql";
    public static void main(String[] args) {
        Connection connect=null;
        String sql="SELECT * FROM employees";
        try {
            connect= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement st= connect.createStatement();
            ResultSet data=st.executeQuery(sql);
            while (data.next()){
                System.out.print("ID: "+data.getInt("employe_id"));
                System.out.print("\tName: "+data.getString("employe_name"));
                System.out.print("\tPosition: "+data.getString("employe_position"));
                System.out.print("\tSalary: "+data.getInt("employe_salary"));
                System.out.println();
            }
            data.close();
            st.close();
            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}