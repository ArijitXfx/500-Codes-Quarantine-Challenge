class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for(String str:strs){
            HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
            for(int i=0;i<str.length();i++){
                if(!tempMap.containsKey(str.charAt(i))){
                    tempMap.put(str.charAt(i),1);
                }else{
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i),x+1);
                }
            }
            if(!map.containsKey(tempMap)){
                map.put(tempMap,new ArrayList<String>());
            }
            map.get(tempMap).add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(HashMap key: map.keySet()){
            List<String> list = map.get(key);
            res.add(list);
        }
        return res;
    }
}