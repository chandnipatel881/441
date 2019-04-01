import java.util.*;

public class FrequentCharacter {

    public static class Dummy implements Comparable<Dummy> {
        char character;
        int numberOfOccurence;

        public Dummy(char c, int n) {
            this.character = c;
            this.numberOfOccurence = n;
        }

        public int compareTo(Dummy o) {
            if (this.numberOfOccurence == o.numberOfOccurence) {
                return o.character - this.character;
            }
            return this.numberOfOccurence - o.numberOfOccurence;
        }
    }

    public static char[] findMaxCharacters(HashMap<Character, Integer> map, int n) {

        PriorityQueue<Dummy> heap = new PriorityQueue<Dummy>(n);

        for (Character c : map.keySet()) {
            if (heap.size() < n) {
                heap.add(new Dummy(c, map.get(c)));
            } else if (map.get(c) > heap.peek().numberOfOccurence) {
                heap.poll();
                heap.add(new Dummy(c, map.get(c)));
            }
        }
        char[] maxCharacters = new char[Math.min(map.size(), n)];

        for (int i = 0; i < maxCharacters.length; i++) {
            maxCharacters[i] = heap.poll().character;
        }

        C1Q2.reverseString(maxCharacters);

        return maxCharacters;
    }

    public static String nFreqChar(String str, int n) {
        if (str == null) {
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 0);
            }
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }

        char[] result = findMaxCharacters(map, n);
        StringBuffer resultStr = new StringBuffer();

        for (int i = 0; i < result.length; i++) {
            resultStr.append(result[i]);
        }
        return resultStr.toString();
    }

    //------------------------------------------------------------------------------

    public static char[] findMaxCharacters2(HashMap<Character, Integer> map, int n) {

        List<Map.Entry<Character,Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        Collections.reverse(list);

        char[] result = new char[Math.min(list.size(), n)];

        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    public static String nFreqChar2(String str, int n) {

        if (str == null) {
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 0);
            }
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        char[] result = findMaxCharacters2(map, n);
        StringBuffer resultStr = new StringBuffer();

        for (int i = 0; i < result.length; i++) {
            resultStr.append(result[i]);
        }
        return resultStr.toString();
    }

}
