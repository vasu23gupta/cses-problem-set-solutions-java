import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i]= fr.nextLong();
        }
        long prev = nums[0];
        long moves = 0;
        for (int i = 1; i < nums.length; i++) {
            long curr = nums[i];
            if(curr<prev) {
                moves += (prev - curr);
                //System.out.println(prev-curr);
                curr=prev;
            };
            prev=curr;
        }
        System.out.println(moves);
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
