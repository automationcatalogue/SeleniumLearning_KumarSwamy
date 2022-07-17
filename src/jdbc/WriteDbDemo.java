package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class WriteDbDemo {
    public static void main(String[] args) throws Exception{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium_kumarswamy","root","V@shi0807");
        Scanner sc = new Scanner(System.in);

        boolean moreData=true;
        while(moreData){

            System.out.println("Please enter the application name");
            String appName=sc.next();

            System.out.println("Please enter the username");
            String un=sc.next();

            System.out.println("Please enter the Password");
            String pwd=sc.next();

            Statement st=con.createStatement();
            int rowcount=st.executeUpdate("insert into login_credentials values ('"+appName+"','"+un+"','"+pwd+"')");
            System.out.println("Number of rows are effected is :"+rowcount);

            System.out.println("Do you want to enter moredata");
            moreData=sc.nextBoolean();

        }
        con.close();


    }
}
