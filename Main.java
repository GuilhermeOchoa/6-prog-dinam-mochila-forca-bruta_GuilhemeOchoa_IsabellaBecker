package com.vev;

public class Main {
    private static long  interacoes = 0;

    public static void main(String[] args) {
        long resposta1 = edtDistance("kitten", "sitting", "kitten".length() - 1, "sitting".length() - 1);
        System.out.println("Menor custo método recursivo: " +resposta1 + " Interações: " + interacoes);
        interacoes = 0;
        long resposta = edtDistanceMemo("casa", "pai");
        System.out.println("Menor custo método memoização: " +resposta + " Interações: " + interacoes);

    }

    public static long edtDistance(String s, String t, int i, int n) {
        if (i < 0) return n + 1;
        if (n < 0) return i + 1;
        interacoes++;
        if (s.charAt(i) == t.charAt(n)) {
            return edtDistance(s, t, i - 1, n - 1);
        } else {
            return 1 + Math.min(edtDistance(s, t, i - 1, n),
                                Math.min(edtDistance(s, t, i, n - 1),
                                         edtDistance(s, t, i - 1, n - 1)));
        }
    }

    public static long edtDistanceMemo(String a, String b) {
        int m = a.length();
        int n = b.length();
        long[][] memo = new long[m+1][n+1];
        long substitutionCost = 0;

        for (int i = 0; i <= m; i++) {
            memo[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            memo[0][j] = j;
        }
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                interacoes++;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    substitutionCost = 0;
                } else {
                    substitutionCost = 1;
                }
                memo[i][j] = Math.min(memo[i - 1][j] + 1, //remoção
                            Math.min(memo[i][j - 1] + 1, // inserção
                                    memo[i - 1][j - 1] + substitutionCost));// substituição

            }
        }
        return memo[m][n];
    }



}
