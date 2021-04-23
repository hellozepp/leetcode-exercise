package suanfa.playWithAlgorithmsData;

public class HanoiTower {
    public static void move(int topN ,char from ,char inner,char to){
        if (topN==1){
            System.out.println("plate"+topN+" from "+from+" to "+to+" tower.");
        }else {
            move(topN-1,from,to,inner);
            System.out.println("plate "+topN+" from "+from+" to "+to+" tower.");
            move(topN-1,inner,from,to);
        }
    }

    public static void main(String[] args) {
        move(3,'A','B','C');
    }
}
