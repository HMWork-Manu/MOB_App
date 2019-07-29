package com.example.mobile;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    Connection connection;
    public Connection con() {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String mysqlConnUrl = "jdbc:mysql://192.168.1.110:3306/abc";
            String mysqlUserName = "abcd";
            String mysqlPassword = "1234";
            connection = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);


        } catch (SQLException se) {
        } catch (ClassNotFoundException e) {
            Log.e("ERROR",e.getMessage());
        } catch (Exception e){
            Log.e("ERROR",e.getMessage());
        }

        return connection;
    }
}
