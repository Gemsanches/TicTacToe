package gemsanches.TicTacToe.assets;

import java.util.Scanner;

/**
 * Description
 * @author Guilherme Sanches
 * @version 0.0
 */
public class HashBoard {
//<><> Attributes  <><><><><><><><><><><><><><><><><><><><><><>----------------------------------------------------------------
	private char[] houses = new char[10];
	private Scanner keyReader = new Scanner(System.in);
//<><> Constructors  <><><><><><><><><><><><><><><><><><><><><>----------------------------------------------------------------
	public HashBoard(char XorO) {
		houses[0]=XorO;
		this.reset();
	}
//-------------------------------------------------------------
	public HashBoard() {
		this('X');
	}
//<><> Methods <><><><><><><><><><><><><><><><><><><><><><><><>----------------------------------------------------------------
//<><> Getters | Setters <><>--------------------------------------------------------------------------------------------------
	public char[] getHouses() {return houses;}
	public char getHouse(int i) {return houses[i];}
	public char getTurn() {return getHouse(0);}
//-------------------------------------------------------------
	public void setHouse(int i,char XorO) {this.houses[i]=XorO;}
	public void setTurn(char XorO) {setHouse(0,XorO);}
//<><> Override Methods <><>---------------------------------------------------------------------------------------------------
	@Override
		public String toString() {
			return 	this.houses[0]+" turn"+
					"\n"+this.houses[7]+"|"+this.houses[8]+"|"+this.houses[9]+
					"\n"+"-|-|-"+
					"\n"+this.houses[4]+"|"+this.houses[5]+"|"+this.houses[6]+
					"\n"+"-|-|-"+
					"\n"+this.houses[1]+"|"+this.houses[2]+"|"+this.houses[3];
		}
//<><> Other Methods <><>------------------------------------------------------------------------------------------------------
	public void reset() {
		for (int i = 1; i < this.houses.length; i++) {
			this.houses[i]=(char)(i+48);
		}
	}
//-------------------------------------------------------------
	public boolean emptyHouse(int houseNumber) {
		if(this.houses[houseNumber]!='X' && this.houses[houseNumber]!='O') {
			return true;
		}
		return false;
	}
//-------------------------------------------------------------
	public boolean testVictory() {//call immediately after a move
		if((this.houses[7]==this.houses[8]) && (this.houses[8]==this.houses[9])		//1st line
		 ||(this.houses[4]==this.houses[5]) && (this.houses[5]==this.houses[6])		//2nd line
		 ||(this.houses[1]==this.houses[2]) && (this.houses[2]==this.houses[3])		//3rd line
		 ||(this.houses[7]==this.houses[4]) && (this.houses[4]==this.houses[1])		//1st column
		 ||(this.houses[8]==this.houses[5]) && (this.houses[5]==this.houses[2])		//2nd column
		 ||(this.houses[9]==this.houses[6]) && (this.houses[6]==this.houses[3])		//3rd column
		 ||(this.houses[7]==this.houses[5]) && (this.houses[5]==this.houses[3])		//1st diagonal
		 ||(this.houses[9]==this.houses[5]) && (this.houses[5]==this.houses[1])	){	//2nd diagonal
			return true;
		}
		return false;
	}
//-------------------------------------------------------------	
	public int readValidKey() {
		int keyCode = 0;
		boolean inaccepted = true;
		String key;
		while (inaccepted) {
			System.out.print("Digite o número da casa desejada. ");
			key = keyReader.next();
			keyCode = key.charAt(0);
			if(keyCode>=49 && keyCode<=57) {
				if(this.emptyHouse(keyCode-48)) {
					inaccepted = false;
					
				}else {
					System.out.println("A casa selecionada já está em uso.");
				}
			}
		}
		return keyCode-48;
	}
//-------------------------------------------------------------
	public void closeKeyReader() {
		keyReader.close();
	}
//[END]--------------------------------------------------------
}
