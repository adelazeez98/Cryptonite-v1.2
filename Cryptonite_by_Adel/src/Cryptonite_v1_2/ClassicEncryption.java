package Cryptonite_v1_2;

import java.util.HashMap;
import static Cryptonite_v1_2.Helper.*;

/*
 * @author Adel Jabbour
 */

public class ClassicEncryption {

    public final HashMap<Integer, Character> indexToCharacterMap;
    public final HashMap<Character, Integer> characterToIndexMap;

    public ClassicEncryption() {
        indexToCharacterMap = new HashMap<>();
        characterToIndexMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            indexToCharacterMap.put(i, (char) ('a' + i));
            characterToIndexMap.put((char) ('a' + i), i);
        }
    }

    public String encryptAdditive(String text, int key) {
        StringBuilder result = new StringBuilder();
        String lowercaseText = text.toLowerCase();
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(lowercaseText.charAt(i));
            }
            else {
                int index = (characterToIndexMap.get(lowercaseText.charAt(i)) + key) % 26;
                char character = indexToCharacterMap.get((index + 26) % 26);
                result.append(character);
            }
        }
        return result.toString().toUpperCase();
    }

    public String decryptAdditive(String cipherText, int key) {
        StringBuilder result = new StringBuilder();
        String lowercaseText = cipherText.toLowerCase();
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(lowercaseText.charAt(i));
            }
            else {
                int index = (characterToIndexMap.get(lowercaseText.charAt(i)) - key) % 26;
                char character = indexToCharacterMap.get((index + 26) % 26);
                result.append(character);
            }
        }
        return result.toString().toLowerCase();
    }

    public String encryptMultiplicative(String text, int key) throws Exception {
        StringBuilder result = new StringBuilder();
        String lowercaseText = text.toLowerCase();
        if (gcd(26, key) != 1) {
            throw new Exception("Key is not prime with 26 (gcd(" + key + ", 26) != 1)");
        }
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(lowercaseText.charAt(i));
            }
            else {
                int index = (characterToIndexMap.get(lowercaseText.charAt(i)) * key) % 26;
                char character = indexToCharacterMap.get((index + 26) % 26);
                result.append(character);
            }
        }
        return result.toString().toUpperCase();
    }

    public String decryptMultiplicative(String cipherText, int key) throws Exception {
        StringBuilder result = new StringBuilder();
        String lowercaseText = cipherText.toLowerCase();
        if (gcd(26, key) != 1) {
            throw new Exception("Key is not prime with 26 (gcd(" + key + ", 26) != 1)");
        }
        int inverseKey = modInverse(26, key);
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(lowercaseText.charAt(i));
            }
            else {
                int index = (characterToIndexMap.get(lowercaseText.charAt(i)) * inverseKey) % 26;
                char character = indexToCharacterMap.get((index + 26) % 26);
                result.append(character);
            }
        }
        return result.toString().toLowerCase();
    }

    public String encryptAffine(String text, int k1, int k2) throws Exception {
        StringBuilder result = new StringBuilder();
        String lowercaseText = text.toLowerCase();
        if (gcd(26, k1) != 1) {
            throw new Exception("gcd(26, " + k1 + ") != 1");
        }
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(lowercaseText.charAt(i));
            }
            else {
                int index = ((characterToIndexMap.get(lowercaseText.charAt(i)) * k1) + k2) % 26;
                char character = indexToCharacterMap.get((index + 26) % 26);
                result.append(character);
            }
        }
        return result.toString().toUpperCase();
    }

    public String decryptAffine(String cipherText, int k1, int k2) throws Exception {
        StringBuilder result = new StringBuilder();
        String lowercaseText = cipherText.toLowerCase();
        if (gcd(26, k1) != 1) {
            throw new Exception("gcd(26, " + k1 + ") != 1");
        }
        int inverseK1 = modInverse(26, k1);
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(lowercaseText.charAt(i));
            }
            else {
                int index = ((characterToIndexMap.get(lowercaseText.charAt(i)) - k2) * inverseK1) % 26;
                char character = indexToCharacterMap.get((index + 26) % 26);
                result.append(character);
            }
        }
        return result.toString().toLowerCase();
    }

    public String encryptVigenere(String text, String key) {
        StringBuilder result = new StringBuilder();
        String lowercaseText = text.toLowerCase();
        StringBuilder lowercaseKey = new StringBuilder(key.toLowerCase());
        int keyLen = key.length();
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                lowercaseKey.insert(i, ' ');
            }
        }
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(' ');
                continue;
            }
            int index = (characterToIndexMap.get(lowercaseText.charAt(i)) + characterToIndexMap.get(lowercaseKey.charAt(i % keyLen))) % 26;
            char character = indexToCharacterMap.get((index + 26) % 26);
            result.append(character);
        }
        return result.toString().toUpperCase();
    }

    public String decryptVigenere(String text, String key) {
    StringBuilder result = new StringBuilder();
        String lowercaseText = text.toLowerCase();
        StringBuilder lowercaseKey = new StringBuilder(key.toLowerCase());
        int keyLen = key.length();
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                lowercaseKey.insert(i, ' ');
            }
        }
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(' ');
                continue;
            }
            int index = (characterToIndexMap.get(lowercaseText.charAt(i)) - characterToIndexMap.get(lowercaseKey.charAt(i % keyLen))) % 26;
            char character = indexToCharacterMap.get((index + 26) % 26);
            result.append(character);
        }
        return result.toString().toLowerCase();
    }

    public String encryptAutokey(String text, String key) {
        StringBuilder result = new StringBuilder();
        String lowercaseText = text.toLowerCase();
        StringBuilder lowercaseKey = new StringBuilder(key.toLowerCase());
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(' ');
                lowercaseKey.insert(i, ' ');
                continue;
            }
            int index = (characterToIndexMap.get(lowercaseText.charAt(i)) + characterToIndexMap.get(lowercaseKey.charAt(i))) % 26;
            char character = indexToCharacterMap.get((index + 26) % 26);
            result.append(character);
            lowercaseKey.append(lowercaseText.charAt(i));
        }
        return result.toString().toUpperCase();
    }

    public String decryptAutokey(String text, String key) {
        StringBuilder result = new StringBuilder();
        String lowercaseText = text.toLowerCase();
        StringBuilder lowercaseKey = new StringBuilder(key.toLowerCase());
        for (int i = 0; i < lowercaseText.length(); i++) {
            if (lowercaseText.charAt(i) == ' ') {
                result.append(' ');
                lowercaseKey.insert(i, ' ');
                continue;
            }
            int index = (characterToIndexMap.get(lowercaseText.charAt(i)) - characterToIndexMap.get(lowercaseKey.charAt(i))) % 26;
            char character = indexToCharacterMap.get((index + 26) % 26);
            result.append(character);
            lowercaseKey.append(character);
        }
        return result.toString().toLowerCase();
    }

    private String std_hill_padding(String st, int n) {
        StringBuilder sb = new StringBuilder(st);
        while (sb.length() % n != 0) {
            sb.append('x');
        }
        return sb.toString();
    }

    private String book_hill_padding(String st, int n) {
        StringBuilder sb = new StringBuilder(st);
        while (sb.length() % n != 0) {
            sb.append('z');
        }
        return sb.toString();
    }

    private String std_hill_string(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                char c = indexToCharacterMap.get(mat[i][j]);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String book_hill_string(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                char c = indexToCharacterMap.get(mat[i][j]);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String std_hill_cipher(String text, int[][] key) {
        int det = determinantMat(key);
        if (gcd(26, det) != 1) {
            throw new IllegalStateException("The determinant of the matrix is not prime with 26 (gcd(26," + det + ") != 1)");
        }
        text = std_hill_padding(text, key.length);
        text = text.toLowerCase();
        int columns = text.length() / key.length;
        int rows = key.length;
        int[][] plaintext = new int[rows][columns];
        int index = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                plaintext[j][i] = characterToIndexMap.get(text.charAt(index++));
            }
        }
        int[][] cipher = multiplyMat(key, plaintext);
        return std_hill_string(cipher).toUpperCase();
    }

    public String book_hill_cipher(String text, int[][] key) {
        int det = determinantMat(key);
        if (gcd(26, det) != 1) {
            throw new IllegalStateException("The determinant of the matrix is not prime with 26 (gcd(26," + det + ") != 1)");
        }
        text = book_hill_padding(text, key.length);
        text = text.toLowerCase();
        int rows = text.length() / key.length;
        int columns = key.length;
        int[][] plaintext = new int[rows][columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                plaintext[i][j] = characterToIndexMap.get(text.charAt(index++));
            }
        }
        int[][] cipher = multiplyMat(plaintext, key);
        return book_hill_string(cipher).toUpperCase();
    }

    public String std_hill_decipher(String text, int[][] key) {
        int columns = text.length() / key.length;
        text = text.toLowerCase();
        int rows = key.length;
        int[][] ciphertext = new int[rows][columns];
        int index = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                ciphertext[j][i] = characterToIndexMap.get(text.charAt(index++));
            }
        }
        int[][] keyInverse = inverseMat(key);
        int[][] plaintext = multiplyMat(keyInverse, ciphertext);
        return std_hill_string(plaintext);
    }

    public String book_hill_decipher(String text, int[][] key) {
        int rows = text.length() / key.length;
        text = text.toLowerCase();
        int columns = key.length;
        int[][] ciphertext = new int[rows][columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ciphertext[i][j] = characterToIndexMap.get(text.charAt(index++));
            }
        }
        int[][] keyInverse = inverseMat(key);
        int[][] plaintext = multiplyMat(ciphertext, keyInverse);
        return book_hill_string(plaintext);
    }

}
