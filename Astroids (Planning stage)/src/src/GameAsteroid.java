//add rotation and add randomized spawning
//Move asteroid spawn from Test to GameMaster
public class GameAsteroid extends GameObject {
	private static Vec2d spawn = new Vec2d(0.3,0);
	private double speed = 0.25;
	private boolean death  = false;
	private Vec2d movement = new Vec2d(0,-0.25);
	private PhyBox hitbox;
	private GfxAstroid sprite;
	
	public GameAsteroid(GameEngine gEngine) {
		super(new GfxAstroid(new Vec2d(0.3,0)), new PhyBox(new Vec2d(0,-0.25),spawn,2,10), gEngine);
		randSpawn();
		hitbox = (PhyBox)this.getpObj();
		sprite = (GfxAstroid)this.getGfxObj();
		//System.out.println("SPAWN IS: "+randX+ " "+randY);
		//Adds itself to the game engine its built with
		//this.getgEng().addDuringFrame(this);
		// TODO Auto-generated constructor stub
	}
	public void randSpawn() {
		double minX= -15;
		double minY = -15;
		double maxY = 15;
		double maxX = 15;
		double randX = (Math.random() - 0.5);
		 randX = (randX > 0) ? randX + (maxX-1) : randX + (minX+1); 
		double randY = Math.random()-0.5;
		 randY = (randY > 0) ? randY + (maxY-1) : randY + (minY+1);
		 Vec2d loc = new Vec2d(randX,randY);
		this.getpObj().setLoc(loc);
		
		Vec2d direction = Vec2d.subtract(new Vec2d(0,0), loc);
		//Might make a randomized target
		direction = Vec2d.getUnitVec(direction);
		direction = Vec2d.scaledVector(direction, speed);
		movement  = direction;
		this.getpObj().setDir(movement);
	}
	public boolean isDeath() {
		return death;
	}
	
	public void update() {
	
	}
	@Override
	public void updateEvents() {
		if (gEvents == null) return;
		for (GameEvent ge : gEvents) {
			if (ge.getFlag() == GameEvent.GameEventFlag.TOUCH) {
		        if(this.getlastHit() instanceof PlayerMissle) {
		        	this.setActive(false);
		        	this.getgEng().removeDuringFrame(this);
		        	this.remove();
		        	death = true;
		        	
		        	
		        }
				
				//add score here!
			}
		}
		gEvents.clear();
		
	}
}
