package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    public Connection connect() {
        Connection con = null;

        try {
            //Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println("HSQLDB JDBCDriver Loaded");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
            if (con!= null){
                System.out.println("Connection created successfully");


            }else{
                System.out.println("Problem with creating connection");
            }

        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return con;
    }
}