/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USACO16;

/**
 *
 * @author Dennis
 */
import java.util.*;
import java.io.*;

public class cownomics {
    static int val(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            default:
                return 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")), true);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        String[] arr = new String[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = br.readLine();
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            boolean[] a = new boolean[4];
            int j = 0;
            for (; j < n; j++) {
                a[val(arr[j].charAt(i))] = true;
            }
            for (; j < 2 * n; j++) {
                if (a[val(arr[j].charAt(i))]) {
                    break;
                }
            }

            if (j == 2 * n) {
                res++;
            }
        }
        out.println(res);
    }
}
