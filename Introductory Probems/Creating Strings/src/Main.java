import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<String> set = new HashSet<>();
    public static void solve(int chari, int length, int index, int[] chars, String s){
        //System.out.println(index);
        chars[chari]--;
        if(index==length-1){
            for (int i = 0; i < 26; i++) {
                if(chars[i]>0){
                    s+=(char)(i+'a');
                    if(!set.contains(s))set.add(s);
                }
            }
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(chars[i]>0) {
                //System.out.println(i);
                int[] newArr= new int[26];
                System.arraycopy(chars,0,newArr,0,26);
                solve(i,length, index + 1, newArr, s+((char)(i+'a')));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] chars = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i)-'a']++;
        }
        chars[0]++;
        solve(0,n,0,chars,"");
        int size = set.size();
        Object[] arr =set.toArray();
        String[] stringArray = Arrays.copyOf(arr, size, String[].class);
        Arrays.sort(stringArray);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(stringArray[i]);
        }
    }
}
