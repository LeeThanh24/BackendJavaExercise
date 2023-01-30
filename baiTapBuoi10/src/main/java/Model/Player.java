package Model;

public class Player implements Comparable<Player>{
    private String name ;

    private int randNum;
    private int countTimes ;

    public Player(String name) {
        this.name = name;
        this.countTimes=0;
        int min = 1;
        int max = 1000;
        this.randNum= (int)(Math.random()*(max-min+1)+min);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getRandNum() {
        return randNum;
    }

    public void setRandNum(int randNum) {
        this.randNum = randNum;
    }

    public int getCountTimes() {
        return countTimes;
    }

    public void setCountTimes(int countTimes) {
        this.countTimes = countTimes;
    }

    @Override
    public int compareTo(Player e) {
        return this.getCountTimes()-e.getCountTimes();
    }
}
