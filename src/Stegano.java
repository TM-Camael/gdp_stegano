import java.io.*;
import java.util.Scanner;

public class Stegano{

    public void decrypt(ImagePGM imgCrypte, int valmax) throws IOException {
        
        ImagePGM imgDecrypte = new ImagePGM(imgCrypte.getTailleX(), imgCrypte.getTailleY(), imgCrypte.getMaxval());
        FileWriter out;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < imgCrypte.getTailleX(); i++){
            for(int j = 0; j < imgCrypte.getTailleY(); j++){
                imgDecrypte.setPixel(i, j, imgCrypte.getPixel(i, j)%valmax);
            }
        }

        out = null;
        System.out.println("Entrez le nom du fichier à sauvegarder :");
        String fileName = sc.nextLine();

        try{
            out = new FileWriter(fileName);

            out.write("P2\n");
            out.write(imgDecrypte.getTailleX()+" "+imgDecrypte.getTailleY()+"\n");       
            out.write((valmax-1)+"\n");
            for(int i = 0; i < imgDecrypte.getTailleX(); i++){
                for(int j = 0; j < imgDecrypte.getTailleY(); j++){
                    out.write(String.valueOf(imgDecrypte.getPixel(i, j))+"\n");
                }
            }
        } finally {
            out.close();
        }
    }

    public void encrypt(ImagePGM imageCible, ImagePGM conteneur) throws IOException {
        Scanner sc = new Scanner(System.in);
        ImagePGM resultat = new ImagePGM(conteneur.getTailleX(), conteneur.getTailleY(), conteneur.getMaxval());
        FileWriter out;

        for(int i = 0; i < conteneur.getTailleX(); i++){
            for(int j = 0; j<conteneur.getTailleY(); j++){
                
                int pixelACoder= imageCible.getPixel(i, j);
                int ajustementPixel = Math.abs(pixelACoder - conteneur.getPixel(i,j)%imageCible.getMaxval());
                if(ajustementPixel !=0){
                    if(conteneur.getPixel(i,j)+ajustementPixel<=resultat.getMaxval()){
                        resultat.setPixel(i, j, conteneur.getPixel(i,j)+ajustementPixel);
                    }
                    else{
                        resultat.setPixel(i, j, conteneur.getPixel(i,j)-imageCible.getMaxval()+ajustementPixel);
                    }
                    }
            }
        }

        out = null;
        String fileName = sc.nextLine();

        try{
            out = new FileWriter(fileName);

            out.write("P2\n");
            out.write(conteneur.getTailleX()+" "+conteneur.getTailleY()+"\n");
            out.write("255\n");
            for(int i = 0; i < conteneur.getTailleX(); i++){
                for(int j = 0; j < conteneur.getTailleY(); j++){
                    out.write(String.valueOf(conteneur.getPixel(i, j))+"\n");
                }
            }
        } finally {
            out.close();
        }
    }
}