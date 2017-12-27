
public class PlayerPlane extends GameObject{
	
	private static GfxCircle sprite = new GfxCircle(1);
	private Vec2d spawn = new Vec2d(0,0);
	private Vec2d movement = new Vec2d(0,0);
	private static PhyBox hitBox = new PhyBox(new Vec2d(0,0),new Vec2d(0,-1),1,0);
	public PlayerPlane(GameEngine gEng) {
		super(sprite,hitBox,gEng);
		sprite = (GfxCircle)this.getGfxObj();
		// TODO Auto-generated constructor stub
	}
	public Vec2d getMovement() {
		return this.movement;
	}
	public void move(Vec2d dir) {
		this.getpObj().setDir(dir);
	}
	public void update() {
		
	}
}
