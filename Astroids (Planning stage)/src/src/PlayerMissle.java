import java.util.ArrayList;

import edu.princeton.cs.algs4.StdDraw;

public class PlayerMissle extends GameObject{
	private Vec2d mytarget;
	private double triggerDist = 0.1;
	
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
	

	public void update () {
		// we don't need to move, cause phyeng does that
		// we do need to add any fx that we want
		
		//gE.addDuringFrame(t); #Use this for animation/ updating graphical postion of missle

		// we need to see if we reached destination
		// we need to see if we hit some something first
		Vec2d currentPosition = this.getPhysicsPos();
		Vec2d subbedVec = Vec2d.subtract(currentPosition, mytarget);
		
		double distSqrd = Vec2d.dotAB(subbedVec, subbedVec);
		if (distSqrd < (triggerDist*triggerDist)) {
			this.remove();
			gE.removeDuringFrame(this);
			System.out.println("Hey, I went boom!");
			gE.lowerMissileCount();
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
