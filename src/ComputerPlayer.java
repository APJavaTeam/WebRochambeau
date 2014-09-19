/**
 * Created by block7 on 9/18/14.
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer(){
        name = "Computer Player";
    }

    public String choose(){
        int myChoice = Rochambeau.randomInt(3);

        if(myChoice == 1){
            return "rock";
        }else if(myChoice == 2){
            return "scissors";
        }else if(myChoice == 3){
            return "paper";
        }else{
            return null;
        }

    }

}
