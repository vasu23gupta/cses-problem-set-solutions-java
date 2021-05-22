import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        //long sum = 0;
        long ans=0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            //sum+=nums[i];
        }

        //int avg = (int) (sum/n);
        Arrays.sort(nums);
        /*avg = Arrays.binarySearch(nums,avg);
        //System.out.println(avg);
        if(avg<0){
            avg*=-1;
            avg-=1;
        }*/
        for (int i = 0; i < n; i++) ans+=Math.abs(nums[i]-nums[(n/2)]);

        System.out.println(ans);
    }
}
