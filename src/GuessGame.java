package GuessGame;

/**
 * Created by Administrator on 2016/4/24 0024.
 */
public class GuessGame {

    public void startGame() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        int guessedNumberPlayer1 = 0;
        int guessedNumberPlayer2 = 0;
        int guessedNumberPlayer3 = 0;

        boolean player1IsRight = false;
        boolean player2IsRight = false;
        boolean player3IsRight = false;

        int targetNumber = (int)(Math.random() * 10);
        System.out.println("I am thinking a number between 0 and 9...");

        while (true) {
            System.out.println("Number to guess is " + targetNumber);
            player1.guessNumber();
            player2.guessNumber();
            player3.guessNumber();

            guessedNumberPlayer1 = player1.number;
            System.out.println("Player one guessed " + guessedNumberPlayer1);
            guessedNumberPlayer2 = player2.number;
            System.out.println("Player two guessed " + guessedNumberPlayer2);
            guessedNumberPlayer3 = player3.number;
            System.out.println("Player three guessed " + guessedNumberPlayer3);
            if (guessedNumberPlayer1 == targetNumber) {
                player1IsRight = true;
            } else if (guessedNumberPlayer2 == targetNumber) {
                player2IsRight = true;
            } else if (guessedNumberPlayer3 == targetNumber) {
                player3IsRight = true;
            } else {
                System.out.println("We have to try it again!");
            }
            if (player1IsRight || player2IsRight || player3IsRight){
            System.out.println("We have a winner!");
            System.out.println("Player one got right? " + player1IsRight);
            System.out.println("Player two got right? " + player2IsRight);
            System.out.println("Player three got right? " + player3IsRight);
            System.out.println("Game is over!");
            break;
            }
            else{
            System.out.println("Player have to try it again!\n");
            }
        }
    }
}
