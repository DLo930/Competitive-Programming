/*
ID: dennisl5
LANG: JAVA
TASK: namenum
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class namenum {
    static final String FILE = "namenum";
    
    static String convert(String s) {
        String res = "";
        for(int i=0;i<s.length();i++) res += map(s.charAt(i));
        return res;
    }
    static int map(char c) {
        int res = "ABCDEFGHIJKLMNOPRSTUVWXY".indexOf(c);
        return (res > -1) ? res/3+2 : 0;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
        String str = s.nextLine();
        String tmp;
        while((tmp=br.readLine()) != null) {
            if(convert(tmp).equals(str)) list.add(tmp);
        }
        if(list.size() == 0) out.println("NONE");
        for(String a : list) out.println(a);
    }
}