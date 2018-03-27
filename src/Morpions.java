/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author SAMANTHA
 */
public class Morpions {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int restart = 0;
        
        while( restart == 0){
            int choix;
            Scanner sc = new Scanner(System.in);
            String[] grille = new String[10];
            for(int i=0; i<grille.length;i++){
                grille[i]= " ";
            }
            int verifResultat;
            System.out.println("|_1_|_2_|_3_|");
            System.out.println("|_4_|_5_|_6_|");
            System.out.println("|_7_|_8_|_9_|");
            do{
                do{
                    System.out.println("\nJoueur 1 choix case: ");
                    choix = sc.nextInt();
                    sc.nextLine();
                }while(verificationChoix(choix, grille) == false);
                grille[choix] = "X";
                afficherGrille(grille);
                verifResultat= verifcationResultat(grille, "X");
                if(verifResultat == 1){
                    System.out.println("Le joueur 1 a gagne");
                    break;
                }else if(verifResultat == 2){
                    System.out.println("Le match est nul !");
                    break;
                }
                do{
                    System.out.println("\nJoueur 2 choix case: ");
                    choix = sc.nextInt();
                    sc.nextLine();
                }while(verificationChoix(choix, grille) == false);
                grille[choix] = "O";
                afficherGrille(grille);
                verifResultat= verifcationResultat(grille, "O");
                if(verifResultat == 1){
                    System.out.println("Le joueur 2 a gagne");
                }else if(verifResultat == 2){
                    System.out.println("Le match est nul !");
                }
            }while(verifResultat != 1);
            String rejouer = "";
            
            while( !"o".equals(rejouer)){
                
                System.out.print("Voulez-vous rejouer (O/N) ? ");
                rejouer = sc.next ();
                if ("o".equals(rejouer)){
                    System.out.println("La partie va recommencer");
                }
                else if("n".equals(rejouer)) {
                    System.out.println("La partie est terminée");
                    System.exit(0);
                }else{
                    System.out.println("Veuillez choisir O ou N !");
                }
            }
            System.out.println();
        }
    }
    
    public static boolean verificationChoix(int choix, String[] grille){
        boolean verification = false;
        if(choix > 0 && choix < 10 && grille[choix].equals(" ")){
            verification = true;
        }
        if(verification == false){
            System.out.println("La case est déja prise !");
        }
        return verification;
    }
    
    public static void afficherGrille(String[] grille){
        String grilleAfficher="\n";
        for(int i = 1; i<grille.length; i++){
            if( i > 0){
                if(i != 3 && i != 6 && i!= 9){
                    grilleAfficher += "_"+grille[i]+"_|";
                }else{
                    grilleAfficher += "_"+grille[i]+"_\n";
                }
            }
        }
        System.out.println(grilleAfficher);
    }
    
    public static int verifcationResultat(String[] grille, String joueur){
        int resultat=0;
        boolean complet=true;
        for(int i=0;i<grille.length;i++){
            if(i>0 && grille[i].equals(" ")){
                complet=false;
                break;
            }
        }
        if(grille[1].equals(joueur) && grille[2].equals(joueur) && grille[3].equals(joueur)){
            resultat=1;
        }else if(grille[1].equals(joueur) && grille[5].equals(joueur) && grille[9].equals(joueur)){
            resultat=1;
        }else if(grille[1].equals(joueur) && grille[4].equals(joueur) && grille[7].equals(joueur)){
            resultat=1;
        }else if(grille[2].equals(joueur) && grille[5].equals(joueur) && grille[8].equals(joueur)){
            resultat=1;
        }else if(grille[3].equals(joueur) && grille[6].equals(joueur) && grille[9].equals(joueur)){
            resultat=1;
        }else if(grille[4].equals(joueur) && grille[5].equals(joueur) && grille[6].equals(joueur)){
            resultat=1;
        }else if(grille[7].equals(joueur) && grille[8].equals(joueur) && grille[9].equals(joueur)){
            resultat=1;
        }else if(grille[7].equals(joueur) && grille[5].equals(joueur) && grille[3].equals(joueur)){
            resultat=1;
        }else if(complet == true){
            resultat=2;
        }
        return resultat;
    }
}
