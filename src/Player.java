
// Player -- this class provides a simple interface for different Rochambeau
public class Player {
	int score = 0;
	String name = "DEFAULT PLAYER";	
	
	Player() {}   // shouldn't create just a Player; have to create a ComputerPlayer or HumanPlayer

	// choose -- subclasses of Player override this to provide a polymorphic method of selecting
	// whether a Player chooses rock, paper, or scissors
	public String choose() {return "";}
}
