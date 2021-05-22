import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger bi = BigInteger.TWO.pow(sc.nextInt()).mod(BigInteger.valueOf((long)(Math.pow(10,9)+7)));
        System.out.println(bi);
    }
}
