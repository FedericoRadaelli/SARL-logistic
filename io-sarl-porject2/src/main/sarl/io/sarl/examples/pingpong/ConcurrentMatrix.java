package io.sarl.examples.pingpong;

	
	 import java.util.concurrent.locks.Lock;
	 import java.util.concurrent.locks.ReentrantLock;

	 public class ConcurrentMatrix {
	     private final int[][] matrix;      // La matrice condivisa
	     private final Lock[][] locks;     // Array di lock per ogni cella della matrice

	     public ConcurrentMatrix(int rows, int cols) {
	         matrix = new int[rows][cols];
	         locks = new ReentrantLock[rows][cols];
	         
	         // Inizializziamo i lock per ogni cella della matrice
	         for (int i = 0; i < rows; i++) {
	             for (int j = 0; j < cols; j++) {
	                 locks[i][j] = new ReentrantLock();
	             }
	         }
	     }

	     // Metodo per scrivere un valore in una cella della matrice
	     public void writeCell(int row, int col, int value) {
	         Lock lock = locks[row][col]; // Prendi il lock associato alla cella
	         lock.lock(); // Blocca il lock
	         try {
	             //System.out.println(Thread.currentThread().getName() + " sta scrivendo " + value + " in [" + row + "][" + col + "]");
	             matrix[row][col] = value; // Scrivi nella matrice
	         } finally {
	             lock.unlock(); // Rilascia il lock
	         }
	     }

	     // Metodo per leggere un valore dalla cella della matrice
	     public int readCell(int row, int col) {
	         Lock lock = locks[row][col]; // Prendi il lock associato alla cella
	         lock.lock(); // Blocca il lock
	         try {
	             //System.out.println(Thread.currentThread().getName() + " sta leggendo [" + row + "][" + col + "]");
	             return (int) matrix[row][col]; // Leggi dalla matrice
	         } finally {
	             lock.unlock(); // Rilascia il lock
	         }
	     }

	     // Metodo per stampare l'intera matrice (opzionale, sincronizzato per evitare condizioni di concorrenza)
	     public synchronized void printMatrix() {
	    	 System.out.println("Prodotti | Quantitá | Prezzo");
	         for (int[] row : matrix) {
	             for (int val : row) {
	                 System.out.print("   " + "[" + val + "]" + "    ");
	             }
	             System.out.println();
	         }
	     }
	 }
