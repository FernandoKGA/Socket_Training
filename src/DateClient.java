import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient{
    public static void main(String[] args){
        try{
            while(true){
                Socket sock = new Socket("127.0.0.1",6013);

                InputStream in = sock.getInputStream();
                BufferedReader bin = new BufferedReader(new InputStreamReader(in));

                String line;
                while( (line = bin.readLine()) != null) {
                    System.out.println(line);
                }
                sock.close();
                Thread.sleep(1000);
            }
        }
        catch (IOException ioe){
            System.out.println(ioe);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}