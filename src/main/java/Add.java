import java.sql.*;
import java.util.Scanner;

public class Add {

    String url = "jdbc:mysql://localhost:3306/e_bank";
    String user = "McPj";
    String password = "dratan2874";
    Scanner scanner = new Scanner(System.in);
    int add;

    public Object into() {
        try {
            Connection connection  = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            Statement amountStatement = connection.createStatement();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            String client = "SELECT * FROM client WHERE password = ";
            String clientPassword = client + "'" + password + "'";
            ResultSet rs = statement.executeQuery(clientPassword);
            System.out.println("Amount to add");
            add = scanner.nextInt();
            if (add <= 0) {
                System.out.println("Not a valid expression\nTry again");
            }
                int added = amountStatement.executeUpdate("UPDATE client SET balance = balance +" + add);
                System.out.println(add + " was added to the balance");
                int balance = rs.getInt("balance");
                int currentBalance = (balance + add);
                System.out.println(currentBalance + " - current balance ");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println();
        }
        return "money added = " + add;
    }

}

