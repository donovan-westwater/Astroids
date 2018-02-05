import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.algs4.StdDraw;
//Deal with hitbox size adjustment with the gameobject of astroid!
//Design an actual astroid and draw it out on paper!
public class GfxAstroid extends GfxObject {
	private Color col;
	private double[] xCords = new double[10];
	private double[] yCords = new double[10];
	private Vec2d shift;
	private double[] randWeights = {};
	private double gfxBearing = 0;
	public GfxAstroid(Vec2d spawn){
		this.setGraphicPosition(spawn);
		col = StdDraw.RED;
	}
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
	//Sets up rombus shape, doesnt update yet, grab that code from GfxPlane!
	public void shiftFormat() {
		shift = this.loc; // begins with gfx location
		xCords[0] = 0.5;
		xCords[1] = 1;
		xCords[2] = 1;
		xCords[3] = 0.5;
		xCords[4] = -0.5;
		xCords[5] = -1;
		xCords[6] = -1;
		xCords[7] = -0.5;
		
		yCords[0] = 0.5;
		yCords[1] = 0.25;
		yCords[2] = -0.25;
		yCords[3] = -0.5;
		yCords[4] = -0.5;
		yCords[5] = -0.25;
		yCords[6] = 0.25;
		yCords[7] = 0.5;
		// rotate xCords and rotate yCords
				this.rotate(gfxBearing);
				// translate shape to current center
				
				xCords[0] += shift.getX();
				xCords[1] += shift.getX();
				xCords[2] += shift.getX();
				xCords[3] += shift.getX();
				xCords[4] += shift.getX();
				xCords[5] += shift.getX();
				xCords[6] += shift.getX();
				xCords[7] += shift.getX();
				
				
				yCords[0] += shift.getY();
				yCords[1] += shift.getY();
				yCords[2] += shift.getY();
				yCords[3] += shift.getY();
				yCords[4] += shift.getY();
				yCords[5] += shift.getY();
				yCords[6] += shift.getY();
				yCords[7] += shift.getY();
	}
	void draw() {
		// TODO Auto-generated method stub
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
		StdDraw.line(xCords[1], yCords[1], xCords[2], yCords[2]);
		StdDraw.line(xCords[2], yCords[2], xCords[3], yCords[3]);
		StdDraw.line(xCords[3], yCords[3], xCords[4], yCords[4]);
		StdDraw.line(xCords[4], yCords[4], xCords[5], yCords[5]);
		StdDraw.line(xCords[5], yCords[5], xCords[6], yCords[6]);
		StdDraw.line(xCords[6], yCords[6], xCords[7], yCords[7]);
		StdDraw.line(xCords[7], yCords[7], xCords[0], yCords[0]);
	}

	@Override
	void setGraphicPosition(Vec2d loc2) {
		this.loc = loc2;
		
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		double minX = -5.0;
		double minY = -5.0;
		double maxX = 5.0;
		double maxY = 5.0;
		
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY, maxY);
		
		GfxAstroid test = new GfxAstroid(new Vec2d(0,0));
		
		test.draw();

	}

}
