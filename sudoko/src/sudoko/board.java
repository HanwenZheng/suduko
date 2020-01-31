package sudoko;

import java.util.Arrays;
import java.util.Scanner;

public class board {
	
	//int[][] ints = new int[9][9];
	int[][] ints = {
	{0,7,0,0,0,4,1,3,0},
	{0,0,0,2,0,7,0,0,6},
	{0,0,5,0,1,3,0,2,0},
	{0,0,1,0,0,2,0,0,0},
	{0,0,2,1,9,0,0,5,7},
	{0,0,3,0,4,5,8,0,2},
	{0,1,0,3,7,8,2,6,0},
	{3,6,7,0,0,0,5,8,0},
	{8,0,9,0,0,1,0,7,0}
	};
	
	void create() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Start creating board...");
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				System.out.printf("Enter %d/%d:",i+1,j+1);
				ints[i][j] = sc.nextInt();
			}
		}
		sc.close();

	}
	
	void clear() {
		Arrays.fill(ints, 0);
	}
	
	void set(int i, int j, int z) {
		ints[i-1][j-1] = z;
	}
	
	boolean checkComplete() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (ints[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	void print() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				System.out.printf(" %d  ",ints[i][j]);
			}
			if (i!=8) {
				System.out.println();
				for(int p=0;p<8;p++) {
					System.out.print(" - +");
				}
				System.out.println(" - ");
			}
		}
		
	}
	
	void print2() {
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (ints[i][j]!=99) {
					if (ints[i][j]==0) {
						System.out.printf("  ");
					}
					else System.out.printf("%d ",ints[i][j]);
				}
				else System.out.printf("X ");
				if ((j+1)%3 == 0 && j!= 8) {
					System.out.print("| ");
				}
			}
			System.out.println();
			if ((i+1)%3 == 0 && i!=8) {
				System.out.println("      +       +");
			}
		}
		System.out.println();
	}
	

}
