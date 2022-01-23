package me.kami.recruitment.tournament;

import java.util.ArrayList;

public class Highlander extends Humain {

	public Highlander() {
		this.setHitPoints(150);
		this.damage=12;
		this.equipement=new ArrayList<String>();
		//on Consider case 0 comme l'arme
		this.equip("GreatSword");
	}
	
	@Override
	public void engage(Humain other) {
		//fait damage
		//on Consider case 0 comme l'arme
		if(selfNbRound%3!=0) {
			other.getHit(damage, this.equipement.get(0));
		}

		//Ici nombre pour representer l'attack rate
		selfNbRound+=1;
		
		//Check si other est mort si non alors continue le combat
		if(other.hitPoints()>0) {
			other.engage(this);
		}

	}

	//Gere la logique des degats
	@Override
	protected void getHit(int damage, String arme) {
		setHitPoints(hitPoints()-damage);
		if(hitPoints()<0)
			setHitPoints(0);
	}

	public Highlander equip(String equipment) {
		this.equipement.add(equipment);
		//pour eviter le parcours de liste
		switch (equipment) {
			default:
				break;
		}
		return this;
	}

}
