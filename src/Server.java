import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws Exception{
		Server server = new Server();
		server.run();
	}
	public void run() throws Exception{
		ServerSocket serverSocket = new ServerSocket(7777);
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress() + " has connected.\n");
		InputStreamReader in = new InputStreamReader(socket.getInputStream());
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		while(true){
			
			
			BufferedReader buffer = new BufferedReader(in);
			
			String message = buffer.readLine();
			System.out.println("Client says: " + message);
			

			
			printStream.println(readLine("What do you want to say?: "));
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
