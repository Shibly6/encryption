import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Character, Integer> alphabetIndex = new HashMap<>();

    static {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < alphabet.length; i++) {
            alphabetIndex.put(alphabet[i], i + 1);
        }
    }

    public static String encrypt(String plainText, int key) {
        plainText = plainText.toUpperCase(); // Convert to uppercase
        StringBuilder cipherText = new StringBuilder();

        System.out.println("Indexing process:");
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            if (Character.isLetter(ch)) {
                char base = 'A';
                int index = alphabetIndex.get(ch);
                System.out.println(ch + " -> " + index);

                int shiftedIndex = (index + key - 1) % 26 + 1;

                System.out.println("Shifted index by key " + key + ": " + shiftedIndex);

                ch = (char) (base + shiftedIndex - 1);
            }

            cipherText.append(ch);
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int key) {
        key = (key % 26 + 26) % 26; // Adjust key for negative values
        cipherText = cipherText.toUpperCase(); // Convert to uppercase
        StringBuilder decryptedText = new StringBuilder();

        System.out.println("\nDecryption process:");
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);

            if (Character.isLetter(ch)) {
                char base = 'A';
                int index = alphabetIndex.get(ch);
                System.out.println(ch + " -> " + index);

                int shiftedIndex = (index - key - 1 + 26) % 26 + 1;

                System.out.println("Shifted index by key " + key + ": " + shiftedIndex);

                ch = (char) (base + shiftedIndex - 1);
            }

            decryptedText.append(ch);
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Input Cipher text
        System.out.print("Enter Plane-Text: ");
        String cipherText = scan.nextLine();

        // Input Key
        System.out.print("Enter KEY: ");
        int key = scan.nextInt();

        // Encryption
        System.out.println("Encrypting...");
        String encryptedText = encrypt(cipherText, key);
        System.out.println("Encrypted: " + encryptedText);

        // Decryption
        System.out.println("\nEnter Cipher-Text:  ");
        scan.nextLine();
        String CipherText = scan.nextLine();

        System.out.print("Enter KEY: ");
        int manualKey = scan.nextInt();

        String decryptedText = decrypt(CipherText, manualKey);
        System.out.println("Decrypted: " + decryptedText);
    }
}