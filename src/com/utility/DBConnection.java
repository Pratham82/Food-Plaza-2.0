package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection dbconnect = null;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            dbconnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza_pratham82", "root","root");
        }catch(Exception e){
            e.printStackTrace();
        }
        return dbconnect;
    }

}
