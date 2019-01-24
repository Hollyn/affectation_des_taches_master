package com.rechercheoperationnelle;

import java.util.ArrayList;
import java.util.Arrays;

public class Arbre implements Comparable<Arbre> {
	protected int id;
	protected Arbre parent;
	protected ArrayList<Arbre> enfants;
	
	/** Constructeurs */
	public Arbre(int i) {
          // a completer
		this.id= i;
		this.parent = null;
		this.enfants = new ArrayList<>();
	}
	
	public Arbre(int i, ArrayList<Arbre> a) {
          // a completer
		this.id = i;
		this.enfants = a;
		this.parent = null;
	}
	
	public Arbre(int i, Arbre[] a) {
          // a completer
		this.id = i;
		this.enfants = (ArrayList<Arbre>) Arrays.asList(a);
	}
	/** Fin constructeurs */
	
	// Une feuille n'a pas d'enfants
	public boolean estFeuille() {
          // a completer
		return  enfants.isEmpty();
	}
	
	// modifier pere
	public boolean ajouteParent(Arbre p) {
          // a completer
		if(parent==null){
			parent= p;
			return true;
		}else{
			System.err.println("Ajoutpent : existe");
			return false;
		}
	}
	
	// Ne rien faire si a est deja un enfant
	public boolean ajouteEnfant(Arbre a) {
          // a completer
		if(!a.ajouteEnfant(this)){
			return false;
		}else{
			return enfants.add(a);
		}
	}

	public int nbEnfants() {
          // a completer
		return enfants.size();
	}
	
	// Le nombre total de noeuds
	public int size() {
          // a completer
		int total =0;
		if(parent==null){
			total+=1;
		}else{
			total += this.nbEnfants();
			if(this.nbEnfants()!=0){
				total += 1;
				for (Arbre a: enfants
				) {
					total+= a.size();
				}
			}

		}
		return total;

	}
	
	@Override
	public int compareTo(Arbre a) {
		// TODO Auto-generated method stub
		if ( id > a.id ) {
			return 1;
		}
		else if ( id < a.id ) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
