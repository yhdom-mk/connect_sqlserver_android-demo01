package com.example.connect_androidsql_demo01;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String username, pass, ip, port, database;
    @SuppressLint("NewApi")

    public Connection connectionclass() {
        ip ="172.1.1.0";
        database ="xxxxxxx";
        username ="sa";
        pass ="test";
        port ="8080";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection =null;
        String ConnectionURL =null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";"
                    + "databasename" + database + ";user=" + username + ";password:" + pass +";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex) {
            Log.e("Error:", ex.getMessage());
        }
        return  connection;
    }
}
