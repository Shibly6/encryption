public class CaesarCipher2 {
    public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);

            if (Character.isLetter(currentChar)) {
                int offset = Character.isUpperCase(currentChar) ? 'A' : 'a';
                int alphabetIndex = currentChar - offset;
                int shiftedChar = (alphabetIndex + shift) % 26;
                if (shiftedChar < 0) {
                    shiftedChar += 26;
                }
                encryptedText.append((char) (shiftedChar + offset));
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);

            if (Character.isLetter(currentChar)) {
                int offset = Character.isUpperCase(currentChar) ? 'A' : 'a';
                int alphabetIndex = currentChar - offset;
                int shiftedChar = (alphabetIndex - shift + 26) % 26;
                if (shiftedChar < 0) {
                    shiftedChar += 26;
                }
                decryptedText.append((char) (shiftedChar + offset));
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        String message = "Hello, World!";
        int shift = 1036;

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
