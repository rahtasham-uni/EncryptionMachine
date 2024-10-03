package com.construction.assign;
import java.util.Scanner;

/**
* The EncryptionMachine class implements a Caesar cipher for encrypting 
* messages based on a user-defined shift and alphabet. It prompts the user 
* for a key and a message, then encrypts both using the specified shift.
* 
* Assumptions:
* 1. The user will always enter a value of the correct type.
* 2. The user will only ever enter 1 word when asked for the the key and 
*    the next word to encrypt.
* 3. The user will only enter letters in the defined ALPHABET constant 
*    (lower case English letters, by default).
*    
*    @author R.Ahtasham
*/

public class EncryptionMachine {

   public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; 
   public static final int SHIFT = 3; 

 
   public static void main(String[] args) {
    // Create the Scanner object for getting user input.
       Scanner keyboardInput = new Scanner(System.in);
       
       // Call the encryption process method to start encrypting
       encryptionProcess(keyboardInput);
      }

     
/**
* This method encrypts any letter in the alphabet with a shift of three.
* The ALPHABET constant is used for the implementation.
* @param letter The letter to be encrypted.
* @return The encrypted letter as a String.
*/
     public static String encryptSingleLetter(char letter) {
       int index = ALPHABET.indexOf(letter); 
       
       // use % to wrap around if it exceeds the alphabet range.
       int newIndex = (index + SHIFT) % ALPHABET.length(); 
       
       // Calculate new character
       return String.valueOf(ALPHABET.charAt(newIndex)); 
      }

/**
* This method encrypts each letter in the word using encryptSingleLetter method.
* @param word The word to be encrypted.
* @return The encrypted word as a String, where each letter has been shifted.
*/
     public static String encryptWord(String word) {
 	    String encryptedWord = "";
 	    for (int i = 0; i < word.length(); i++) {
 	        char letter = word.charAt(i);
 	        encryptedWord += encryptSingleLetter(letter);
 	    }
 	    return encryptedWord;
 	} 

/**
* This method handles the encryption process.
* It asks the user for a key and a number of words,
* then encrypts the key and each word entered by the user.      
* @param userInput A Scanner object used for obtaining input from the user.
*/
    public static void encryptionProcess(Scanner userInput) {

       //Welcome and informative messages before asking for the key.
    
    System.out.println("Welcome to the Caesar Cipher Encryption Machine!");
       System.out.println("This program allows you to securely encrypt your message using a key. "
        + "Your recipient can then use the same key to decrypt and read the message!");

       // Asking the key. User involvement starts after it.
       System.out.print("Enter key: "); 
       
       String key = userInput.nextLine();
       String encryptedKey = encryptWord(key); 
     
       System.out.println("\"" + key + "\"" + " has been encrypted to: " 
                               + encryptedKey + "\n"); 
       
       // Ask for the number of words in the message. Assumption is user will enter the correct inpu.
       System.out.print("How many words are in your message?: ");
       
       int numWords = userInput.nextInt();
       userInput.nextLine(); 

       // Loop through each word and encrypt it
       for (int i = 0; i < numWords; i++) {
           System.out.print("Next word : " );
           String word = userInput.nextLine();
           String encryptedWord = encryptWord(word); 
           System.out.println("\"" + word + "\"" + " has been encrypted to: " 
                                   + encryptedWord); // Display the encrypted word
           }
       
       // Ending message
       System.out.println("\nMessage fully encrypted. Happy secret messaging!");

     }
    
    /**
    * This method is used to encrypt a fixed single letter, and is created to help
    * gradually build the functionality needed for encryption.
    * Hiding it because will not be used in the program.
    * @return The new letter after encryption of the letter 'a'.
    */
       /* 
       public static char encryptSingleFixedLetter() {
           char letter = 'a'; 
           
           // Calculate the index of the letter in the alphabet (0 for 'a', 1 for 'b', etc.).
           int index = letter - 'a'; 
           
           // use % to wrap around if it goes past 'z'.
           int newIndex = (index + 3) % 26; 
           return (char) ('a' + newIndex); 
          }
        */
  }
