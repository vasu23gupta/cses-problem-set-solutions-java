import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //PriorityQueue<Long> tops = new PriorityQueue<>();
        ArrayList<Long> tops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long c = sc.nextLong();
            int ind = Collections.binarySearch(tops, c+1);
            if(ind>=0) {
                tops.set(ind, c);
                //System.out.println('i');
            }
            else{
                ind *=-1;
                ind--;
                if(ind== tops.size())tops.add(c);
                else tops.set(ind,c);
                //System.out.println('e');
            }
        }
        System.out.println(tops.size());
    }
}
