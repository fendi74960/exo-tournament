package me.kami.recruitment.tournament;

import java.util.ArrayList;

public class Highlander extends Humain {

	float berserkThreshold;
	public Highlander() {
		this.setHitPoints(150);
		this.damage=12;
		this.equipement=new ArrayList<String>();
		//on Consider case 0 comme l'arme
		this.equip("GreatSword");
	}
	
	public Highlander(String type) {
		this();
		switch (type) {
		case "Veteran":
			this.berserkThreshold=0.3f;
			break;

		default:
			break;
		}

		
	}
	
	@Override
	public void engage(Humain other) {

		//fait damage
		//on Consider case 0 comme l'arme
		if(this.hitPoints()<berserkThreshold*150){
			bonusDamage+=damage;
		}
		//Ici nombre pour representer l'attack rate
		selfNbRound+=1;

		if(selfNbRound%3!=0) {
			other.getHit(damage+bonusDamage, this.equipement.get(0));
		}
		bonusDamage=0;

		
		
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
