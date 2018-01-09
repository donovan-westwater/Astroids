import java.awt.Color;
import java.lang.*;
public class PlayerPlane extends GameObject{
	//Not using bearing for direction
	//not warning physics engine
	
	
	private Vec2d spawn = new Vec2d(0,0);
	private Vec2d movement = new Vec2d(0,0);
	private Vec2d bearing = new Vec2d(0,0.25);
	private double polAngle = this.getPolarDirection()[1];
	private static PhyBox hitBox = new PhyBox(new Vec2d(0,0.25),new Vec2d(1,-1),1,0);
	private static GfxPlane sprite = new GfxPlane(hitBox.getLoc());
	public PlayerPlane(GameEngine gEng) {
		super(sprite,hitBox,gEng);
		sprite = (GfxPlane)this.getGfxObj();
		
		// TODO Auto-generated constructor stub
	}
	public Vec2d getBearing() {
		return this.bearing;
	}
	public void setBearing(Vec2d newDir) {
		System.out.println("Break here");
		this.bearing = newDir;
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
		System.out.println("Rotating");
		double[] polcord = this.getPolarDirection();
		double newAng = polAngle + angle;
		polAngle = newAng;
		System.out.println(polAngle);
		double radius = polcord[0];
		double storX = Math.cos(newAng) * radius;
		double storY = Math.sin(newAng) * radius;
		Vec2d answer = new Vec2d(storX,storY);
		this.setBearing(answer);
		System.out.println("Bearing: " + storX + " " + storY);
		//This is the part that is broken
		System.out.println(polAngle);
		sprite.setGfxbearing(polAngle+(3*Math.PI/2));
		//Vec2d answer = new Vec2d(storX,storY);
		//return answer;
		 
	}
	//Accelerates player object, should change to only accelerate in correct direction
	public void move() {
		System.out.println("Direction in move(): " + this.getpObj().getDir().getX()+" "+this.getpObj().getDir().getY());
		this.getpObj().setDir(this.getBearing());
		System.out.println("Bearing in Move(): "+ this.getBearing().getX()+" "+this.getBearing().getY());
	}
	public void update() {
		
	}
}
