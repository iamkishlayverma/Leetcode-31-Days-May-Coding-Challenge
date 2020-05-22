class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        int i;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (i=0; i<len; i++) {
            if (freqMap.containsKey(s.charAt(i))) {
                int freq = freqMap.get(s.charAt(i));
                freq++;
                freqMap.put(s.charAt(i), freq);
            } else {
                freqMap.put(s.charAt(i), 1);
            }
        }
        Map<Character, Integer> sortedMap = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character ch1, Character ch2) {
                int ch2Value = freqMap.get(ch2);
                int ch1Value = freqMap.get(ch1);
                if (ch2Value == ch1Value)
                    return ch2Value;
                else
                    return ch2Value - ch1Value;
            }        
        });
        sortedMap.putAll(freqMap);
        String res = "";
        for (Map.Entry<Character, Integer> e : sortedMap.entrySet()) {
            int val = e.getValue();
            while (val != 0) {
                res += e.getKey();
                val--; 
            }
        }
        return res;
    }
}
