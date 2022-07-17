package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDBDemo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium_kumarswamy","root","V@shi0807");
        System.out.println("Connection is successful");
        Statement st =con.createStatement();
        ResultSet rs=st.executeQuery("select * from login_credentials");
        while(rs.next()){
            String applicationName=rs.getString(1);
            String userName=rs.getString(2);
            String password=rs.getString(3);
            System.out.println("ApplicationName is :"+applicationName+"\t"+"UserName is :"+userName+"\t"+"Password is :"+password);
        }
        con.close();
    }
}
