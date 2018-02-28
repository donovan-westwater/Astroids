import edu.princeton.cs.algs4.StdDraw;
//Need to add missles, use missles from missle command?

public class Player {
	private GameEngine gEng;
	private int launchPause = 5;
	private int movementPause;
	private int missileCount = 3;
	private PlayerPlane actor;
	private boolean active;
	
	
	
	
	public Player(GameEngine gEngine) {
		this.gEng = gEngine;
		this.actor = new PlayerPlane(gEngine);
	}
	public void initializePlayer() {
		int a = 1;
		this.gEng.add(actor);
	}
	public PlayerPlane getActor() {
		return actor;
	}

	
	public void update () {
		// in this game you can launch a missle by 
		// pressing on the mouse key
		// if you have a missile in flight, you can't
		// shoot another missile
		// this.test.setGraphicPosition(new Vec2d(0.0, 0.0));
		// this.test.setMsg(Integer.toString(missileCount));
		//edit launch pause for a better turning speed
		//Create a movement pause for the movement sections seperate from launch pause
		if (launchPause > 0) launchPause -= 1;
		if(movementPause > 0) movementPause -= 1;
		if (movementPause == 0) {
			// the missile comes from a "base"
			// for now the base is the middle screen
			if (StdDraw.isKeyPressed(65)) {
				actor.rotate(0.5);
				//Vec2d target = new Vec2d(-0.5,0);
				//actor.move(target);
				System.out.println("rotate left");
				movementPause = 5;

			}
			if (StdDraw.isKeyPressed(87)) {
				// move forward
				System.out.println("move forward");
				movementPause = 5;
				actor.move();

			}
			if (StdDraw.isKeyPressed(68)) {
				actor.rotate(-0.5);
				//Vec2d target = new Vec2d(0.5,0);
				//actor.move(target);
				System.out.println("rotate right");			
				movementPause = 5;
			}
			
			
			
			if(movementPause > 5) movementPause =5;
			if(actor.gEvents.contains(GameEvent.GameEventFlag.TOUCH)) {
				//Update State goes here? (Most likely goes to gameMaster, try that first)
			}

		}
		if(launchPause == 0) {
			if (launchPause > 15) launchPause = 15;
			if(StdDraw.isKeyPressed(32)) {
				actor.fireMissile(actor.getBearing());
				launchPause = 15;
				
			}
		}
		
		
	}
	public int getMissileCount() {
		return missileCount;
	}
	public void setMissileCount(int missileCount) {
		this.missileCount = missileCount;
	}
}