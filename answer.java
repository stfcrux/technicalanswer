static String isValid(String s) {
        
        if ((s.length() == 0) || (s == null)){
            return "YES";
        }
        
        // contains frequency of each character of given string input
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        
        for (char x: s.toCharArray()){
            
            if (charFreq.containsKey(x)){
                
                charFreq.put(x, charFreq.get(x)+1);
            }
            
            else {
                charFreq.put(x, 1);
            }
            
        }
        
        // contains frequency of each frequency type
        HashMap<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
        
        for (int i: charFreq.values()){
            
            if (freqCount.containsKey(i)){
                
                freqCount.put(i, freqCount.get(i)+1);
            }
            
            else {
                freqCount.put(i, 1);
            }
            
        } 
        
        if( freqCount.size() == 1){
            return "YES";
        }
        else if( freqCount.size() > 2){
            return "NO";
        }
        
        
        else{
            
            // geting the most common count of freq count
            int valid_freq = Collections.max(freqCount.entrySet(), Map.Entry.comparingByValue()).getKey();
            
            // checker to check if anything is deleted yet
            int deleted = 0;
            
            
            // going through each character frequency to see if that character 
            // can be deleted to fit the answer
            for (int y: charFreq.values())
            { 
                
                if( y != valid_freq){
                    
                    
                    if(deleted == 0){
                        if( y - 1 == valid_freq || y - 1 == 0){
                            deleted += 1;
                        }
                        else{
                            return "NO";
                        }
                    }
                    else{
                         return "NO";
                    }
                }
            }        
        
        return "YES";

    }
