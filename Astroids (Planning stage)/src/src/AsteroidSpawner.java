//ALL WIP IN PROGRESS (SEE GAME ENGINE AND GAME MASTER startPhase2 for references)
public class AsteroidSpawner {
	private GameEngine gEng;
	private int num = 0;
	
	public AsteroidSpawner(GameEngine eng) {
		gEng = eng;
	}
	public void spawn() {
		if(num < 1) {
			GameAsteroid ast = new GameAsteroid(gEng);
			//ast.randSpawn();
			this.gEng.addDuringFrame(ast);
			System.out.println("spawned?");
			num += 1;
		}
	}
	//FIX ME
	public void checkDead() {
		int count = 0;
		for(GameObject item : gEng.getgObjs()) {
			if(item instanceof GameAsteroid) {
				count += 1;
			}
			//System.out.println("Here is the count: "+count);
		}
		//Should respawn asteroids but doesnt work atm [FIX ME]
		if(count < num) {
			//num -= 1;
		}
		//System.out.println("THE NUMBER IS: "+num);
	}

	public void update() {
		this.spawn();
		this.checkDead();
		// TODO Auto-generated method stub
		
	}
	
	
}
