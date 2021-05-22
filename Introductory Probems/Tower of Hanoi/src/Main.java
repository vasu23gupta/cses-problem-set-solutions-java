import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void solve(int n, int from, int to, int other){
        if(n==1) {
            System.out.println(from+" "+to);
            return;
        }
        solve(n-1,from,other,to);
        System.out.println(from+" "+to);
        solve(n-1,other,to,from);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int ans=(int)Math.pow(2,n)-1;
        System.out.println(ans);
        solve(n,1,3,2);
    }
}
