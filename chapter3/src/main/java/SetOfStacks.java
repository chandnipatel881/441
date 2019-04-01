import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class SetOfStacks<T> {

    int threshold, totalElements;
    ArrayList<ArrayList<T>> list = new ArrayList<ArrayList<T>>();

    public SetOfStacks(int threshold){
        this.threshold = threshold;
        this.totalElements = 0;
    }

    public void push(T item){
        if(totalElements % threshold == 0){
            list.add(new ArrayList<T>());
        }
        list.get(list.size() - 1).add(item);
        totalElements++;
    }

    public T pop(){
        T lastElement = null;
        if(list.isEmpty()){
            return null;
        }
        int innerListIndex = list.size() - 1;
        int innerListSize = list.get(innerListIndex).size() - 1;

        lastElement = list.get(innerListIndex).get(innerListSize);
        list.get(innerListIndex).remove(innerListSize);

        if(list.get(innerListIndex).isEmpty()){
            list.remove(innerListIndex);
        }
        return lastElement;
    }
}
