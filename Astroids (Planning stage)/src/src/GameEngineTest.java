import edu.princeton.cs.algs4.StdDraw;

public class GameEngineTest {
	
	public static void drawVector(Vec2d vec){
		StdDraw.line(0.0, 0.0, vec.getX(), vec.getY());
	}
	public static void main(String[] args) {
		double minX = -5.0;
		double minY = -5.0;
		double maxX = 5.0;
		double maxY = 5.0;
		
		// set the scale of the coordinate system
		
		GameEngine gEngine = new GameEngine(minX, minY, maxX, maxY);
		
		while(true) {
			gEngine.update();
		
		}
	}
}
