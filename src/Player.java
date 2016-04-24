package GuessGame;

/**
 * Created by Administrator on 2016/4/24 0024.
 */
public class Player {
    int number;
    public void guessNumber(){
        number = (int)(Math.random() * 10);
        System.out.println("I am Guessing number is: " + number);
    }
}
