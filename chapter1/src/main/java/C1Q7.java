import java.util.HashSet;

public class C1Q7 {

    public static void zeroMatrix(int[][] matrix){
        if(matrix == null){
            return;
        }
        int N = matrix.length;
        int M = matrix[0].length;

        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(Integer i : rowSet){
            for(int j = 0; j < M; j++){
                matrix[i][j] = 0;
            }
        }

        for(Integer j : colSet){
            for(int i = 0; i < N; i++){
                matrix[i][j] = 0;
            }
        }

    }
}
