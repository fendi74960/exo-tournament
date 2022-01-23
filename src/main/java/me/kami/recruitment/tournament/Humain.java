package me.kami.recruitment.tournament;

import java.util.List;

public abstract class Humain {
	private int hitPoints;
	

	public int hitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	protected int damage;
	protected List<String> equipement;
	protected int selfNbRound=1;
	//compte sa durabilite en meme temps
	protected int buckler=-1;
	
	
	
	public abstract void engage(Humain other);

	protected abstract void getHit(int i, String arme);
}
