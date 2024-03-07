import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player1"));
        players.add(new Player("Player2"));
        players.add(new Player("Player3"));
        players.add(new Player("Player4"));

        HeartsGame heartsGame = new HeartsGame(players);
        heartsGame.initializeGame();
        heartsGame.playRound();
    }
}
