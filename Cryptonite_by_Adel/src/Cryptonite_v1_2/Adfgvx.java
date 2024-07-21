package Cryptonite_v1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
 * @author Adel Jabbour
 */
public class Adfgvx {

    private final HashMap<Character, Integer> adfgvxCharIndices = new HashMap<>();
    private final HashMap<Character, Integer> charIndices = new HashMap<>();
    private final char[][] AdfgvxTable;
    private final String key1;
    private final String key2Str;
    private final int[] key2Arr;

    public Adfgvx(int key2Len) throws Exception {
        if (key2Len <= 0) {
            throw new Exception("Key 2 length must be greater than zero (key2 Length > 0)");
        }
        init();
        this.key1 = generateRandomKey1();
        this.key2Str = generateRandomKey2(key2Len);
        this.key2Arr = adfgvxKey2AsIntArray(this.key2Str);
        this.AdfgvxTable = createAdfgvxTable(this.key1);
    }

    public Adfgvx(String key1, String key2) throws Exception {
        if (key2.length() == 0) {
            throw new Exception("Key 2 length must be greater than zero (key2 Length > 0)");
        }
        init();
        this.key1 = AdfgvxKeyWithoutRepeat(key1);
        this.key2Str = key2.replaceAll(" ", "");
        this.key2Arr = adfgvxKey2AsIntArray(this.key2Str);
        this.AdfgvxTable = createAdfgvxTable(this.key1);
    }

    private void init() {
        adfgvxCharIndices.put('A', 1);
        adfgvxCharIndices.put('D', 2);
        adfgvxCharIndices.put('F', 3);
        adfgvxCharIndices.put('G', 4);
        adfgvxCharIndices.put('V', 5);
        adfgvxCharIndices.put('X', 6);
    }

    public String getKey1() {
        return key1;
    }

    public String getKey2Str() {
        return key2Str;
    }

    public int[] getKey2Arr() {
        return key2Arr;
    }

    public char[][] getTable() {
        return AdfgvxTable;
    }

    public static String generateRandomKey1() {
        List<Character> chars = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            chars.add(c);
        }
        for (char c = '0'; c <= '9'; c++) {
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder randomKey = new StringBuilder();
        chars.forEach((tempChar) -> {
            randomKey.append(tempChar);
        });
        return randomKey.toString().toUpperCase();
    }

    public static String generateRandomKey2(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter
            sb.append(randomChar);
        }
        return sb.toString();
    }

    private String AdfgvxKeyWithoutRepeat(String key0) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        StringBuilder upperCaseKey = new StringBuilder(key0.toUpperCase());
        upperCaseKey.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < upperCaseKey.length(); i++) {
            char currentChar = upperCaseKey.charAt(i);
            boolean isAlpha = Character.isAlphabetic(currentChar);
            boolean isDigit = Character.isDigit(currentChar);
            if (characterMap.get(currentChar) == null) {
                if (isAlpha || isDigit) {
                    res.append(currentChar);
                    characterMap.put(currentChar, 1);
                }
            }
        }
        return res.toString();
    }

    public static int[] adfgvxKey2AsIntArray(String key2) {
        int n = key2.length();
        int[] res = new int[n];
        char[] sortedK2 = key2.toCharArray();
        Arrays.sort(sortedK2);
        HashMap<Character, List<Integer>> charToPositions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = key2.charAt(i);
            if (!charToPositions.containsKey(ch)) {
                charToPositions.put(ch, new ArrayList<>());
            }
            charToPositions.get(ch).add(i);
        }
        for (int i = 0; i < n; i++) {
            char ch = sortedK2[i];
            List<Integer> positions = charToPositions.get(ch);
            res[i] = positions.remove(0);
        }
        return res;
    }

    private char[][] createAdfgvxTable(String key) {
        char[][] table = new char[7][7];
        int counter = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                table[i][j] = key.charAt(counter);
                charIndices.put(key.charAt(counter), i * 100 + j);
                counter += 1;
            }
        }
        table[0][0] = '-';
        table[0][1] = 'A';
        table[1][0] = 'A';
        table[0][2] = 'D';
        table[2][0] = 'D';
        table[0][3] = 'F';
        table[3][0] = 'F';
        table[0][4] = 'G';
        table[4][0] = 'G';
        table[0][5] = 'V';
        table[5][0] = 'V';
        table[0][6] = 'X';
        table[6][0] = 'X';
        return table;
    }

    private String key1Cipher(String text) throws Exception {
        StringBuilder encryptedText = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (charIndices.get(currentChar) == null) {
                throw new Exception("character was not found in table");
            }
            int temp = charIndices.get(currentChar);
            int row = temp / 100;
            int column = temp % 100;
            encryptedText.append(this.AdfgvxTable[row][0]).append(this.AdfgvxTable[0][column]);
        }
        return encryptedText.toString();
    }

    private String key1Decipher(String inputText) throws Exception {
        StringBuilder resultText = new StringBuilder();

        // if we added odd number of padding to adfgvx text
        // then decrease length of text by 1
        int textLength = inputText.length();
        if (textLength % 2 == 1) {
            textLength -= 1;
        }

        for (int i = 0; i < textLength; i += 2) {
            //split input into pairs
            String pair = inputText.substring(i, i + 2);
            char firstCharacter = pair.charAt(0);
            char secondCharacter = pair.charAt(1);
            if ((adfgvxCharIndices.get(firstCharacter) == null) || (adfgvxCharIndices.get(secondCharacter) == null)) {
                throw new Exception("Decryption text must contain only ADFGVX characters");
            }
            int row = adfgvxCharIndices.get(firstCharacter);
            int col = adfgvxCharIndices.get(secondCharacter);
            resultText.append(this.AdfgvxTable[row][col]);
        }
        return resultText.toString().toLowerCase();
    }

    private String key2Cipher(String text, char paddingChar) {
        StringBuilder encryptedText = new StringBuilder();
        int keyLength = this.key2Str.length();
        int textLength = text.length();
        int numRows;

        // Calculate the number of rows needed based on the length of the text and the key length
        if (textLength % keyLength == 0) {
            numRows = textLength / keyLength;
        }
        else {
            numRows = (textLength / keyLength) + 1;
        }

        // Create a 2D array to hold the characters of the encrypted text
        char[][] grid = new char[keyLength][numRows];

        int currentIndex = 0;

        // Fill the grid with characters from the text
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (currentIndex <= textLength - 1) {
                    grid[j][i] = text.charAt(currentIndex);
                    currentIndex++;
                }
                else {
                    grid[j][i] = paddingChar;
                }
            }
        }

        // Traverse the sorted key to retrieve the encrypted characters
        for (int i = 0; i < this.key2Str.length(); i++) {
            int index = this.key2Arr[i];
            // Append the characters from the corresponding column of the grid to the encrypted text
            for (int j = 0; j < numRows; j++) {
                encryptedText.append(grid[index][j]);
            }
        }

        // Remove any spaces from the encrypted text
        return encryptedText.toString().replace(" ", "");
    }

    private String key2Decipher(String encryptedText) {
        int numRows;
        int numCols = this.key2Str.length();

        // Calculate the number of rows based on the length of the encrypted text and the number of columns
        if (encryptedText.length() % numCols == 0) {
            numRows = encryptedText.length() / numCols;
        }
        else {
            numRows = (encryptedText.length() / numCols) + 1;
        }

        // Create a grid to store the characters of the decrypted text
        char[][] grid = new char[numCols][numRows];
        char[][] sortedGrid = new char[numCols][numRows];

        // Calculate the remainder of the encrypted text length divided by the number of columns
        int remainder = encryptedText.length() % numCols;
        int currentIndex = 0;

        // StringBuilder to build the decrypted text
        StringBuilder resultBuilder = new StringBuilder();

        // Fill the grid with the characters from the encrypted text
        for (int i = 0; i < numCols; i++) {
            int rowIndex = this.key2Arr[i];
            int colIndex;

            // Handle the special case when there is a remainder
            if (remainder > 0) {
                colIndex = (rowIndex < remainder) ? numRows : numRows - 1;

                // Fill the remaining cell with a space character
                if (colIndex < numRows) {
                    grid[i][colIndex] = ' ';
                }
            }
            else {
                colIndex = numRows;
            }

            // Fill the cells of the grid with characters from the encrypted text
            for (int j = 0; j < colIndex; j++) {
                grid[i][j] = encryptedText.charAt(currentIndex);
                currentIndex++;
            }
        }

        // Rearrange the rows of the grid based on the original order of the key
        for (int i = 0; i < numCols; i++) {
            int originalRowIndex = this.key2Arr[i];
            sortedGrid[originalRowIndex] = grid[i];
        }

        // Build the decrypted text by traversing the sorted grid
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                resultBuilder.append(sortedGrid[j][i]);
            }
        }

        // Convert the result to a string and remove any spaces
        return resultBuilder.toString().replaceAll(" ", "");
    }

    public String cipher(String plainText, char paddingCharacter) throws Exception {
        String cipheredTextUsingKey1 = key1Cipher(plainText);
        String cipheredTextUsingKey2 = key2Cipher(cipheredTextUsingKey1, paddingCharacter);
        return cipheredTextUsingKey2;
    }

    public String decipher(String cipheredText) throws Exception {
        String decipheredTextUsingKey2 = key2Decipher(cipheredText);
        String decipheredTextUsingKey1 = key1Decipher(decipheredTextUsingKey2);
        return decipheredTextUsingKey1;
    }


}
