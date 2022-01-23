package me.kami.recruitment.tournament;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	protected int selfNbRound=0;
	//compte sa durabilite en meme temps
	protected int buckler=-1;
	protected boolean armor=false;
	protected int attackRate;
	protected int bonusDamage=0;
	
	
	
	public abstract void engage(Humain other);

	protected abstract void getHit(int i, String arme);
}
