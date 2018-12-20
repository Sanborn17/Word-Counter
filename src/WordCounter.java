public class WordCounter {
    public int WordCount(String phrase) {
        int ans;

        if (phrase == null || phrase.isEmpty()) {
            ans = 0;
        } else {
            String[] words = phrase.split("\\s+");
            ans = words.length;
        }

        return ans;
    }
}
