import edu.princeton.cs.algs4.StdDraw;

public class GameEngineTest {
	//Collsion needs some work
	public static void drawVector(Vec2d vec){
		StdDraw.line(0.0, 0.0, vec.getX(), vec.getY());
	}
	public static void main(String[] args) {
		double minX = -5.0;
		double minY = -5.0;
		double maxX = 5.0;
		double maxY = 5.0;
		PhyBox test = new PhyBox(new Vec2d(0,-0.5),new Vec2d(0,0),1,0);
		GfxCircle drawing = new GfxCircle(1);
		
		
		// set the scale of the coordinate system
		
		GameEngine gEngine = new GameEngine(minX, minY, maxX, maxY);
		GameMaster joke = new GameMaster(gEngine);
		GameObjectBox binding = new GameObjectBox(drawing,test,gEngine);
		GameAsteroid test1 = new GameAsteroid(gEngine);
		//gEngine.add(binding);
		
		while(true) {
			gEngine.update();
		
		}
	}
}
