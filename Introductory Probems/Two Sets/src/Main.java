import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        long n = fr.nextLong();
        long sumn = (n*(n+1))/2;
        if(sumn%2!=0){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
            long half = sumn/2;
            long curr=n;
            long s1=0;
            long s2=0;
            StringBuilder a1=new StringBuilder("");
            StringBuilder a2=new StringBuilder("");
            while(curr!=0){
                if(half>=curr){
                    half-=curr;
                    a1.append(curr+" ");
                    s1++;
                }
                else {
                    a2.append(curr+" ");
                    s2++;
                }
                curr--;
            }
            System.out.println(s1);
            System.out.println(a1);
            System.out.println(s2);
            System.out.println(a2);
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
