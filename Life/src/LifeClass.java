// ANTHONY GIUNTA LifeClass
public class LifeClass {
	private int [][] currentgen = new int[32][32];
	private int [][] nextgen = new int [32][32];
	public LifeClass() {
		for(int r=0;r<currentgen.length;r++) {
			for(int c=0;c<currentgen[0].length;c++) {
				currentgen[r][c]=3;
				nextgen[r][c]=3;
			}
		}
	}
	public LifeClass(int[][] board) {
		currentgen=board.clone();
	}
	public int numNeighbors(int row, int col) {
		int neighbors=0;
		for (int r=row-1;r<=row+1;r++) {
			for(int c=col-1;c<=col+1;c++) {
				if((!(r==row && c==col)) && currentgen[r][c]==1) {
					neighbors++;
				}
			}
		}
		return neighbors;
	}
	public int getCell(int row, int col) {
		return currentgen[row][col];
	}
	public void cellBirth(int neighbors, int row, int col) {
		if(currentgen[row][col]==0) {
			if(neighbors==3) {
				nextgen[row][col]=1;
			}
		}
	}
	public void cellDeath(int neighbors, int row, int col) {
		if(currentgen[row][col]==1) {
			if(neighbors>=4 || neighbors<=1) {
				nextgen[row][col]=0;
			}
			else {
				nextgen[row][col]=1;
			}
		}
	}
	public boolean stillLife() {
		for(int r=0;r<currentgen.length;r++) {
			for(int c=0;c<currentgen[0].length;c++) {
				if (currentgen[r][c]!=nextgen[r][c])
					return false;
			}
		}
		return true;
	}
	public boolean extinct() {
		for(int r=0;r<currentgen.length;r++) {
			for(int c=0;c<currentgen[0].length;c++) {
				if(currentgen[r][c]==1) {
					return false;
				}
			}
		}
		return true;
	}
	public void switchGen() {
		for(int r=0;r<nextgen.length;r++) {
			for(int c=0;c<nextgen[0].length;c++) {
				currentgen[r][c]=nextgen[r][c];
			}
		}
	}
	public void printBoard() {
		for(int r=0;r<nextgen.length;r++) {
			for(int c=0;c<nextgen[0].length;c++) {
				System.out.print(EasyFormat.format(nextgen[r][c], 2));
			}
		System.out.println();
		}

	}
	public void clearBoard() {
		for(int r=0;r<nextgen.length;r++) {
			for(int c=0;c<nextgen[0].length;c++) {
				nextgen[r][c]=0;
			}
		}
		/*
		for(int r=0;r<currentgen.length;r++) {
			for(int c=0;c<currentgen[0].length;c++) {
				currentgen[r][c]=0;
				*/
			}
			
		}
