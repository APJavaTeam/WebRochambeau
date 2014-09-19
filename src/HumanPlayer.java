/**
 * Created by block7 on 9/18/14.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(){
        name = Rochambeau.readLine("What is your name?: ");
    }

    public String choose(){
        String choice;
        do {
            choice = Rochambeau.readLine("Pick Either Rock, Paper, or Scissors: ");
        }while(! Rochambeau.isValid(choice));
        return choice.toLowerCase();
    }
}
