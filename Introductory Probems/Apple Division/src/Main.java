import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long[] weights;
    static long min = Long.MAX_VALUE;
    static long sum=0;
    static int count =0;

    public static void solve(int index, boolean take, long c){

        if(index== weights.length){
            return;
        }
        count++;
        if(take) {
            c += weights[index];
            min=Long.min(Math.abs(sum-c-c),min);
            solve(index+1,true,c);
            solve(index+1,false,c);
        }
        else {
            solve(index + 1, true, c);
            solve(index + 1, false, c);
        }
    }

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
        weights = new long[n];

        for (int i = 0; i < n; i++) {
            weights[i]=sc.nextLong();
            sum+=weights[i];
        }

        solve(0,true,0);
        solve(0,false,0);
        System.out.println(min);
        //System.out.println(count);
    }
}
