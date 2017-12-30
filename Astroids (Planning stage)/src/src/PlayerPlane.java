import java.lang.*;
public class PlayerPlane extends GameObject{
	
	private static GfxCircle sprite = new GfxCircle(1);
	private Vec2d spawn = new Vec2d(0,0);
	private Vec2d movement = new Vec2d(0,0);
	private static PhyBox hitBox = new PhyBox(new Vec2d(0.25,0),new Vec2d(1,-1),1,0);
	public PlayerPlane(GameEngine gEng) {
		super(sprite,hitBox,gEng);
		sprite = (GfxCircle)this.getGfxObj();
		
		// TODO Auto-generated constructor stub
	}
	public Vec2d getMovement() {
		return this.movement;
	}
	
	public double[] getPolarDirection(){
		Vec2d stor = this.getpObj().getDir();
		double answerAngle = Math.atan(stor.getY()/stor.getX());
		double answerRadius = Math.sqrt(Math.pow(stor.getX(),2) + Math.pow(stor.getY(),2));
		double[] answer = {answerRadius, answerAngle};
		return answer;
	}
	//returns the rotatation of the player object when given the angle to rotate by converting vector into polar coordinates
	//Currently set to void
	//Should also only rotate the spirte, might move code from here into moving the future sprite
	//WIP: Doesnt work when stationary
	public void rotate(double angle) {
		double[] polcord = this.getPolarDirection();
		double newAng = angle + polcord[1];
		double radius = polcord[0];
		double storX = Math.cos(newAng) * radius;
		double storY = Math.sin(newAng) * radius;
		Vec2d answer = new Vec2d(storX,storY);
		this.getpObj().setDir(answer);
		//Vec2d answer = new Vec2d(storX,storY);
		//return answer;
		
	}
	//Accelerates player object, should change to only accelerate in correct direction
	public void move(Vec2d dir) {
		
		this.getpObj().setDir(dir);
	}
	public void update() {
		
	}
}
