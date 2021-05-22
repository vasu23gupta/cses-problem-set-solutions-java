import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[] route;
    static long ans=0;
    static int[][] board =  new int[7][7];

    public static boolean e(int i, int j, int[][] b){
        return(i>=0 && j>=0 && i<7 && j<7 && b[i][j]!=-1);
    }

    public static void solve(int index, int[][] b, int x, int y){
        //if(x<0 || x>6 || y<0 || y>6) return;
        if (index==48){
            if(x==6 && y==0) ans++;
            return;
        }
        if (x<0 || x>6 || y<0 || y>6 || b[x][y]==-1 || (x==6 && y==0)) return;

        //System.out.println(route[index]);
        b[x][y]=-1;
        //int[][] b = Arrays.stream(b).map(int[]::clone).toArray(int[][]::new);
        //int[][] b =b;
        if(route[index]=='?' || route[index]=='U'){
            if (! ( !e(x-2,y,b) && e(x-1,y-1, b) && e(x-1,y+1,b)))
                solve(index+1, b, x-1, y);
        }
        if(route[index]=='?' || route[index]=='R'){
            if (! ( !e(x,y+2,b) && e(x-1,y+1, b) && e(x+1,y+1,b)))
                solve(index+1, b, x, y+1);
        }
        if(route[index]=='?' || route[index]=='D'){
            if (! ( !e(x+2,y,b) && e(x+1,y-1, b) && e(x+1,y+1,b)))
                solve(index+1, b, x+1, y);
        }
        if(route[index]=='?' || route[index]=='L'){
            if (! ( !e(x,y-2,b) && e(x-1,y-1, b) && e(x+1,y-1,b)))
                solve(index+1, b, x, y-1);
        }
        /*switch (route[index]){
            case '?':
                if (! ( !e(x-2,y,b) && e(x-1,y-1, b) && e(x-1,y+1,b)))
                    solve(index+1, b, x-1, y);
                if (! ( !e(x,y-2,b) && e(x-1,y-1, b) && e(x+1,y-1,b)))
                    solve(index+1, b, x, y-1);
                if (! ( !e(x+2,y,b) && e(x+1,y-1, b) && e(x+1,y+1,b)))
                    solve(index+1, b, x+1, y);
                if (! ( !e(x,y+2,b) && e(x-1,y+1, b) && e(x+1,y+1,b)))
                    solve(index+1, b, x, y+1);
                break;

            case 'U':
                if (! ( !e(x-2,y,b) && e(x-1,y-1, b) && e(x-1,y+1,b)))
                    solve(index+1, b, x-1, y);
                break;

            case 'R':
                if (! ( !e(x,y+2,b) && e(x-1,y+1, b) && e(x+1,y+1,b)))
                    solve(index+1, b, x, y+1);
                break;

            case 'D':
                if (! ( !e(x+2,y,b) && e(x+1,y-1, b) && e(x+1,y+1,b)))
                    solve(index+1, b, x+1, y);
                break;

            case 'L':
                if (! ( !e(x,y-2,b) && e(x-1,y-1, b) && e(x+1,y-1,b)))
                    solve(index+1, b, x, y-1);
                break;
        }*/
        b[x][y]=0;
    }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        FastReader sc = new FastReader();
        route=sc.nextLine().toCharArray();
        solve(0,board,0,0);

        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
