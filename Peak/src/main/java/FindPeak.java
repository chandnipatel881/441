

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FindPeak {

    public static int findPeakRecursive(ArrayList<Integer> list, int low, int high){

        int middle = (int)Math.ceil((low + high) / 2.0);

        if(low == high){
            return list.get(low);
        }

        if(middle >=0 && list.get(middle) < list.get(middle - 1)){
            return findPeakRecursive(list,low,middle - 1);
        }
        else if(middle < list.size()-1 && list.get(middle) < list.get(middle+1)){
            return findPeakRecursive(list,middle + 1,high);
        }
        else{
            return list.get(middle);
        }
    }


    public static int find1DPeak(ArrayList<Integer> list){
        return findPeakRecursive(list,0,list.size()-1);
    }

    public static void OneDPeak(InputStream file){
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }catch(Exception e){
            System.out.println("File not found");
        }

        ArrayList<Integer> list1 = new ArrayList<Integer>();

        while(scanner.hasNext()){
            list1.add(Integer.parseInt(scanner.next()));
        }

        int peak = find1DPeak(list1);
        System.out.println(peak);
    }

    public static int findMaxInCol(int[][] arr, int rows, int mid){
        int max = 0;
        for (int i = 0; i < rows; i++)
        {
            if (max < arr[i][mid])
            {
                max = arr[i][mid];
            }
        }
        return max;
    }

    public static int findMaxIndex(int[][] arr, int rows, int mid){
        int max_index = 0;
        for (int i = 0; i < rows; i++)
        {
            if (max_index < arr[i][mid])
            {
                max_index = i;
            }
        }
        return max_index;
    }

    public static int find2DPeak(int[][] arr, int rows, int col, int mid){

        int max = findMaxInCol(arr, rows, mid);
        int max_index = findMaxIndex(arr,rows,mid);

        //If we are on the first or last col, maxFromCol is the peak
        if(mid == 0 | mid == col -1){
            return max;
        }

        //If mid column is also peak
        if(max >= arr[max_index][mid + 1] && max >= arr[max_index][mid-1]){
            return max;
        }

        if(max < arr[max_index][mid - 1]){
            return find2DPeak(arr, rows, col, mid - 1);
        }
        else
            return find2DPeak(arr, rows,col,mid+1);
    }


    public static void TwoDPeak(InputStream file){
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }catch(Exception e){
            System.out.println("File not found");
        }

        Integer MATRIX_SIZE = Integer.parseInt(scanner.next());
        int arr[][] = new int[MATRIX_SIZE][MATRIX_SIZE];

        while(scanner.hasNext()){
            for(int i = 0; i < MATRIX_SIZE ; i++){
                for(int j = 0; j < MATRIX_SIZE ; j++){
                    int cost = Integer.parseInt(scanner.next());
                    arr[i][j] = cost;
                }
            }
        }

        for(int i = 0; i < MATRIX_SIZE ; i++){
            for(int j = 0; j < MATRIX_SIZE ; j++){
                System.out.println(i + "," + j + "," + arr[i][j]);
            }
        }

       int peak = find2DPeak(arr, MATRIX_SIZE, MATRIX_SIZE, MATRIX_SIZE/2);
        System.out.println(peak);
    }


    public static void main(String[] args){

        InputStream file = FindPeak.class.getResourceAsStream(args[0]);
        OneDPeak(file);

        InputStream file1 = FindPeak.class.getResourceAsStream(args[1]);
        TwoDPeak(file1);
    }
}
