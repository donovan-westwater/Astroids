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
		//Make this a project constant in gameEngine
		double minX= -15;
		double minY = -15;
		double maxY = 15;
		double maxX = 15;
		//Detrimines rand spawn (spawns at the edge of the map)
		double randX;
		double randY;
		double quad = Math.random() - 0.5;
		if(quad > 0.25) {
			randY = maxY -1 ;
			randX = (30*Math.random()) - 15;
		}else if(quad > 0 && 0.25 > quad) {
			randX = maxX - 1;
			randY = (30*Math.random()) - 15;
		}else if(quad > -0.25 && 0.25 > quad) {
			randY = minY + 1;
			randX = (30*Math.random()) - 15;
		}else {
			randX = minX + 1;
			randY = (30*Math.random()) - 15;
		}
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
