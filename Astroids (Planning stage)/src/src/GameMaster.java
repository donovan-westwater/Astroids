import java.util.ArrayList;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.Font;
//add asteroid generation system
// make score adjust to screen world size!
public class GameMaster {
	private GfxUI screen;
	private GfxUI replaytext;
	private GfxUI scoretext;
	private GameEngine eng;
	private int score;
	public enum Phase {
		PREGAME, GAME, POSTGAME;
	}
	private int phase = 1;
	private int press_amount = 0;
	private ArrayList<GameObject> phase1;
	private ArrayList<GameObject> phase2;
	private ArrayList<GameObject> phase3;
	private boolean playerDead = false;
	
	public GameMaster(GameEngine tim){
		screen = new GfxUI(new Vec2d(0,0));
		replaytext = new GfxUI(new Vec2d(0, -1.0));
		scoretext = new GfxUI(new Vec2d(-14, 14));
		eng = tim;
		eng.setGameMaster(this);
		this.startPhase1();
		replaytext.setMsg("");
		scoretext.setMsg("");
	}
	public void setDeath(boolean truth) {
		playerDead = truth;
	}
	public void update(){
		if(StdDraw.isKeyPressed(27) && press_amount == 0){
			changePhase(2);
			press_amount += 1;
			this.startPhase2();
		}
		
		
		
		if (phase == 1) {
			screen.setMsg("MISSLE COMMAND!: PRESS 'ESCAPE' TO START!");
		}
		if (phase == 2) {
			StdDraw.setFont();
			scoretext.setMsg("SCORE: " + score);
			//if(num <= 5 ) {
				//This code goes somewhere else, if ran it breaks entire game
				//GameAsteroid aster = new GameAsteroid(this.getgEng());
				//num += 1;
			//}
		}
		if (playerDead && phase == 2) {
			this.startPhase3();
			this.changePhase(3);
		}
		if (phase == 3) {
			if(StdDraw.isKeyPressed(88)) {
				replaytext.setMsg("");
				startPhase2();
			}
		}
	}
		

	
	private void startPhase1(){
		screen.setCenter(new Vec2d(0,0));
		eng.addUI(screen);
		eng.addUI(replaytext);
		eng.addUI(scoretext);
	}
	private void startPhase2(){
		this.changePhase(2);
		double minX = -5.0;
		double minY = -5.0;
		double maxX = 5.0;
		double maxY = 5.0;
		screen.setMsg("");
		scoretext.setMsg("SCORE: " + score);

		Player hansolo = new Player(eng);
		eng.setPlayer(hansolo);
		hansolo.initializePlayer();

		Vec2d[] targets = new Vec2d[9];
		double gutter = 1.0;
		double maxWidth = Math.abs(maxX - minX);
		double targetWidth = maxWidth - gutter;
		double defaultY = -4.0;
		System.out.println("Gutter: " + gutter + " and targetWidth " + targetWidth );

		for (int i = 0; i < targets.length; i++) {
			targets[i] = new Vec2d(minX + gutter/2 + targetWidth * i / (targets.length-1), defaultY);
		}
		// first object into system draws first
		

		PhyBox b1 = new PhyBox(new Vec2d(0.0, 0.0), targets[0], 0.5, 10000000.0);
		PhyBox b2 = new PhyBox(new Vec2d(0.0, 0.0), targets[4], 0.5, 20000000.0);
		PhyBox b3 = new PhyBox(new Vec2d(0.0, 0.0), targets[8], 0.5, 1000000000.0);
		
		
	}
	private void startPhase3(){
		screen.setMsg("GAME OVER");
		replaytext.setMsg("");
		eng.killPlayer();

	}
	private void changePhase(int num){
		phase = num;
	}
	public int getPhase(){
		return phase;
	}
	public void addScore(int pts) {
		this.score = this.score + pts;
	}
}
