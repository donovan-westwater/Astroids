//add rotation and add randomized spawning
public class GameAsteroid extends GameObject {
	private static Vec2d spawn = new Vec2d(3,0);
	private static Vec2d movement = new Vec2d(0,-0.25);
private static PhyBox hitbox = new PhyBox(movement,spawn,2,0);
private static GfxAstroid sprite = new GfxAstroid(hitbox.getLoc());
	public GameAsteroid(GameEngine gEngine) {
		super(sprite, hitbox, gEngine);
		//Adds itself to the game engine its built with
		this.getgEng().add(this);
		// TODO Auto-generated constructor stub
	}

}
