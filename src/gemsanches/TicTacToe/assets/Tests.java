package gemsanches.TicTacToe.assets;

public class Tests {

	public static void main(String[] args) {
		HashBoard board = new HashBoard();
		for(int i=0;i<9;i++){
			System.out.println(board+"\n");
			board.setHouse(board.readValidKey(), board.getTurn());
			if(board.testVictory()) {
				System.out.println(board.getTurn()+" venceu!");
				//verifica quem venceu e dá ponto
				break;
			}
			if(board.getTurn()=='X') {
				board.setTurn('O');
			}else {
				board.setTurn('X');
			}
			System.out.println("\n----------------------------------------\n");
		}
		System.out.println(board);
		board.closeKeyReader();
	    
		
	}

}
