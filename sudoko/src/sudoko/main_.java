package sudoko;

public class main_ {
	
	public static void main(String[] args) {
		board ab = new board();
		//ab.create();
		//ab.print2();
		method1 m1 = new method1(ab.ints);
		
		play(ab, m1);
		
	}
	
	static void play(board a, method1 m) {
		while (!a.checkComplete()) {
			for(int i=1; i<=9;i++) {
				m.findnPut(i);
			}
		}
		System.out.println("You WIN!");
	}
	
}
