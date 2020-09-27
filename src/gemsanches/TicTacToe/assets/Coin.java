package gemsanches.TicTacToe.assets;

/**
 * Description
 * @author Guilherme Sanches
 * @version 0.0
 */
public class Coin {
//<><> Attributes  <><><><><><><><><><><><><><><><><><><><><><>----------------------------------------------------------------
	private String faceUp = "head";
//<><> Constructors  <><><><><><><><><><><><><><><><><><><><><>----------------------------------------------------------------
//<><> Methods <><><><><><><><><><><><><><><><><><><><><><><><>----------------------------------------------------------------
//<><> Getters | Setters <><>--------------------------------------------------------------------------------------------------
	public String getFaceUp() {return faceUp;}
//<><> Override Methods <><>---------------------------------------------------------------------------------------------------
	@Override
		public String toString() {return "This coin is facing "+this.faceUp+" up.";}
//<><> Other Methods <><>------------------------------------------------------------------------------------------------------
	public void flip() {
		if (this.faceUp=="head") {this.faceUp="tail";return;}
		if (this.faceUp=="tail") {this.faceUp="head";return;}
	}
	public String toss() {
		if( (Math.round(Math.random()*99))%2==0 ) {
			this.faceUp="tail";
		}else {
			this.faceUp="head";
		}
		return faceUp;
	}
	public boolean tossFor(String headOrTail) {
		this.toss();
		return this.isFacing(headOrTail);
	}
	public String facing() {return faceUp;}
	public boolean isFacing(String headOrTail) {return this.faceUp==headOrTail;}
	public boolean isTail() {return this.isFacing("tail");}
	public boolean isHead() {return this.isFacing("head");}
//--[END]----------------------------------------------------------------------------------------------------------------------
}