import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //ArrayList<Integer> nums = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i]=(sc.nextInt());
        Arrays.sort(nums);
        long res = 1;
        for (int i = 0; i < n && nums[i]<=res; i++) {
            res+=nums[i];
        }
        System.out.println(res);
    }
}
