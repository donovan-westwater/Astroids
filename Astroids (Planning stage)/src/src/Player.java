import edu.princeton.cs.algs4.StdDraw;

public class Player {
	private GameEngine gEng;
	private int launchPause = 5;
	private int missileCount = 3;
	private PlayerPlane actor;
	private boolean active;
	//Make seprate game object for physics and GFX!!!
	
	
	
	public Player(GameEngine gEngine) {
		this.gEng = gEngine;
		actor = new PlayerPlane(gEngine);
	}
	public void initializePlayer() {
		// 
		int a = 1;
		this.gEng.add(actor);
	}
	
	public void update () {
		// in this game you can launch a missle by 
		// pressing on the mouse key
		// if you have a missile in flight, you can't
		// shoot another missile
		// this.test.setGraphicPosition(new Vec2d(0.0, 0.0));
		// this.test.setMsg(Integer.toString(missileCount));
		if (launchPause > 0) launchPause -= 1;
		if (launchPause == 0) {
			// the missile comes from a "base"
			// for now the base is the middle screen
			if (StdDraw.isKeyPressed(65)) {
				Vec2d target = new Vec2d(-0.5,0);
				actor.move(target);
				System.out.println("Firing left");
				launchPause = 5;

			}
			if (StdDraw.isKeyPressed(83)) {
				
				System.out.println("Firing center");
				launchPause = 5;

			}
			if (StdDraw.isKeyPressed(68)) {
				Vec2d target = new Vec2d(0.5,0);
				actor.move(target);
				System.out.println("Firing right");			
				launchPause = 5;
			}
			if (launchPause > 5) launchPause = 5;

		}
		
		
	}
	public int getMissileCount() {
		return missileCount;
	}
	public void setMissileCount(int missileCount) {
		this.missileCount = missileCount;
	}
}