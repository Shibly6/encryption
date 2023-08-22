import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = scanner.nextLine();

        System.out.println("Enter Key: ");
        int shift = scanner.nextInt();

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted message: " +encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted message:" +decryptedMessage);
    }

    public static String encrypt(String message, int shift){
        StringBuilder encryptedMessage = new StringBuilder();
        message = message.toLowerCase();

        for(int i =0; i<message.length(); i++){
            char message_char = message.charAt(i);

            if(Character.isLetter(message_char)){
                message_char = (char) ((message_char - 'a' + shift) % 26 + 'a');
            }

            encryptedMessage.append(message_char);
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String message, int shift){
        StringBuilder decryptMessage = new StringBuilder();
        message = message.toLowerCase();
        for (int i=0; i<message.length(); i++){

            char message_char = message.charAt(i);

            if(Character.isLetter(message_char)){
                message_char = (char) ((message_char - 'a' - shift + 26) % 26 + 'a');
            }

            decryptMessage.append(message_char);
        }

        return decryptMessage.toString();
    }

    }