import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Client client = new Client();
		client.run();
	}
	public void run() throws UnknownHostException, IOException{
		System.out.println("Connecting...");
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Connected.\n");
		System.out.println("Server's turn...");
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		InputStreamReader in = new InputStreamReader(socket.getInputStream());
		Player p2 = new HumanPlayer("Client");
		
		int numGame = 3;
		
		while(true){
				
			BufferedReader buffer = new BufferedReader(in);
			String message = buffer.readLine();
			
			if(message.equals("choose")){
				String choice;
				choice = p2.choose();
				printStream.println(choice);
			}else{
				System.out.println(message);
				
				buffer = new BufferedReader(in);
				message = buffer.readLine();
				System.out.println(message);
				
				buffer = new BufferedReader(in);
				message = buffer.readLine();
				System.out.print(message);
				
				buffer = new BufferedReader(in);
				message = buffer.readLine();
				System.out.println(message);
				
				numGame--;
				
				if(numGame != 0){
					System.out.println("\nServer's turn...");
				}else{
					System.out.println();
				}
			}
			


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
