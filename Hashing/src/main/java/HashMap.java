import java.util.ArrayList;


public class HashMap<K,V> {

    public static class HashNode<K,V> {

        K key;
        V value;
        boolean isDeleted;

        public HashNode(K key, V value, boolean isDeleted){
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }

    }

    //bucketArray to store HashNode
    private HashNode<K,V>[] bucketArray;

    public static final double MAX_RATIO = 0.7;
    public static final int INITIAL_CAPACITY = 10;

    //size of the table
    private int size;

    //Constructor of HashMap
    public HashMap(){
        bucketArray = (HashNode<K,V>[]) new HashNode[INITIAL_CAPACITY];
        size = 0;
    }

    public double getLoadRatio(){
        return (double)this.size/this.bucketArray.length;
    }

    public int getIndex(K key){
        if(key == null){
            return 0;
        }
        return key.hashCode()%bucketArray.length;
    }

    //Insert method
    public void put(K key, V value){

        double num = getLoadRatio();

        if(num > MAX_RATIO){
            rehash();
        }
        int index = getIndex(key);

        // 1) If the slot is already occupied, collision has occured
        // 2) If the slot isn't deleted already
        // 3) if keys are not same, go to next available slot (linear probing)
        while(bucketArray[index] != null && !bucketArray[index].isDeleted && key != bucketArray[index].key){
            index = (index + 1) % bucketArray.length;
        }
        if(bucketArray[index] == null || bucketArray[index].isDeleted){
            this.size++;
        }
        bucketArray[index] = new HashNode<K, V>(key, value, false);
    }

    public void rehash(){

        HashNode<K,V>[] temp = bucketArray;
        bucketArray = (HashNode<K,V>[]) new HashNode[bucketArray.length * 2];

        size = 0;
        for(int i = 0; i < temp.length; i++){
            if(temp[i] != null && !temp[i].isDeleted){
                 this.put(temp[i].key,temp[i].value);
            }
        }

    }

    //Helper function to get the index of the value to find or delete
    public int getIndexOfValue(K key){
        int index = getIndex(key);

        while(bucketArray[index] != null){
            if(bucketArray[index].key == key && !bucketArray[index].isDeleted){
                return index;
            }
            index = (index + 1) % bucketArray.length;
        }
        return -1;
    }

    public V find(K key){

        int index = getIndexOfValue(key);
        if (index >= 0){
            return bucketArray[index].value;
        }
        return null;
    }

    public V remove(K key){

        int index = getIndexOfValue(key);
        if(index >= 0){
            V value = bucketArray[index].value;
            bucketArray[index].isDeleted = true;
            this.size--;
            return value;
        }
        return null;

    }

}
