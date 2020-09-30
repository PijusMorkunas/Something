
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter frmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String time = localDateTime.format(frmt); //
    FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter("src\\main\\java\\Interactions.txt", true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    PrintWriter writer = new PrintWriter(fileWriter);

    public void sendToTxt(Object something){
        //fix only one gets sent
        writer.print(something);
        writer.println(" "+time);
        writer.close();

    }

}
