package CardWindows;

import java.sql.*;
import java.util.Date;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name[]=new String[8];
        Date date;
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
         Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println(000);
            String url="jdbc:mysql://localhost:3306/caoliduo?serverTimezone=UTC";
            con= DriverManager.getConnection(url,"root","cao894871274");

            System.out.println(con);
            st=con.createStatement();
            //rs=st.executeQuery("insert employ (id,name,sex,age,payment) values(2,'duoduo','女',18,20000)");
            st.executeUpdate("insert employ (id,name,sex,age,payment) values(2,'duoduo','女',18,20000)");
            System.out.println("------------------------------------------------------------------------");
            /*while(rs.next()){
                for(int i=0;i<8;i++){
                    name[i]=rs.getString(i+1);
                    System.out.println("------------------------------------------------");
                    System.out.println("     "+name[0]+"    "+name[1]+"       "+name[2]+"       "+name[3]+"        "+name[4]
                    +"      "+name[5]+"      "+name[6]+"    "+name[7]);
                }
            }
*/
           // System.out.println("88888");

    }
}
