package me.kami.recruitment.tournament;

public class Viking extends Humain{

	public Viking() {
		this.setHitPoints(120);
		this.damage=6;
	}
	
	@Override
	public void engage(Humain other) {
		//fait damage
		other.getHit(damage);
		
		//Check si other est mort si non alors continue le combat
		if(other.hitPoints()>0) {
			other.engage(this);
		}

	}

	//Gere la logique des degats
	@Override
	protected void getHit(int damage) {
		setHitPoints(hitPoints()-damage);
		if(hitPoints()<0)
			setHitPoints(0);
	}

}
