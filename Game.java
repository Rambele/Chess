import java.util.*;
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int pieceNoir[]={21,22,23,24,25,26,27,28,
						12,17,13,16,11,18,15,14};
		int pieceBlanc[]= {71,72,73,74,75,76,77,78,
						 82,87,83,86,81,88,85,84};
		Joueur p1 =new Joueur("Rambel",pieceBlanc,1);
		Joueur p2 =new Joueur("Rambel2",pieceNoir,0);
	
		Echiquier e=new Echiquier("Rambel","Wiza");
		System.out.println(e.coupValablePion(e.joueur1,22,32));
		e.Move(e.joueur1, 22, 32);
		e.afficheEchiquier();
		System.out.println(e.coupValablePion(e.joueur1,32,43));
		
	}

}
