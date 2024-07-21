package Cryptonite_v1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * @author Adel Jabbour
 */
public class PlayFair {

    private final String key;
    private final char[][] table;
    private final HashMap<Character, Integer> playfairIndexMap;

    public PlayFair() {
        this.key = generateRandomKey();
        this.table = createPlayfairTable();
        this.playfairIndexMap = createPlayfairIndexMap();
    }

    public PlayFair(String key) {
        this.key = pfKeyWithoutRepeat(key);
        this.table = createPlayfairTable();
        this.playfairIndexMap = createPlayfairIndexMap();
    }

    public char[][] getTable() {
        return table;
    }

    public String getKey() {
        return key;
    }

    public static String generateRandomKey() {
        List<Character> chars = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'j') {
                continue;
            }
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder randomKey = new StringBuilder();
        chars.forEach((tempChar) -> {
            randomKey.append(tempChar);
        });
        return randomKey.toString();
    }

    private String pfKeyWithoutRepeat(String key0) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        String key1 = key0.toUpperCase();
        key1 = key1.replaceAll("J", "I");
        StringBuilder upperCaseKey = new StringBuilder(key1);
        upperCaseKey.append("ABCDEFGHIKLMNOPQRSTUVWXYZ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < upperCaseKey.length(); i++) {
            char currentChar = upperCaseKey.charAt(i);
            boolean isAlpha = Character.isAlphabetic(currentChar);
            if (characterMap.get(currentChar) == null) {
                if (isAlpha) {
                    res.append(currentChar);
                    characterMap.put(currentChar, 1);
                }
            }
        }
        return res.toString();
    }

    private char[][] createPlayfairTable() {
        char[][] result = new char[5][5];
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result[i][j] = this.key.charAt(cnt);
                cnt += 1;
            }
        }
        return result;
    }

    public static String formatPlayfairText(String text, boolean everyTwo) {
        int step;
        if (everyTwo) {
            step = 2;
        }
        else {
            step = 1;
        }
        text = text.toUpperCase();
        text = text.replaceAll(" ", "");
        text = text.replaceAll("J", "I");

        for (int i = 0; i < text.length() - 1; i+=step) {
            //System.out.println(text.charAt(i)+""+ text.charAt(i + 1));
            if (text.charAt(i) == text.charAt(i + 1)) {
                text = text.substring(0, i + 1) + 'X' + text.substring(i + 1, text.length());
            }
        }
        if (text.length() % 2 == 1) {
            text += 'X';
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isAlpha = Character.isAlphabetic(c);
            if (isAlpha) {
                sb2.append(c);
            }
        }
        //System.out.println("formtted =      " + sb2.toString());
        return sb2.toString();
    }

    private char[][] convertToCharPairs(String text) {
        int pairCount = text.length() / 2;
        char[][] result = new char[pairCount][2];
        for (int i = 0; i < text.length(); i += 2) {
            result[i / 2][0] = text.charAt(i);
            result[i / 2][1] = text.charAt(i + 1);
        }
        return result;
    }

    private HashMap<Character, Integer> createPlayfairIndexMap() {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                indexMap.put(table[i][j], i * 5 + j);
            }
        }
        return indexMap;
    }

    public String cipher(String inputText) throws Exception {
        String text = formatPlayfairText(inputText,true);
        char[][] charPairs = convertToCharPairs(text);

        StringBuilder sb = new StringBuilder();
        for (char[] pair : charPairs) {
            if (playfairIndexMap.get(pair[0]) == null || playfairIndexMap.get(pair[1]) == null) {
                throw new Exception("Text must only contain alphabet characters");
            }

            int index1 = this.playfairIndexMap.get(pair[0]);
            int index2 = this.playfairIndexMap.get(pair[1]);
            int row1 = index1 / 5;
            int col1 = index1 % 5;
            int row2 = index2 / 5;
            int col2 = index2 % 5;

            if (row1 == row2) {
                sb.append(this.table[row1][(col1 + 1) % 5]).append(this.table[row2][(col2 + 1) % 5]);
            }
            else if (col1 == col2) {
                sb.append(this.table[(row1 + 1) % 5][col1]).append(this.table[(row2 + 1) % 5][col2]);
            }
            else {
                sb.append(this.table[row1][col2]).append(this.table[row2][col1]);
            }
        }

        String result = sb.toString().toUpperCase();
        return result;
    }

    public String decipher(String inputText) throws Exception {
        char[][] charPairs = convertToCharPairs(inputText);

        StringBuilder sb = new StringBuilder();
        for (char[] pair : charPairs) {
            if (playfairIndexMap.get(pair[0]) == null || playfairIndexMap.get(pair[1]) == null) {
                throw new Exception("Text must only contain alphabet characters");
            }

            int index1 = playfairIndexMap.get(pair[0]);
            int index2 = playfairIndexMap.get(pair[1]);
            int row1 = index1 / 5;
            int col1 = index1 % 5;
            int row2 = index2 / 5;
            int col2 = index2 % 5;

            if (row1 == row2) {
                sb.append(table[row1][(col1 - 1 + 5) % 5]).append(table[row2][(col2 - 1 + 5) % 5]);
            }
            else if (col1 == col2) {
                sb.append(table[(row1 - 1 + 5) % 5][col1]).append(table[(row2 - 1 + 5) % 5][col2]);
            }
            else {
                sb.append(table[row1][col2]).append(table[row2][col1]);
            }
        }

        String result = sb.toString().toLowerCase();
        return result;
    }

//    public static void main(String[] args) throws Exception {
//        PlayFair pf1 = new PlayFair("cryptographic");
//        String text = "sdrtyuhjknbvcfghjnmbuygftyh";
//        char[][] t = pf1.getTable();
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(t[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        String enc = pf1.cipher(text);
//        System.out.println("playfair1 enc = " + enc);
//        String dec = pf1.decipher(enc);
//        System.out.println("playfair1 dec = " + dec);
//    }

}
