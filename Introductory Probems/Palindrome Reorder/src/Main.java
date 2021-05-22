import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder a = new StringBuilder("");
        HashMap<Character,Integer> map = new HashMap<>();
        int odd=0;
        for (char c:
             s.toCharArray()) {
            if(map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
                //if(map.get(c)%2==0)odd--;
                //else odd++;
            }
            else {
                map.put(c, 1);
                //odd++;
            }
        }

        for (Map.Entry<Character, Integer> f : map.entrySet()) {
            char c = f.getKey();
            int i=map.get(c);
            if(i%2!=0){
                odd++;
                if(odd>1){
                    System.out.println("NO SOLUTION");
                    return;
                }
                a.append(c);
                map.replace(c, i-1);
            }
        }
        for (Map.Entry<Character, Integer> f : map.entrySet()) {
            char c = f.getKey();
            int i=map.get(c);
            String sub = String.valueOf(c).repeat(i/2);
            a.insert(0, sub);
            a.insert(a.length(), sub);
        }
        System.out.println(a);
    }
}
