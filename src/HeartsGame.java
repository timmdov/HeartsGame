import java.util.*;

public class HeartsGame {
    private List<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private List<Card> currentTrick;
    private boolean heartsBroken;
    private boolean shootingTheMoon;

    public HeartsGame(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.currentPlayer = null;
        this.currentTrick = new ArrayList<>();
        this.heartsBroken = false;
        this.shootingTheMoon = false;
    }

    public void initializeGame() {
        deck.shuffle();
        for (Player player : players) {
            for (int i = 0; i < 13; i++) {
                player.addCard(deck.dealCard());
            }
        }
    }

    public void playRound() {
        for (int i = 0; i < 13; i++) {
            playTrick();
        }
    }

    private void playTrick() {
        currentTrick.clear();
        for (Player player : players) {
            Card card = player.playCard();
            currentTrick.add(card);
        }
        determineTrickWinner();
    }

    private void determineTrickWinner() {
        int highestRank = currentTrick.get(0).getRank().getValue();
        Player winner = players.get(0);
        for (int i = 1; i < currentTrick.size(); i++) {
            int rank = currentTrick.get(i).getRank().getValue();
            if (rank > highestRank) {
                highestRank = rank;
                winner = players.get(i);
            }
        }

        System.out.println(winner.getName() + " wins the trick!");
    }
}
