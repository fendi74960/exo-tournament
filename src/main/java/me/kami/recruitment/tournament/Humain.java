package me.kami.recruitment.tournament;

public abstract class Humain {
	private int hitPoints;

	public int hitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	protected int damage;
	
	
	
	public abstract void engage(Humain other);

	protected abstract void getHit(int i);
}
