
public class PlayerPlane extends GameObject{
	
	private static GfxCircle sprite;
	private static Vec2d movement = new Vec2d(0,0);
	private static PhyBox hitBox = new PhyBox(new Vec2d(0,-1),movement,1,0);
	public PlayerPlane(GameEngine gEng) {
		super(new GfxCircle(0.5),hitBox,gEng);
		sprite = (GfxCircle)this.getGfxObj();
		// TODO Auto-generated constructor stub
	}
	public void move(Vec2d dir) {
		movement = dir;
	}
}
