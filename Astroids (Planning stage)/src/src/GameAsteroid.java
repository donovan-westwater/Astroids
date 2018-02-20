//add rotation and add randomized spawning
public class GameAsteroid extends GameObject {
	private static Vec2d spawn = new Vec2d(3,0);
	private static Vec2d movement = new Vec2d(0,-0.25);
private static PhyBox hitbox = new PhyBox(movement,spawn,2,10);
private static GfxAstroid sprite = new GfxAstroid(hitbox.getLoc());
	public GameAsteroid(GameEngine gEngine) {
		super(sprite, hitbox, gEngine);
		//Adds itself to the game engine its built with
		this.getgEng().add(this);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void updateEvents() {
		if (gEvents == null) return;
		for (GameEvent ge : gEvents) {
			if (ge.getFlag() == GameEvent.GameEventFlag.TOUCH) {
		        if(this.getlastHit() instanceof PlayerMissle) {
		        	this.setActive(false);
		        }
				
				//add score here!
			}
		}
		gEvents.clear();
		
	}
}
