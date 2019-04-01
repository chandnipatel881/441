import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q7Test {

    @Test
    public void testZeroMatrix() {

        int[][] matrix = {{1,2,3,0},
                          {0,3,3,1}};

        C1Q7.zeroMatrix(matrix);

        int[][] updatedMatrix = {{0,0,0,0},
                                 {0,0,0,0}};

        assertEquals(matrix, updatedMatrix);
    }
}