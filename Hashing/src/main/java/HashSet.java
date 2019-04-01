public class HashSet<K>{

    private HashMap<K,String> set;

    private HashSet(){
        set = new HashMap<K, String>();
    }

    public void put(K key){
        set.put(key," ");
    }

    public boolean contains(K key){
        String value = set.find(key);
        if(value == null){
            return false;
        }
        return true;
    }

    public boolean remove(K key){
        String value = set.remove(key);
        if(value == null{
            return false;
        }
        return true;
    }
}


