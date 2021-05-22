import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans=1;
        int n = sc.nextInt();
        int[] pos = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            pos[x]=i;
        }
        for (int i = 1; i < n; i++) {
            if(pos[i+1]<pos[i]) ans++;
        }
        System.out.println(ans);
    }
}
