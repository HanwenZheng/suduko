package sudoko;

public class method1 {
	int ints[][];
	int copy[][] = new int[9][9];
	
	method1(int[][] ints){
		this.ints = ints;
	}
	
	boolean findnPut(int a) {
		boolean success = false;
		for(int i=0; i<ints.length; i++)
			  for(int j=0; j<ints[i].length; j++)
			    copy[i][j]=ints[i][j];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (ints[i][j] == a) {
					mark(i,j);
				}
			}
		}
		for (int i=0; i<9; i=i+3) {
			for (int j=0; j<9; j=j+3) {
				int count = 0;
				int lastX = 9;
				int lastY = 9;
				for(int x=0; x<3; x++) {
					for(int y=0; y<3; y++) {
						if (copy[i+x][j+y]==0) {
							count++;
							lastX = i+x;
							lastY = j+y;
						}
					}
				}
				if (count ==1) {
					ints[lastX][lastY] = a; print2();
					success = true;
				}
			}
		}
		return success;
	}


	void mark(int i, int j) {
		for (int x=0; x<9; x++) {
			if (copy[i][x]==0) {
				copy[i][x]=99; //print2();
			}
			if (copy[x][j]==0) {
				copy[x][j]=99; //print2();
			}
		}
		i = (i/3)*3;
		j = (j/3)*3;
		for (int x=i; x<i+3;x++) {
			for (int y=j; y<j+3;y++) {
				if (copy[x][y]==0) {
					copy[x][y]=99; //print2();
				}
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