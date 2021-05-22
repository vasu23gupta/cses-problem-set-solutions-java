import java.util.Scanner;

public class Main {

    public static String[]  solve(int n){
        if(n==1) return new String[]{"0","1"};
        else{
            int po = (int)Math.pow(2,n);
            int half = po/2;
            String[] l1 = new String[po];
            String[] l = solve(n-1);
            for (int i = 0; i < half; i++) {
                //System.out.println("n: "+n+"   i: "+i);
                l1[i]="0"+(l[i]);
                l1[i+half]="1"+(l[half-i-1]);
            }
            return l1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] l = solve(n);
        for (int i = 0; i < Math.pow(2,n); i++) {
            System.out.println(l[i]);
        }
    }
}
