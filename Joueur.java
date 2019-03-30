
public class Joueur {
	String nom; 	//nom de joueur
	
	int camps;
	
	int piece[]; 	// la table des piece de joueur avec les position de ces dernier 
					// noir en bas , blanc en haut
	String tab_adr_piece[]= {"Pion","Pion","Pion",
								"Pion","Pion","Pion"
								,"Pion","Pion","Cheval"
								,"Cheval","Fou","Fou"
								,"Tour","Tour","Reine","Roi"};
	public Joueur(String nom,int tabPiece[],int camps)
	{
		 piece=tabPiece;
		 this.nom=nom;
		this.camps=camps;
	}
	
	void affichePiece()
	{
		for(int i=0;i<15;i++)
		{
			System.out.println(tab_adr_piece[i]+" : "+piece[i]/10+","+piece[i]%10);
		}
			
	}
	

}
