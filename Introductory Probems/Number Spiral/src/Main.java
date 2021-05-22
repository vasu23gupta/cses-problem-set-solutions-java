import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            long y = fr.nextLong();
            long x = fr.nextLong();
            long ans=0;
            if(y>x){
                if (y % 2 == 0) {
                    long a = y * y;
                    ans=a-x+1;
                } else {
                    long a = (y - 1) * (y - 1) + 1;
                    ans=a+x-1;
                }
            }
            else{
                if (x % 2 == 0) {
                    long b = (x - 1) * (x - 1) + 1;
                    ans=b+y-1;
                } else {
                    long b = x*x;
                    ans=b-y+1;
                }
            }
            System.out.println(ans);
        }
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
