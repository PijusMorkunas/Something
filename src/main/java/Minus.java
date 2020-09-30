import java.sql.*;
import java.util.Scanner;

public class Minus {

    String url = "jdbc:mysql://localhost:3306/e_bank";
    String user = "McPj";
    String password = "dratan2874";
    Scanner scanner = new Scanner(System.in);
    int add;

    public Object take() {
        try {
            Connection takeConnection = takeConnection = DriverManager.getConnection(url, user, password);
            Statement statement = takeConnection.createStatement();
            Statement minusAmount = takeConnection.createStatement();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            String client = "SELECT * FROM client WHERE password = ";
            String minusPassowrd = client + "'" + password + "'";
            ResultSet rs = statement.executeQuery(minusPassowrd);
            System.out.println("Take out money");
            add = scanner.nextInt();
            if (add <= 0) {
                System.out.println("Not a valid expression");
            }
                int added = minusAmount.executeUpdate("UPDATE client SET balance = balance -" + add);
                System.out.println(add + " was taken from the balance");
                int balance = rs.getInt("balance");
                int  currentBalance = (balance - add);
                System.out.println(currentBalance + " - current balance");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println();
        }
        return "Was taken = " + add;

    }
}
