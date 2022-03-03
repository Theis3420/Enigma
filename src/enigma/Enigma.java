package enigma;

import java.util.Scanner;

public class Enigma {

  char[] letters = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};
  int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
  Scanner in = new Scanner(System.in);
  StringBuilder sb = new StringBuilder();

  public int letterToNumber(char letter, int shift) {
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == letter) {
        if (letter == ' ') {
          return 0;
        }
        if (i + shift > 29) {
          shift -= 29;
        } else if (i + shift < 1) {
          shift += 29;
        }
        return numbers[i + shift];
      }
    }
    return -1;
  }
  public char numberToLetter(int number) {
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == number) {
        return letters[i];
      }
    }
    return '/';
  }
  public String alterMessage(String message, int shift) {
    for (int i = 0; i < message.length(); i++) {
      sb.append(numberToLetter(letterToNumber(message.charAt(i), shift)));
    }
    return String.valueOf(sb);
  }

  public String userInputMode() {
    return in.nextLine();
  }
  public String userInputMessage() {
    return in.nextLine();
  }
  public int userInputShift() {
    return in.nextInt();
  }

  public void displayMainText() {
    System.out.println("Welcome to Enigma!\nWrite either Encrypt or Decrypt to continue");
  }
  public void displayEncryptText() {
    System.out.println("You have chosen to encrypt a message!\nWrite your message (no lower case)");
  }
  public void displayDecryptText() {
    System.out.println("You have chosen to decrypt a message!\nWrite your message (no lower case)");
  }
  public void displayShiftText() {
    System.out.println("Enter a shift value between 1 and 29");
  }
  public void displayEncryptionResult(String finalMessage) {
    System.out.println("Your encrypted message is:\n" + finalMessage);
  }
  public void displayDecryptionResult(String finalMessage) {
    System.out.println("Your Decrypted message is:\n" + finalMessage);
  }

  public void execute() {
    displayMainText();
    String mode = userInputMode();
    if (mode.equals("Encrypt")) {
      displayEncryptText();
      String message = userInputMessage();
      displayShiftText();
      int shift = userInputShift();
      displayEncryptionResult(alterMessage(message, shift));
    } else if (mode.equals("Decrypt")) {
      displayDecryptText();
      String message = userInputMessage();
      displayShiftText();
      int shift = userInputShift();
      displayDecryptionResult(alterMessage(message, -shift));
    }
  }

  public static void main(String[] args) {
    new Enigma().execute();
  }
}
