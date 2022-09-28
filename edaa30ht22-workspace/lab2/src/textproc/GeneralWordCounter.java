package textproc;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException;

public class GeneralWordCounter implements TextProcessor {
    private Set s;
    private  Map<String, Integer> m;
    public GeneralWordCounter(Set s) throws FileNotFoundException{
        m = new HashMap<>();
        this.s = s;
    }

    @Override
    public void process(String w) {
        if(!s.contains(w)) {
            if(m.containsKey(w)) {
                m.put(w, m.get(w)+1);
            }
            else {
                m.put(w, 1);
            }
        }
        
    }

    @Override
    public void report() {
        for(String key : m.keySet()){
            if(m.get(key) >= 200){
                System.out.println(key + " " + m.get(key));
            }
        }
    }
    
}
