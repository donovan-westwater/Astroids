import java.util.ArrayList;

import edu.princeton.cs.algs4.StdDraw;

public class PlayerMissle extends GameObject{
	private Vec2d mytarget;
	private double triggerDist = 25;
	
	private PhyBox p;
	private GfxObject g;
	private GameEngine gE;
	
	
	public PlayerMissle(GfxObject gfx, PhyBox phy, GameEngine gEngine, Vec2d target) {
		super(gfx, phy, gEngine);
		this.mytarget = target;
		p = phy;
		g = gfx;
		gE = gEngine;
		
	}
	//This should be a straight line, coming off the space ship (Player)
	
	//add counter to self denonate after launch DONE
	//Find a way to remove missle when touching player before physics engine updates
	//OR find a design method to find the amound of missles and distnace of missle that wont jossle player!
	//Solidfy after a few frames in update! (TRY THIS OUT)
	public void update () {
		triggerDist -= 1;
		if(this.getpObj().getFrameTime() > 1) {
			this.getpObj().setNonsolid(false);
		}
		if(triggerDist <= 0) {
			this.remove();
			gE.removeDuringFrame(this);
		}
		// we don't need to move, cause phyeng does that
		// we do need to add any fx that we want
		
		//gE.addDuringFrame(t); #Use this for animation/ updating graphical postion of missle

		// we need to see if we reached destination
		// we need to see if we hit some something first Old coder!:distSqrd < (triggerDist*triggerDist)
		
		//Vec2d currentPosition = this.getPhysicsPos();
		//Vec2d subbedVec = Vec2d.subtract(currentPosition, mytarget);
		
		//double distSqrd = Vec2d.dotAB(subbedVec, subbedVec);
		if (this.getlastHit() instanceof GameAsteroid) {
			this.getgEng().getGameMaster().addScore(100);
			this.remove();
			gE.removeDuringFrame(this);
			System.out.println("Hey, I went boom!");
			//gE.lowerMissileCount();
			
		}else if(this.getlastHit() instanceof PlayerPlane) {
			this.remove();
			gE.removeDuringFrame(this);
		}
		}
	
	public void remove() {
		
	}

	public static void main(String[] args){
		double minX = -5.0;
		double minY = -5.0;
		double maxX = 5.0;
		double maxY = 5.0;
		GameEngine gEngine = new GameEngine(minX, minY, maxX, maxY);
		
		PhyBox enemy = new PhyBox(new Vec2d(0.1,-0.1), new Vec2d(-4,0), 0.2, 10);
		GfxCircle gfxEnemy = new GfxCircle(0.2);
		
		PhyBox enemy2 = new PhyBox(new Vec2d(0.1,-0.1), new Vec2d(-3,0), 0.2, 10);
		GfxCircle gfxEnemy2 = new GfxCircle(0.2);
		
		PhyBox city1 = new PhyBox(new Vec2d(0.0, 0.0), new Vec2d(-4.0, -4.0), 0.4, 1000000);
	
		// not really kosher, should be part of game obj system
		
		while(true) {
			gEngine.update();
			
		}
	}
}
