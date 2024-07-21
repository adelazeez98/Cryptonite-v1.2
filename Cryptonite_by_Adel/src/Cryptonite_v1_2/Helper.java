package Cryptonite_v1_2;

import java.util.Random;
import javax.xml.bind.DatatypeConverter;

/*
 * @author Adel Jabbour
 */
public class Helper {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }

    public static int modInverse(int r1, int r2) {
        int rr = r1;
        int t1, t2, t, q, r;
        t1 = 0;
        t2 = 1;
        while (r2 > 0) {
            q = r1 / r2;
            r = r1 - q * r2;
            t = t1 - q * t2;
            r1 = r2;
            r2 = r;
            t1 = t2;
            t2 = t;
        }
        if (r1 == 1) {
            if (t1 < 0) {
                t1 = rr + t1;
            }
        }
        return t1;
    }

    public static boolean stringIsAlphaNumeric(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isAlpha = Character.isAlphabetic(c);
            boolean isDigit = Character.isDigit(c);
            if (isDigit || isAlpha) {
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static String formatTextToAN(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isAlpha = Character.isAlphabetic(c);
            boolean isDigit = Character.isDigit(c);
            if (isDigit || isAlpha) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean stringIsAlpha(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isAlpha = Character.isAlphabetic(c);
            if (isAlpha) {
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static String formatTextToAlpha(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isAlpha = Character.isAlphabetic(c);
            if (isAlpha) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String generateRandomText(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter
            sb.append(randomChar);
        }
        return sb.toString();
    }

// Pad the string 's' with leading zeros to make it of length 'n'
    public static String padWithZeros(String s, int n) {
        StringBuilder paddedString = new StringBuilder(s);

        while (paddedString.length() < n) {
            paddedString.insert(0, '0');
        }

        return paddedString.toString();
    }

    public static String hexToAscii(String hex) {
        byte[] bytes = DatatypeConverter.parseHexBinary(hex);
        return new String(bytes);
    }

    public static String asciiToHex(String ascii) {
        StringBuilder result = new StringBuilder();
        byte[] bytes = ascii.getBytes();
        for (byte b : bytes) {
            result.append(padWithZeros(Integer.toHexString(b), 2));
        }
        return result.toString();
    }

    public static String generateRandomHexString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String hex = padWithZeros(Integer.toHexString(random.nextInt(256)), 2);
            sb.append(hex);
        }
        return sb.toString().toUpperCase();
    }

    public static String[] fromStringToBlocks(String input) {
        int remainder = input.length() % 32;
        int arrayLength = input.length() / 32;
        if (remainder > 0) {
            arrayLength++;
        }
        String[] blocks = new String[arrayLength];
        for (int i = 0; i < input.length(); i += 32) {
            if (i + 32 > input.length()) {
                blocks[i / 32] = input.substring(i, i + remainder);
            }
            else {
                blocks[i / 32] = input.substring(i, i + 32);
            }
        }
        return blocks;
    }

    public static int[] convertStringToIntArray(String input) {
        String[] numbers = input.split("\\s+");
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }

        return result;
    }

    public static String hexToBinary(String hex) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            String hexCharacter = String.valueOf(hex.charAt(i));
            int hexInteger = Integer.parseInt(hexCharacter, 16);
            String hexBinaryString = Integer.toBinaryString(hexInteger);
            hexBinaryString = padWithZeros(hexBinaryString, 4);
            res.append(hexBinaryString);
        }
        return res.toString();
    }

    public static String binaryToHex(String bin) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < bin.length(); i += 4) {
            String subBinaryString = bin.substring(i, i + 4);
            int subBinaryInteger = Integer.parseInt(subBinaryString, 2);
            String hexCharacter = Integer.toHexString(subBinaryInteger).toUpperCase();
            res.append(hexCharacter);
        }
        return res.toString();
    }

    // Perform XOR operation between hexadecimal strings 'x' and 'y'
    public static String performXOR(String x, String y) {
        // Determine the maximum length between 'x' and 'y'
        int maxLength = Math.max(x.length(), y.length());

        // Convert the hexadecimal strings to unsigned long integers
        long xn = Long.parseUnsignedLong(x, 16);
        long yn = Long.parseUnsignedLong(y, 16);

        // Perform XOR operation
        long result = xn ^ yn;

        // Convert the result back to a hexadecimal string
        String resultHex = Long.toHexString(result).toUpperCase();

        // Pad the result with leading zeros if necessary
        resultHex = padWithZeros(resultHex, maxLength);

        return resultHex;
    }

// Convert a hexadecimal block string 's' into a state matrix
    public static String[][] convertBlockToState(String s) {
        // Pad the string with zeros to ensure it has a length of 32 characters
        s = padWithZeros(s, 32);

        // Create a temporary state matrix
        String[][] state = new String[4][4];

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Extract two characters from the string to form a cell in the state matrix
                String cell = s.substring(index, index + 2);
                state[j][i] = cell;
                index += 2;
            }
        }
        return state;
    }

// Convert a state matrix into a hexadecimal block string
    public static String convertStateToBlock(String[][] state) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Append the cells of the state matrix to the StringBuilder
                result.append(state[j][i]);
            }
        }
        return result.toString();
    }

    public static String[] stateTo4Lines(String[][] state) {
        String[] res = new String[4];
        for (int i = 0; i < 4; i++) {
            res[i] = "";
            for (int j = 0; j < 4; j++) {
                res[i] += state[i][j].toUpperCase();
                res[i] += " ";
            }
        }
        return res;
    }

    public static String multiplyInGF(String stra, String strb) {
        byte a = (byte) Integer.parseInt(stra, 16);
        byte b = (byte) Integer.parseInt(strb, 16);
        byte result = 0;
        for (int i = 0; i < 8; i++) { // Loop 8 times for 8-bit elements
            if ((b & 1) != 0) {
                result ^= a; // If the least significant bit of b is 1, XOR the result with a
            }
            boolean carry = (a & 0x80) != 0; // Check if there is a carry (bit at position 8)
            a <<= 1; // Left shift a by 1 bit (multiply with 2)
            if (carry) {
                a ^= 0x1B; // If there was a carry, XOR a with the irreducible polynomial 0x1B
            }
            b >>= 1; // Right shift b by 1 bit (divide by 2)
        }
        return padWithZeros(Integer.toHexString(result & 0xFF), 2).toUpperCase(); // Return the result of the multiplication
    }

    public static int[][] minor(int[][] matrix, int row, int column) {
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i != row && j < matrix[i].length; j++) {
                if (j != column) {
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
                }
            }
        }
        return minor;
    }

    public static int determinantMat(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalStateException("invalid dimensions");
        }
        if (matrix.length == 2) {
            return (((matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) % 26) + 26) % 26;
        }
        int det = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * determinantMat(minor(matrix, 0, i));
        }
        det = ((det % 26) + 26) % 26;
        return det;
    }

    public static int[][] inverseMat(int[][] matrix) {
        int[][] inverse = new int[matrix.length][matrix.length];
        if (matrix.length == 2) {
            int det = (((matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) % 26) + 26) % 26;
            if (gcd(26, det) != 1) {
                throw new IllegalStateException("det of Matrix is NOT prime with 26 ( gcd(26," + det + ") != 1 )");
            }
            int det_1 = modInverse(26, det);
            inverse[0][0] = (((matrix[1][1] * det_1) % 26) + 26) % 26;
            inverse[1][1] = (((matrix[0][0] * det_1) % 26) + 26) % 26;
            inverse[0][1] = (((-1 * matrix[0][1] * det_1) % 26) + 26) % 26;
            inverse[1][0] = (((-1 * matrix[1][0] * det_1) % 26) + 26) % 26;
        }
        else {
            // minors and cofactors
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    inverse[i][j] = ((int) Math.pow(-1, i + j)) * determinantMat(minor(matrix, i, j));
                }
            }
            // adjugate and determinantMat
            int det = determinantMat(matrix);
            if (gcd(26, det) != 1) {
                throw new IllegalStateException("det of Matrix is NOT prime with 26 ( gcd(26," + det + ") != 1 )");
            }
            else {
                det = modInverse(26, det);
            }
            for (int i = 0; i < inverse.length; i++) {
                for (int j = 0; j <= i; j++) {
                    int temp = inverse[i][j];
                    inverse[i][j] = inverse[j][i] * det;
                    inverse[j][i] = temp * det;
                }
            }
            for (int i = 0; i < inverse.length; i++) {
                for (int j = 0; j < inverse[0].length; j++) {
                    inverse[i][j] = ((inverse[i][j] % 26) + 26) % 26;
                }
            }
        }
        return inverse;
    }

    public static int[][] multiplyMat(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalStateException("invalid dimensions");
        }
        int[][] matrix = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                long sum = 0;
                for (int k = 0; k < a[i].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                int res = (int) (sum % 26);
                matrix[i][j] = res;
            }
        }
        return matrix;
    }

    // Calculate a^x mod n using SAM
    public static int squareAndMultiply(int a, int x, int n) {
        String xAsBinary = Integer.toBinaryString(x);
        int y = 1;

        for (int i = xAsBinary.length() - 1; i >= 0; i--) {
            if (xAsBinary.charAt(i) == '1') {
                y = (a * y) % n;
            }
            a = (a * a) % n;
        }
        return y;
    }

}
