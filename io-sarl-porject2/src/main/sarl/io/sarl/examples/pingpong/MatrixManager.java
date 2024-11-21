package io.sarl.examples.pingpong;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixManager {
	private static ConcurrentMatrix matrix;

    public static void initializeMatrix(int rows, int cols) {
        if (matrix == null) {
            matrix = new ConcurrentMatrix(rows, cols);
         
            Random random = new Random();

            for (int i = 0; i < rows; i++) {
	             for (int j = 0; j < cols; j++) {
	            	 
	                 int randomProdcut = random.nextInt(10,100);
	                 int randomProdcut2 = random.nextInt(100,200);
	                 
	            	 matrix.writeCell(i,1,randomProdcut);
	            	 matrix.writeCell(i,0,i+1);
	            	 matrix.writeCell(i, 2, randomProdcut2);
	             }
	         }
        }
    }

    public static ConcurrentMatrix getMatrix() {
        return matrix;
    }
}
