
public class Echiquier {
		private int pieceBlanc[]={21,22,23,24,25,26,27,28,
			12,17,13,16,11,18,15,14};
		
		private int pieceNoir[]= {71,72,73,74,75,76,77,78,
			 82,87,83,86,81,88,85,84};
		
		int quiJoue=1;
		
		Joueur joueur1;
		Joueur joueur2;
		
		public Echiquier(String nomJ1,String nomJ2)
		{
			joueur1=new Joueur(nomJ1,pieceBlanc,1);
			joueur2=new Joueur(nomJ2,pieceNoir,-1);

		}
		
		
		/*Cherche si la position se trouve dans la table piece et revoi
		 * l'indice correspondant a la position retourne i-1, -1 sinon */
		
		public int seTrouveIci(int position,int tabPiece[])
		{
			int i=0;
			boolean trouve=false;
			while(i<16 && !trouve)
			{
				if(tabPiece[i]==position)
					trouve=true;
				i++;
			}
			if(i==16 && !trouve)
				return -1;
			else 
				return i-1;
		}
		
		/*Regarde si la position se trouve dans la table piece*/
		
		public boolean seTrouve(int position,int tabPiece[])
		{
			int i=0;
			boolean trouve=false;
			while(i<16 && !trouve)
			{
				if(tabPiece[i]==position)
					trouve=true;
				i++;
			}
			return trouve;
		}
		
		/*Regarde si un joueur a le doit de jouer de "a" a "b" Etape1*/
		
		public boolean coupValable(Joueur j,int a,int b)
		{
			return (j.camps==quiJoue && seTrouve(a,j.piece) && (!seTrouve(b,j.piece)));
		}
		
		/*Ragarde si un Pion en "a" a le droit d'aller a "b"*/
		
		public boolean coupValablePion(Joueur j,int a,int b)
		{
			int xa,ya,xb,yb;
			xa=a/10;ya=a%10;xb=b/10;yb=b%10;
			if(j.camps==1 && xa==2)
				return (((xb-xa)==1 ||(xb-xa)==2)  && yb==ya);
			else if(j.camps==-1 && xa==7)
				return (((xb-xa)==-1 ||(xb-xa)==-2)  && yb==ya);
			else
			return ((xb-xa)==j.camps && yb==ya);
		}
		
		/*Method qui bouge la une piece de "a" a "b"*/
		
		public void Move(Joueur j,int pos1,int pos2)
		{
			if(coupValable(j,pos1,pos2))
			{
				j.piece[seTrouveIci(pos1,j.piece)]=pos2;
			}
		}
		
		/*Methode qui affiche la table de jeu*/
		public void afficheEchiquier()
		{
			int i,j,pose,type,typeNoir,typeBlanc;
			for(i=1;i<=8;i++)
			{
				for(j=1;j<=8;j++)
				{
					pose=i*10+j;
					typeBlanc=seTrouveIci(pose,joueur1.piece);
					typeNoir=seTrouveIci(pose,joueur2.piece);
					if(typeBlanc>typeNoir)
						type=typeBlanc;
					else if(typeBlanc<typeNoir)
						type=typeNoir;
					else 
						type=-1;
					if(type>=0 && type<=9)
						System.out.print(type+" |");
					else if(type>9)
						System.out.print(type+"|");
					else
						System.out.print("**|");
				}
				System.out.println("");

			}
		}
		
		/*Methode qui test le debordement*/
		public boolean estValide(int pos2)
        {  
            int x1=pos2%10,x2=pos2/10;
            return !((x1<1)||(x2>8)||(x2<1)||(x1>8));
        }
		
}
