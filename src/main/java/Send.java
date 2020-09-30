import java.sql.*;
import java.util.Scanner;

public class Send {
    String url = "jdbc:mysql://localhost:3306/e_bank";
    String user = "McPj";
    String password = "dratan2874";
    Scanner scanner = new Scanner(System.in);
    int send;

    public Object to() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement something = connection.createStatement();
            Statement sender = connection.createStatement();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            System.out.println("Enter id");
            int id = scanner.nextInt();
            System.out.println("Enter a sum to send");
            send = scanner.nextInt();

                int sending = something.executeUpdate("UPDATE client SET balance = balance+" + send+" WHERE client_id = "+id);
                int sendingFrom = sender.executeUpdate( "UPDATE client SET balance = balance -"+send+" WHERE password = "+"'"+password+"'");
                System.out.println(send+" was sent");



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return send+" amount was sent ";
    }
}