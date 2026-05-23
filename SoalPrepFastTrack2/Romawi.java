package SoalPrepFastTrack2;

import java.util.HashMap;

public class Romawi {

    private HashMap<Character, Integer> map;

    public Romawi() {
        this.map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
    }

    public int getNumericValue(String rome) throws InvalidRomeNumberException {

        if (rome.matches("-d|[^IVXCL]")) {
            throw new InvalidRomeNumberException(rome);
        }

        char[] romeChars = rome.toCharArray();
        int total = 0;

        for (char chars: romeChars){
            total += this.map.get(chars);
        }

        return total;

    }
    
}
