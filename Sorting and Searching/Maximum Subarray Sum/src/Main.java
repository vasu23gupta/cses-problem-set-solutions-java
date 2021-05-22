import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums =  new int[n];
        long curr = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            nums[i]=x;
            curr+=x;
            max = Math.max(max,curr);
            if (curr<0) curr=0;
        }
        if (max==0) max= Arrays.stream(nums).max().getAsInt();
        System.out.println(max);
    }
}
