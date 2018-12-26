import javax.xml.soap.Node;
import java.util.Iterator;
import java.util.LinkedList;

public class Sorting {

    public static void insertionSort(int[] arr){

        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    public static int binarySearch(int arr[], int item, int low, int high){
        if(high <= low){
            return (item > arr[low])? (low + 1):low;
        }
        int mid = (low + high)/2;
        if(item == arr[mid]){
            return mid + 1;
        }
        if(item > arr[mid]){
            return binarySearch(arr,item,mid+1, high);
        }
        return binarySearch(arr,item,low, mid -1);
    }

    public static void binaryInsertionSort(int arr[]){
        int n = arr.length;
        for(int i=1; i < n; i++){

            int key = arr[i];
            int j = i-1;

            int loc = binarySearch(arr,key,0,j);
            while(j >= loc){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }

    public static LinkedList<Integer> mergeSortedList(LinkedList<Integer> list1, LinkedList<Integer> list2){
        if(list1 == null || list1.isEmpty()){ return list2; }
        if(list2 == null || list2.isEmpty()) { return list1; }

        LinkedList<Integer> list = new LinkedList<Integer>();
        Iterator iterator1 = list1.iterator();
        Iterator iterator2 = list2.iterator();

        Integer currNode1 = (Integer)iterator1.next();
        Integer currNode2 = (Integer)iterator2.next();

        while(currNode1 != null  && currNode2 != null){
            if(currNode1 < currNode2){
                list.add(currNode1);
                currNode1 = iterator1.hasNext() ? (Integer)iterator1.next() : null;
            }
            else{
                list.add(currNode2);
                currNode2 = iterator2.hasNext() ? (Integer) iterator2.next() : null;
            }
        }
        while (currNode1 != null){
            list.add(currNode1);
            currNode1 = iterator1.hasNext() ? (Integer)iterator1.next() : null;
        }
        while(currNode2 != null){
            list.add(currNode2);
            currNode2 = iterator2.hasNext() ? (Integer)iterator2.next() : null;
        }
        return list;
    }

    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list, int low, int high){
        if(low == high){
            LinkedList<Integer> ll = new LinkedList<Integer>();
            ll.add(list.get(low));
            return ll;
        }
        int mid = (low + high) / 2 ;

            LinkedList<Integer> list1 = mergeSort(list, low, mid);
            LinkedList<Integer> list2 = mergeSort(list, mid + 1, high);

        LinkedList<Integer> result_list = mergeSortedList(list1, list2);
        return result_list;
    }

    public static void main(String[] args){

        int arr[] = {5,6,7,2,1,4,3};

        insertionSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }

        int arr2[] = {3,5,6,2,1,9};
        binaryInsertionSort(arr2);
        System.out.println();
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i]);
        }

        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> list3 = new LinkedList<Integer>();

        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(8);

//        list2.add(2);
//        list2.add(3);
//        list2.add(6);

        System.out.println();
        list3 = mergeSortedList(list1,list2);
        for(Integer i : list3){
            System.out.print(i);
        }
        System.out.println();

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(3);

        list = mergeSort(list, 0, list.size()-1);
        for(Integer i : list){
            System.out.print(i);
        }


    }
}
