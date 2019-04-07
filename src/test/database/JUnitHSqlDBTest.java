package database;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitHSqlDBTest {

    @BeforeClass
    public static void init() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");

        // initialize database
        initDatabase();
    }


    @AfterClass
    public static void destroy() throws SQLException, ClassNotFoundException, IOException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
            statement.executeUpdate("DROP TABLE users");
            connection.commit();
        }
    }

    /**
     * Database initialization for testing i.e.
     * <ul>
     * <li>Creating Table</li>
     * <li>Inserting record</li>
     * </ul>
     *
     * @throws SQLException
     */
    private static void initDatabase() throws SQLException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
            statement.execute("CREATE TABLE users (name varchar(30) , login varchar(30) , email  varchar(30), password varchar(30), isPremium bit , isAdmin bit )");
            connection.commit();
            statement.executeUpdate("INSERT INTO users (name,login ,email,password,isPremium,isAdmin) VALUES ('admin','admin','admin@admin.pl','admin',true,true)");
            statement.executeUpdate("INSERT INTO users (name,login ,email,password,isPremium,isAdmin) VALUES ('user','user','user@admin.pl','user',false,false)");
            connection.commit();
        }
    }

    /**
     * Create a connection
     *
     * @return connection object
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:mem:employees", "SU", "");
    }

    /**
     * Get total records in table
     *
     * @return total number of records. In case of exception 0 is returned
     */
    private int getTotalRecords() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
            ResultSet result = statement.executeQuery("SELECT count(*) as total FROM users");
            if (result.next()) {
                return result.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Test
    public void getTotalRecordsTest() {
        assertThat(2, is(getTotalRecords()));
    }

    @Test
    public void checkNameExistsTest() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);) {

            ResultSet result = statement.executeQuery("SELECT name FROM users");

            if (result.first()) {
                assertThat("admin", is(result.getString("name")));
            }

            if (result.last()) {
                assertThat("user", is(result.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void shouldReturnConnectionToDb() throws Exception {

        ConnectDatabase connect = new ConnectDatabase();
        Connection con = connect.connect();
        Assert.assertNotNull(con);
        if (con != null) {
            con.close();
        }

    }
    
}