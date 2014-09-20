import java.io.*;
import java.net.*;

public class Server {
	public static final int PLAYER1_WINS = 1;
	public static final int PLAYER2_WINS = 2;
	public static final int TIE = 0;
	public static final int ERROR = -1;
    public static final int NUMBER_ROUNDS = 3;
    
    public static Player p1;
	public static Player p2;
	
	public static void main(String[] args) throws Exception{
		Server server = new Server();
		server.run();
	}
	public void run() throws Exception{
		
		p1 = new HumanPlayer("Server");
		p2 = new HumanPlayer("Client");
		
		ServerSocket serverSocket = new ServerSocket(7777);
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress() + " has connected.\n");
		InputStreamReader in = new InputStreamReader(socket.getInputStream());
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		while(true){
			for(int i = 0; i < 3; i++){
				String p1Choice, p2Choice;
				p1Choice = p1.choose();
				
				printStream.println("choose");
				
				BufferedReader buffer = new BufferedReader(in);
				String message = buffer.readLine();
				
				p2Choice = message;
				
				System.out.println(p1.name +  " chose: " + p1Choice);
				printStream.println(p1.name +  " chose: " + p1Choice);
				
	
				Thread.currentThread().sleep(500);
				
	            System.out.println(p2.name + " chose: " + p2Choice);
	           	printStream.println(p2.name + " chose: " + p2Choice);
	           	
	           	Thread.currentThread().sleep(500);
	            
	            int winner = findWinner(p1Choice, p2Choice);
	            
	            
	            printResults(i, winner, printStream);
	            System.out.println();
	            printStream.println();
	            System.out.println("\nClient's turn...");
			}
			System.out.println("Final score: ");
			printStream.println("Final Score: ");
			Thread.currentThread().sleep(500);
			System.out.println(p1.name + " scored " + String.valueOf(p1.score));
			printStream.println(p1.name + " scored " + String.valueOf(p1.score));
			Thread.currentThread().sleep(500);
			System.out.println(p2.name + " scored " + String.valueOf(p2.score));
			printStream.println(p2.name + " scored " + String.valueOf(p2.score));
			Thread.currentThread().sleep(500);
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
	public static void printResults(int roundNum, int winner, PrintStream prt) throws InterruptedException {
		System.out.print("Round " + roundNum + ": ");
		prt.print("Round " + roundNum + ": ");
		Thread.currentThread().sleep(300);
		if (winner == PLAYER1_WINS) {
			System.out.println(p1.name + " wins!");
			prt.println(p1.name + " wins!");
			p1.score = p1.score + 1;
		} else if (winner == PLAYER2_WINS) {
			System.out.println(p2.name + " wins!");
			prt.println(p2.name + " wins!");
			p2.score = p2.score + 1;
		} else if (winner == TIE) {
			System.out.println("It's a tie.");
			prt.println("It's a tie.");
		} else {
			System.out.println("Error!");
			prt.println("Error!");
		}
		Thread.currentThread().sleep(300);
	}
	public static int randomInt(int max) {
		return (int) (Math.random() * max + 1);
	}
	public static boolean isValid(String s) {
        String str = s.toLowerCase();
		return str.equals("rock") || str.equals("paper") || str.equals("scissors");
	}
	public static int findWinner(String p1Choice, String p2Choice) {
		if (! isValid(p1Choice) || ! isValid(p2Choice)) 
			return ERROR;
		if (p1Choice.equals(p2Choice)) {
			return TIE;
		} else if (p1Choice.equals("rock")) {
			return (p2Choice.equals("paper") ? PLAYER2_WINS : PLAYER1_WINS);
		} else if (p1Choice.equals("paper")) {
			return (p2Choice.equals("scissors") ? PLAYER2_WINS : PLAYER1_WINS);
		} else { // p1Choice == scissors
			return (p2Choice.equals("rock") ? PLAYER2_WINS : PLAYER1_WINS);
		}
	}
}
