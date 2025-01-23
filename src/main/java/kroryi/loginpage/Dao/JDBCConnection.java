package kroryi.loginpage.Dao;

import java.sql.*;

public class JDBCConnection {
    public Connection con;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public JDBCConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/member?useSSL=false&useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "1333";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
