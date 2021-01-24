package suanfa.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class a435 {
    class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }


        @Override
        public int compareTo(Interval i) {
            if (this.end!=i.end){
                return this.end<i.end?1:-1;
            }else if (this.start!=i.start){
                return  this.start<i.start?1:-1;
            }
            return 0;
        }
    }

    public static int solution(List<Interval> intervals) {
        if (intervals.size()==0){
            return 0;
        }
        Collections.sort(intervals);
        int pre=0;
        int res =0;
        for (int i=0;i<intervals.size();i++) {
            if (intervals.get(i).start>=intervals.get(pre).end){
                res++;
                pre= i;
            }
        }
        return intervals.size()-res;
    }

    public static void main(String[] args) {

    }
}
