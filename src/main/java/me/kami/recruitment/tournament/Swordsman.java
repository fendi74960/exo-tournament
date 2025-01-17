package me.kami.recruitment.tournament;

import java.util.ArrayList;

public class Swordsman extends Humain {
	
	private int poisonNb=0;
	
	public Swordsman() {
		this.setHitPoints(100);
		this.damage=5;
		this.equipement=new ArrayList<String>();
		//on considere case 0 comme l'arme
		this.equip("sword");
	}
	public Swordsman(String type) {
		this();
		switch (type) {
			case "Vicious":
				this.equipement.set(0, "axe");
				this.damage=6;
				this.poisonNb=2;
				break;
	
			default:
				break;
		}

		
	}
	
	@Override
	public void engage(Humain other) {
		//fait damage
		//on considere case 0 comme l'arme
		if(this.poisonNb>0){
			bonusDamage+=20;
			this.poisonNb-=1;
		}
		other.getHit(damage+bonusDamage, this.equipement.get(0));
		bonusDamage=0;
		
		
		//Check si other est mort si non alors continue le combat
		if(other.hitPoints()>0) {
			other.engage(this);
		}

	}

	//Gere la logique des degats
	@Override
	protected void getHit(int damage,String arme) {
		//Ici equivalent nombre de coup recu pour le bouclier
		
		if(armor) {
			damage-=3;
		}
		if(buckler>0 && selfNbRound%2==0) {
			damage=0;
			System.out.println("block");
			if(arme.equals("axe")) {
				buckler-=1;
			}
		}
		selfNbRound+=1;
		
		
		setHitPoints(hitPoints()-damage);
		if(hitPoints()<0)
			setHitPoints(0);
		
	}

	public Swordsman equip(String equipment) {
		this.equipement.add(equipment);
		//pour eviter le parcours de liste
		switch (equipment) {
			case "buckler":
				buckler=3;
				break;
			case "armor":
				armor=true;
				damage-=1;
				break;
			default:
				break;
		}
		return this;
	}



}
