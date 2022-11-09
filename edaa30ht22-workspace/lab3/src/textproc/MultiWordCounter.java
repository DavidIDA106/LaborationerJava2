package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor{
    private Map<String, Integer> m = new TreeMap<>();
    public MultiWordCounter(String[] words) {
        for(int i=0; i<words.length; i++) {
            m.put(words[i], 0);
        }
    }

    public void process(String w) {
        if(m.containsKey(w)) {
            m.put(w, m.get(w)+1);
        }
        
    }

    public void report() {
        for(String key: m.keySet()) {
            System.out.println(key + " " + m.get(key));
        }
        
    }
    
}
