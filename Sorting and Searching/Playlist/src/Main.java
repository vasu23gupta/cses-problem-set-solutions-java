import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long ans =0;
        long curr=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] songs = new long[n];
        for (int i = 0; i < n; i++) songs[i] = sc.nextLong();
        HashSet<Long> unique = new HashSet<>();
        int a=0;
        for (int i = 0; i < n; i++) {
            long s = songs[i];
            if(!unique.contains(s)) {
                unique.add(s);
                curr++;
                ans = Long.max(ans,curr);
            }
            else{
                while(unique.contains(s)){

                    curr--;
                    unique.remove(songs[a]);
                    a++;
                }
                unique.add(s);
                curr++;
                ans = Long.max(ans,curr);
            }
        }
        System.out.println(ans);
    }
}
