package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable{
     private static Boolean tableExists = false;
        public void create(){

        //int result = 0;

            try {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
                Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");

                if(!tableExists) {
                    Statement stmt = con.createStatement();
                    Statement stmt1 = con.createStatement();
                    stmt.executeUpdate("CREATE TABLE IF NOT EXISTS  users (name varchar(30) , login varchar(30) , email  varchar(30), password varchar(30), isPremium bit , isAdmin bit )");
                    stmt1.executeUpdate("INSERT INTO users (name,login ,email,password,isPremium,isAdmin) VALUES ('admin','admin','admin@admin.pl','admin',true,true)");
                    tableExists = true;
                }
            }  catch (Exception e) {
                e.printStackTrace(System.out);
            }
            System.out.println("Table created successfully");
        }
    }


