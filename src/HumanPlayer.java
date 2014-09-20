/**
 * Created by block7 on 9/18/14.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String s){
        name = s;
    }

    public String choose(){
        String choice;
        do {
            choice = Server.readLine("Pick Either Rock, Paper, or Scissors: ");
        }while(! Server.isValid(choice));
        return choice.toLowerCase();
    }
}
