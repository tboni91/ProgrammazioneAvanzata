import java.util.Scanner;

class Main {
    private static int numberOfAnagrams;
    private static int numberOfPermutations;
    private static String inputWord = "";

    public static void main(String[] args) {

        if (args.length == 1) {
            numberOfAnagrams = Integer.parseInt(args[0]);
        }

        Scanner scanner = new Scanner(System.in);

        while (!inputWord.equals("0")) {
            Anagrams anagrams = new Anagrams();

            System.out.print("*** Inserire parola di almeno 3 caratteri [inserire 0 per uscire]: ");
            inputWord = scanner.nextLine().toLowerCase();

            if (inputWord.equals("0")) {
                continue;
            } else if (inputWord.isEmpty()) {
                System.out.println("Nessuna parola inserita!");
            } else if (inputWord.length() < 3) {
                System.out.println("Parola troppo corta!");
            } else {
                numberOfPermutations = maxNumberOfPermutations(inputWord);

                if (numberOfAnagrams == 0) {
                    System.out.print("*** Inserire numero di anagrammi desiderati"
                            + "[tra 1 e " + (numberOfPermutations-1) + "]: ");
                    numberOfAnagrams = Integer.parseInt(scanner.nextLine());

                    if (numberOfAnagrams < 1) {
                        System.out.println("Numero inserito nullo o negativo!");
                        continue;
                    }
                }

                if (numberOfAnagrams >= numberOfPermutations) {
                    System.out.println("*** Il numero di anagrammi inserito è"
                            + " maggiore del numero massimo di anagrammi generabili.");
                    System.out.println("*** Verranno mostrati "
                            + (numberOfPermutations-1) + " anagrammi!");
                    anagrams.anagramsFinder(inputWord, numberOfPermutations, numberOfPermutations);
                } else {
                    anagrams.anagramsFinder(inputWord, numberOfAnagrams, numberOfPermutations);
                }
            }
        }
        scanner.close();
    }

    private static int factorial (int num) {
        int fact = 1;
        for (int i=1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    private static int maxNumberOfPermutations (String word) {
        int numberOfAnagrams;
        int length = word.length();
        char[] wordInLetters = word.toCharArray();
        String temp = "" + wordInLetters[0];

        for (int i=1; i<length; i++) {
            if (!isRepeated(wordInLetters[i], temp)) {
                temp = temp + wordInLetters[i];
            }
        }

        char[] singleLetters = temp.toCharArray();
        int[] reps = new int[singleLetters.length];

        for (int i=0; i<singleLetters.length; i++) {
            for (int j=0; j<length; j++) {
                if (singleLetters[i] == wordInLetters[j]) {
                    reps[i]++;
                }
            }
        }

        numberOfAnagrams = factorial(word.length());
        for (int i=0; i<reps.length; i++) {
            numberOfAnagrams = numberOfAnagrams / factorial(reps[i]);
        }

        return numberOfAnagrams;
    }

    private static boolean isRepeated (char letter, String singleLetters) {
        for (int i=0; i<singleLetters.length(); i++) {
            if (letter == singleLetters.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}