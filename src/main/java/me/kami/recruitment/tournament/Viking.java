package me.kami.recruitment.tournament;

import java.util.ArrayList;

public class Viking extends Humain{

	public Viking() {
		this.setHitPoints(120);
		this.damage=6;
		this.equipement=new ArrayList<String>();
		//on Consider case 0 comme l'arme
		this.equip("axe");
	}
	
	@Override
	public void engage(Humain other) {
		//fait damage
		//on Consider case 0 comme l'arme
		other.getHit(damage, this.equipement.get(0));
		
		selfNbRound+=1;
		
		//Check si other est mort si non alors continue le combat
		if(other.hitPoints()>0) {
			other.engage(this);
		}

	}

	//Gere la logique des degats
	@Override
	protected void getHit(int damage, String arme) {
		if(buckler>0 && selfNbRound%2==0) {
			damage=0;
			if(arme.equals("axe")) {
				buckler-=1;
			}
		}
		setHitPoints(hitPoints()-damage);
		if(hitPoints()<0)
			setHitPoints(0);
	}

	public Viking equip(String equipment) {
		this.equipement.add(equipment);
		//pour eviter le parcours de liste
		switch (equipment) {
		case "buckler":
			buckler=3;
			break;

		default:
			break;
		}
		return this;
	}


}
