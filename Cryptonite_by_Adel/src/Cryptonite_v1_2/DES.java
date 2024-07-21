package Cryptonite_v1_2;

import static Cryptonite_v1_2.Helper.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/*
 * @author Adel Jabbour
 */
public class DES {

    public static final int ENCRYPT = 1;
    public static final int DECRYPT = -1;
    private final String key;
    private String[] sub_keys = new String[16];

    private final StringBuilder outputAsText = new StringBuilder();

    public String[] getSub_keys() {
        return sub_keys;
    }

    public String getKey() {
        return key;
    }

    public DES(String key) throws Exception {
        if (key.length() != 16) {
            throw new Exception("DES Key length must be 16 hexadecimal characters (64-bit)");
        }
        this.key = key;
        this.sub_keys = generateSubkeys(key);
    }

    private final int[] IP = {
        58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44,
        36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22,
        14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57,
        49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35,
        27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13,
        5, 63, 55, 47, 39, 31, 23, 15, 7
    };

    private final int[] IP1 = {
        40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47,
        15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22,
        62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36,
        4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11,
        51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58,
        26, 33, 1, 41, 9, 49, 17, 57, 25
    };

    private final int[] PC1 = {
        57, 49, 41, 33, 25, 17, 9, 1, 58, 50,
        42, 34, 26, 18, 10, 2, 59, 51, 43, 35,
        27, 19, 11, 3, 60, 52, 44, 36, 63, 55,
        47, 39, 31, 23, 15, 7, 62, 54, 46, 38,
        30, 22, 14, 6, 61, 53, 45, 37, 29, 21,
        13, 5, 28, 20, 12, 4
    };

    private final int[] PC2 = {
        14, 17, 11, 24, 1, 5, 3, 28, 15, 6,
        21, 10, 23, 19, 12, 4, 26, 8, 16, 7,
        27, 20, 13, 2, 41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48, 44, 49, 39, 56,
        34, 53, 46, 42, 50, 36, 29, 32
    };

    private final int[] EXP_D = {
        32, 1, 2, 3, 4, 5, 4, 5,
        6, 7, 8, 9, 8, 9, 10, 11,
        12, 13, 12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21, 20, 21,
        22, 23, 24, 25, 24, 25, 26, 27,
        28, 29, 28, 29, 30, 31, 32, 1
    };

    private final int[][][] SBOX
            = {
                {
                    {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                    {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
                },
                {
                    {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                    {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                    {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                    {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
                },
                {
                    {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                    {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                    {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                    {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
                },
                {
                    {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                    {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                    {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                    {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
                },
                {
                    {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                    {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                    {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                    {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
                },
                {
                    {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                    {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                    {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                    {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
                },
                {
                    {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                    {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                    {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                    {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
                },
                {
                    {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                    {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                    {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                    {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
                }
            };

    private final int[] PBOX = {
        16, 7, 20, 21, 29, 12, 28, 17,
        1, 15, 23, 26, 5, 18, 31, 10,
        2, 8, 24, 14, 32, 27, 3, 9,
        19, 13, 30, 6, 22, 11, 4, 25
    };

//Left circular shift on binary input based on round number
    private String leftCircularShift(String inputString, int round) {
        char firstChar = inputString.charAt(0);
        char secondChar = inputString.charAt(1);
        String modifiedString;
        if (round == 1 || round == 2 || round == 9 || round == 16) {
            modifiedString = inputString.substring(1) + firstChar;
        }
        else {
            modifiedString = inputString.substring(2) + firstChar + secondChar;
        }
        return modifiedString;
    }

//premutation boxes function (input hex, output hex)
    private String permutation(int[] box, String hex) {
        StringBuilder res = new StringBuilder();
        String binary = hexToBinary(hex);
        for (int i = 0; i < box.length; i++) {
            res.append(binary.charAt(box[i] - 1));
        }
        return binaryToHex(res.toString());
    }

    //key schedule (input is in hex)
    private String[] generateSubkeys(String key) {
        outputAsText.append("* Generate subKeys:\n");
        outputAsText.append("\t0- premutate using permute choice 1:\n");
        String[] subkeys = new String[16];
        key = permutation(PC1, key);
        String binaryKey = hexToBinary(key);
        outputAsText.append("\t   in binary ==> ").append(binaryKey).append("\n");
        outputAsText.append("\t   in hex    ==> ").append(key).append("\n");
        for (int i = 1; i <= 16; i++) {
            outputAsText.append("\n\tRound #").append(i).append("\n");
            String leftHalf = binaryKey.substring(0, 28);
            String rightHalf = binaryKey.substring(28, 56);
            if (i == 1) {
                outputAsText.append("\t1- split to right and left half:\n");
            }
            else {
                outputAsText.append("\t1- from step 2 in previous round:\n");
            }
            outputAsText.append("\t   left = ").append(leftHalf).append("\tright = ").append(rightHalf).append("\n\n");
            outputAsText.append("\t2- perform left circular shift on two halves based on roud number:\n");
            outputAsText.append("\t   left = ").append(leftCircularShift(leftHalf, i)).append("\tright = ").append(leftCircularShift(rightHalf, i)).append("\n\n");
            binaryKey = leftCircularShift(leftHalf, i) + leftCircularShift(rightHalf, i);
            subkeys[i - 1] = permutation(PC2, binaryToHex(binaryKey));
            outputAsText.append("\t3- perform permuation Choice 2 on whole key to get round key:\n");
            outputAsText.append("\t   round key #").append(i).append("  = ").append(hexToBinary(subkeys[i - 1])).append("\n");
            outputAsText.append("\t   in hexadecimal = ").append(subkeys[i - 1]).append("\n\n");
        }
        return subkeys;
    }

//des function (exanpsion, performXOR with key, then 8 S-boxes, finally straight P-box)
    private String desFunction(String rightSide, String key) {
        outputAsText.append("\t\ta- expand right half using expantion D Box:\n");

        String expandedRightSide = permutation(EXP_D, rightSide);
        outputAsText.append("\t\t   binary ==> ").append(hexToBinary(expandedRightSide)).append("\n");
        outputAsText.append("\t\t   hex    ==> ").append(expandedRightSide).append("\n\n");
        String xoredResult = performXOR(expandedRightSide, key);
        outputAsText.append("\t\tb- perform xor on result from step a with round key:\n");
        outputAsText.append("\t\t   binary ==> ").append(hexToBinary(xoredResult)).append("\n");
        outputAsText.append("\t\t   hex    ==> ").append(xoredResult).append("\n\n");
        String binaryResult = hexToBinary(xoredResult);
        outputAsText.append("\t\tc- use Subtitute box on step b :\n");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binaryResult.length(); i += 6) {
            int sboxIndex = i / 6;
            String sboxInput = binaryResult.substring(i, i + 6);
            int row = Integer.parseInt(String.valueOf(sboxInput.charAt(0)) + sboxInput.charAt(5), 2);
            int col = Integer.parseInt(sboxInput.substring(1, 5), 2);
            sb.append(Integer.toHexString(SBOX[sboxIndex][row][col]));
        }
        outputAsText.append("\t\t   result ==> ").append(sb.toString().toUpperCase()).append("\n\n");
        String permutedResult = permutation(PBOX, sb.toString());
        outputAsText.append("\t\td- Use permutation Box P on step c:\n");
        outputAsText.append("\t\t   result ==> ").append(permutedResult).append("\n\n");
        return permutedResult;
    }

//each round consists of Mixer (DES function and performXOR) and Swapper
    private String desRound(String input, String key, int mode, int round) throws Exception {
        String leftSide = input.substring(0, 8);
        String rightSide = input.substring(8, 16);
        outputAsText.append("\t1- split input to right and left:\n");
        outputAsText.append("\t   left = ").append(leftSide).append("\tright = ").append(rightSide).append("\n\n");
        outputAsText.append("\t2- Perform DES function on right half:\n\n");

        String desFunctionResult = desFunction(rightSide, key);
        outputAsText.append("\t3- left side equals xor result between DES func output and old left side:\n");
        leftSide = performXOR(leftSide, desFunctionResult);
        outputAsText.append("\t   left = ").append(leftSide).append("\tright = ").append(rightSide).append("\n\n");

        // Swapper
        switch (mode) {
            case ENCRYPT:
                // Encrypt
                if (round == 15) {
                    outputAsText.append("\t4- Do NOT swap between left and right:\n");
                    outputAsText.append("\t   left = ").append(leftSide).append("\tright = ").append(rightSide).append("\n\n");
                    return leftSide + rightSide; // Last round of encryption is 15, so don't swap
                }
                else {
                    outputAsText.append("\t4- swap between left and right:\n");
                    outputAsText.append("\t   left = ").append(rightSide).append("\tright = ").append(leftSide).append("\n\n");
                    return rightSide + leftSide; // Else, swap
                }
            case DECRYPT:
                // Decrypt
                if (round == 0) {
                    outputAsText.append("\t4- Do NOT swap between left and right:\n");
                    outputAsText.append("\t   left = ").append(leftSide).append("\tright = ").append(rightSide).append("\n\n");
                    return leftSide + rightSide; // Last round of decryption is 0, so don't swap
                }
                else {
                    outputAsText.append("\t4- swap between left and right:\n");
                    outputAsText.append("\t   left = ").append(rightSide).append("\tright = ").append(leftSide).append("\n\n");
                    return rightSide + leftSide; // Else, swap
                }
            default:
                throw new Exception("No valid mode specified (ENCRYPTION or DECRYPTION)");
        }
    }

//DES Cipher
    public String cipher(String text, int mode) throws Exception {
        if (text.length() != 16) {
            throw new Exception("Text length must be 16 hexadecimal characters (64-bit)");
        }
        outputAsText.append("** Encryption or Decryption Rounds:\n");
        outputAsText.append("   text (").append(text).append(") and key (").append(this.key).append("):\n\n");
        // Permutate text (IP mutation)
        text = permutation(IP, text);
        outputAsText.append("0- permutate text using initial remutation:\n");
        outputAsText.append("   binary ==> ").append(hexToBinary(text)).append("\n");
        outputAsText.append("   hex    ==> ").append(text).append("\n\nBegin 16 Rounds:\n");
        // Assign start and end values for Encryption and Decryption modes
        int start, end, step;
        switch (mode) {
            case ENCRYPT:
                start = 0;
                end = 15;
                step = 1;
                break;
            case DECRYPT:
                start = 15;
                end = 0;
                step = -1;
                break;
            default:
                throw new Exception("No valid mode specified (ENCRYPTION or DECRYPTION)");
        }

        // 16 rounds
        for (int i = start; i != (end + step); i += step) {
            outputAsText.append("\nRound #").append(i+1).append("\n");
            text = desRound(text, this.sub_keys[i], mode, i);
        }
        outputAsText.append("*** Finally, inverse initial permutation on text to get final output:\n");
        // De-permutate text (inverseMat of IP mutation)
        text = permutation(IP1, text);
        outputAsText.append("\t final result = ").append(text);

        return text;
    }

    //Save output of Key Schedule And Encryption to text file
    public boolean SaveToTextFile() {
        String userHome = System.getProperty("user.home");
        String parentDirectory = userHome + File.separator + "Documents";
        String directory = "Cryptonite 1.2";
        String fileName = "DES_" + this.getKey().toUpperCase() + ".txt";
        String fullPathWithFilename = parentDirectory + File.separator + directory + File.separator + fileName;
        File directoryToCheck = new File(parentDirectory, directory);
        if (!directoryToCheck.isDirectory()) {
            if (!directoryToCheck.mkdir()) {
                return false;  // Directory creation failed
            }
        }
        try (FileOutputStream fos = new FileOutputStream(fullPathWithFilename);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                BufferedWriter writer = new BufferedWriter(osw)) {
            writer.write(this.outputAsText.toString());
            return true;  // File saved successfully
        }
        catch (IOException e) {
            return false;  // File write operation failed
        }
    }

}
