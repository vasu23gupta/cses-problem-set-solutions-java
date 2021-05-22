import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long q = sc.nextLong();
        for (long i = 0; i < q; i++) {
            long k = sc.nextLong();
            long curr=k;
            long sub = 9;
            long digits=1;
            long multiple=9;
            while (curr-sub>0){
                digits++;
                multiple*=10;
                curr-=sub;
                sub=digits*multiple;
            }
            long count=1;
            while(curr%digits!=0){
                curr++;
                count++;
            }
            k=curr/digits-1;
            k+=(long) Math.pow(10,digits-1);
            k= (k/(long)Math.pow(10,count-1));
            System.out.println(k%10);
        }
    }
}
