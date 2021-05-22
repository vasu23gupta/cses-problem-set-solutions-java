import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int ans=0;

    public static void fillDiagonals(int i, int j, boolean[][] board){
        for (int k = 0; k < 8; k++) {
            try{
                board[i-k][j-k]=false;
            }catch (Throwable err){
            }

            try{
                board[i+k][j-k]=false;
            }catch (Throwable err){
            }

            try{
                board[i-k][j+k]=false;
            }catch (Throwable err){
            }

            try{
                board[i+k][j+k]=false;
            }catch (Throwable err){
            }
        }

    }

    public static void solve(int index, boolean[][] board){
        if(index==8){
            ans++;
            return;
        }
        for (int j = 0; j < 8; j++) {
            if(board[index][j]){
                boolean[][] copy = Arrays.stream(board).map(boolean[]::clone).toArray(boolean[][]::new);
                Arrays.fill(copy[index], false);
                for (int i = 0; i < 8; i++) {
                    copy[i][j]=false;
                }
                fillDiagonals(index,j,copy);
                solve(index+1, copy);
            }
        }
        board=null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] board= new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            char[] c = sc.nextLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if(c[j]=='.') board[i][j]=true;
                else board[i][j]=false;
            }
        }
        /*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]+"    ");
            }
            System.out.println();
        }*/
        solve(0,board);
        System.out.println(ans);
    }
}
