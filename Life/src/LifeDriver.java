// ANTHONY GIUNTA LifeDriver
import javax.swing.JOptionPane;
public class LifeDriver {

	public static void main(String[] args) {
		
int[][] board1= new int[32][32];
		String answer;
		do {
			String inputr=JOptionPane.showInputDialog("Enter the row of life origin point.");
			int startr=Integer.parseInt(inputr);
			while(startr<1 || startr>30) {
				inputr=JOptionPane.showInputDialog("Error, must be less than or equal to 30 and greater than or equal to 1.");
				startr=Integer.parseInt(inputr);
			}
			String inputc=JOptionPane.showInputDialog("Enter the column of life origin point.");
			int startc=Integer.parseInt(inputc);
			while(startc<1 || startc>30) {
				inputc=JOptionPane.showInputDialog("Error, must be less than or equal to 30 and greater than or equal to 1.");
				startc=Integer.parseInt(inputr);
			}
			board1[startr][startc]=1;
			answer=JOptionPane.showInputDialog("Would you like to enter another point?(Y/N)");
			while(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
				answer=JOptionPane.showInputDialog("Error, respond with Y or N.");
			}
		}while(!answer.equalsIgnoreCase("N"));
		/*
		for(int r=0;r<board1.length;r++) {
			for(int c=0;c<board1[0].length;c++) {
				System.out.print(EasyFormat.format(board1[r][c], 2));
			}
		System.out.println();
		}
		*/
		
		LifeClass game = new LifeClass(board1);
		for(int r=0;r<board1.length;r++) {
			for(int c=0;c<board1[0].length;c++) {
				System.out.print(EasyFormat.format(board1[r][c], 2));
			}
		System.out.println();
		}
		System.out.println(" _______________________________________________________________");
		boolean ext=false;
		int count=0;
		boolean still=false;
		while(ext==false && count<10 && still==false) {
			for(int r=1;r<board1.length-1;r++) {
				for(int c=1;c<board1[1].length-1;c++) {
					if(game.getCell(r, c)==1) {
						game.cellDeath(game.numNeighbors(r, c), r,c);

					}
					else if(game.getCell(r, c)==0) {
						game.cellBirth(game.numNeighbors(r, c),r ,c);
					}
				}
			}
			game.printBoard();
			System.out.println(" _______________________________________________________________");
			count++;
			game.switchGen();
			game.clearBoard();
			ext=game.extinct();	
			still=game.stillLife();
			
		}
		if (ext==true){
			System.out.println("Extinct");
		}
		else if (still==true){
			System.out.println("Still");
		}

	}

}
