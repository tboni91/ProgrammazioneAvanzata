public class Anagrams {
    private String[] allAnagrams;

    Anagrams() {
    }

    public void anagramsFinder (String word, int numberOfAnagrams, int maxNumberOfAnagrams) {
        allAnagrams = new String[maxNumberOfAnagrams];

        long start = System.currentTimeMillis();

        anagramsGenerator("", word);
        print(word, numberOfAnagrams);

        long finish = System.currentTimeMillis();
        long totalTime = finish - start;

        System.out.println("Tempo impiegato: " + totalTime + " ms");
        System.out.println();
    }

    private void anagramsGenerator (String prefix, String word) {
        String anagram;
        if (word.length() <= 1) {
            anagram = prefix + word;
            generate(anagram);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String newPrefix = prefix + word.charAt(i);
                String newWord = word.substring(0, i) + word.substring(i + 1);
                anagramsGenerator(newPrefix, newWord);
            }
        }
    }

    private void generate (String anagram) {
        for (int i=0; i<allAnagrams.length; i++) {
            if (allAnagrams[i] == null) {
                allAnagrams[i] = anagram;
                break;
            }

            if (allAnagrams[i].equals(anagram)) {
                break;
            }
        }
    }

    private String capitalize(String anagram) {
        return anagram.substring(0,1).toUpperCase() + anagram.substring(1);
    }

    private void print(String word, int numberOfAnagrams) {
        System.out.println();
        System.out.println("**********************");
        System.out.println("Gli anagrammi di '" + word + "' sono: ");

        for (int i=0, j=0; ((j < numberOfAnagrams) && (i < allAnagrams.length)); i++) {
            if (!allAnagrams[i].equals(word)) {
                System.out.println("- " + capitalize(allAnagrams[i]));
                j++;
            }
        }

        System.out.println("**********************");
    }
}
