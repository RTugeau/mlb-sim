import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Team {
    private String name;
    private int wins;
    private int losses;
    private int streak;
    private int rating;
    public boolean firstPlace;
    public boolean wildCard;
    private int seed;

    public Team(String name, int wins, int losses, int rating, int streak, int seed) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.rating = rating;
        this.streak = streak;
        this.firstPlace = true;
        this.wildCard = false;
        this.seed = seed;
    }

    public String getName() {
        return this.name;
    }

    public int getWins() {
        return this.wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getRating() {
        return this.rating;
    }

    public int getStreak() {
        return this.streak;
    }

    public int getSeed() {
        return this.seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public void game(Team t1, Team t2) {
        Random rng = new Random();
        int aNum = 0;
        int hNum = 0;
        int pAway = t1.rating;
        int pHome = t2.rating;

        while(aNum == hNum) {
            aNum = 0;
            hNum = 0;
            int away = rng.nextInt(100) + 1;
            int home = rng.nextInt(100) + 1;
            if (away <= pAway) {
                aNum = 1;
            }

            if (home <= pHome) {
                hNum = 1;
            }
        }
        if (hNum >= aNum) {

            System.out.println("The " + t2.getName() + " beat the " + t1.getName() + ".");
            t2.wins++;
            if (t2.streak >= 0) {
                t2.streak++;
            } else {
                t2.streak = 1;
            }

            t1.losses++;
            if (t1.streak >= 0) {
                t1.streak = -1;
            } else {
                t1.streak--;
            }
        } else {

            System.out.println("The " + t1.getName() + " beat the " + t2.getName() + ".");
            t1.wins++;
            if (t1.streak >= 0) {
                t1.streak++;
            } else {
                t1.streak = 1;
            }

            t2.losses++;
            if (t2.streak >= 0) {
                t2.streak = -1;
            } else {
                t2.streak--;
            }
        }
    }
}
