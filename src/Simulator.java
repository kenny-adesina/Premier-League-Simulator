import static java.lang.System.out;

public class Simulator {
    public static void main(String[] args){
       TeamHelper match =  new TeamHelper();
       match.selectTeam();
       out.print(match.startMatch());
    }
}
