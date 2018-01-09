import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;

//direcction desyncs from graphical bearing, fix this by using bearing instead of physic pos to contruct visual
public class GfxPlane extends GfxObject {
	private Color col;
	private double[] xCords = {0,.5,2,2,2.5,2.5};
	private double[] yCords = {0,0.5,0.5,1,1,0};
	private Vec2d shift;
	private double gfxBearing = 0;
	public GfxPlane(Vec2d spawn){
		this.setGraphicPosition(spawn);
		col = StdDraw.RED;
				/*
		xCords[0] = shift.getX() - .2;
		xCords[1] = shift.getX() - .15;
		xCords[2] = shift.getX() + .15;
		xCords[3] = shift.getX() + .15;
		xCords[4] =	shift.getX() + .2;				
		xCords[5] = shift.getX() + .2;
		
		yCords[0] = shift.getY() - .025;
		yCords[1] = shift.getY() + .025;
		yCords[2] = shift.getY() + .025;
		yCords[3] = shift.getY() + .075;
		yCords[4] =	shift.getY() + .075;				
		yCords[5] = shift.getY() - .025;
		*/
		
	}
	public void setGfxbearing(double bearing) {
		this.gfxBearing = bearing;
	}
	public void addGfxbearing(double bearing) {
		this.gfxBearing += bearing;
	}
	//Rotates ship. Intial rotation is from upward postion
	public void rotate(double angle) {
		//This top section might need to be removed
		//this.shiftFormat();
		for(int x = 0; x < xCords.length;x++) {
			double tempX = xCords[x]*Math.cos(angle) - yCords[x]*Math.sin(angle);
			double tempY = yCords[x]*Math.cos(angle) + xCords[x]*Math.sin(angle);
			xCords[x] = tempX;
			yCords[x] = tempY;
			
			
		}
	}
	public void shiftFormat() {
		//This section should incorporate previous shape instead of a rigidly defined one
		shift = this.loc; // begins with gfx location
		xCords[0] = 0.0;
		xCords[1] = 0.5;
		xCords[2] = -0.5;
		xCords[3] = 0.0;
		
		yCords[0] = 0.75;
		yCords[1] = -0.5;
		yCords[2] = -0.5;
		yCords[3] = 0.0;
		
		// rotate xCords and rotate yCords
		this.rotate(gfxBearing);
		// translate shape to current center
		
		xCords[0] += shift.getX();
		xCords[1] += shift.getX();
		xCords[2] += shift.getX();
		xCords[3] += shift.getX();
		
		yCords[0] += shift.getY();
		yCords[1] += shift.getY();
		yCords[2] += shift.getY();
		yCords[3] += shift.getY();
		//Most Recent Addition
		
		
	}//Needs to be able to rotate and draw at the same time!
	//Trying to find way to not have the coords get reset to the initial shape
	public void draw(){
		StdDraw.setPenColor(this.col);
		//this.rotate(5);
		//Add back later
		
		
		// Take the original points
		// Rotate the points relative to the center of the gfx
		// Translate the points to the center position of the gfx in x/y space
		// Draw the set of lines using the rotated, translated points
		// Done
		
		
		this.shiftFormat();

		
		StdDraw.line(xCords[0], yCords[0], xCords[1], yCords[1]);
		StdDraw.line(xCords[1], yCords[1], xCords[3], yCords[3]);
		StdDraw.line(xCords[3], yCords[3], xCords[2], yCords[2]);
		StdDraw.line(xCords[2], yCords[2], xCords[0], yCords[0]);
		
		
	}
	public void scalePlane(double x){
		for(int n = 0; n < xCords.length-1; n++){
			xCords[n] *= x;
			System.out.println(xCords[n]);
		}
		for(int y = 0; y < yCords.length-1; y++){
			yCords[y] *= x;
			System.out.println(yCords[y]);
		}
	}

	public void setGraphicPosition(Vec2d loc2) {
		// TODO Auto-generated method stub
		this.loc = loc2;
		
	}
	public void setColor(Color c) {
		col = c;
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		double minX = -1.0;
		double minY = -1.0;
		double maxX = 1.0;
		double maxY = 1.0;
		
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY, maxY);
		
		GfxPlane test = new GfxPlane(new Vec2d(0,0));
		
		test.scalePlane(15);
		test.setGfxbearing(Math.PI/2);
		test.draw();

	}
	
	

}
