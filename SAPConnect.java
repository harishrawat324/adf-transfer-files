import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SAPConnect {

    public static void main(String[] args) {
        // ---- Connection details ----
        String host = "c46948bf-2e25-49e5-921f-fcf8a90bcbcb.hana.prod-us20.hanacloud.ondemand.com";
        String port = "443";
        String user = "OUTBOUND#DB_OUTBOUND_FDP";
        String password = "0,8Wj6F^A`D_!1z!-^arCL1O[H!;)Bo^";

        // ---- JDBC URL ----
        String url = "jdbc:sap://" + host + ":" + port + "/?encrypt=true&validateCertificate=false&sslTrustStore=NONE";

        try {
            // Load the SAP HANA JDBC driver from ngdbc.jar
            Class.forName("com.sap.db.jdbc.Driver");

            System.out.println("Connecting to SAP Datasphere...");
            Connection conn = DriverManager.getConnection(url, user, password);

            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection successful!");
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver not found! Make sure ngdbc.jar is in the classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
