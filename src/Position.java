
public class Position {
	private int x;
	private int y;
	
	public Position(int d, int e) {
		this.x = d;
		this.y = e;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isInBoard(Board b) {
		int boardSize = Chess.BOARD_SIZE * Chess.SQUARE_SIZE;
		if (x >= 0 && x < boardSize && y >= 0 && y < boardSize) {
			System.out.println("isInBoard true");
			return true;
		} else {
			System.out.println("isInBoard false");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
