import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Client client = new Client();
		client.run();
	}
	public void run() throws UnknownHostException, IOException{
		Socket socket = new Socket("localhost", 7777);
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		InputStreamReader in = new InputStreamReader(socket.getInputStream());
		while(true){
				
			printStream.println(readLine("What do you want to say?: "));
			
			
			BufferedReader buffer = new BufferedReader(in);
			
			String message = buffer.readLine();
			System.out.println("Server says: " + message);
		}
		
	}
	public static String readLine(String prompt) {
        String line = null;
        Console c = System.console();
        if (c != null) {
             line = c.readLine(prompt);
        } else {
            System.out.print(prompt);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                 line = bufferedReader.readLine();
            } catch (IOException e) { 
                //Ignore    
            }
        }
        return line;
	}
}
