public class Stegano{

    public static ImagePGM decrypt(ImagePGM imgCrypte, int valmax)  {
        
        ImagePGM imgDecrypte = new ImagePGM(imgCrypte.getTailleX(), imgCrypte.getTailleY(), valmax);
        for(int i = 0; i < imgCrypte.getTailleX(); i++){
            for(int j = 0; j < imgCrypte.getTailleY(); j++){
                imgDecrypte.setPixel(i, j, imgCrypte.getPixel(i, j)%valmax);
            }
        }
        imgDecrypte.setMaxval(valmax-1);
        return imgDecrypte;
    }

    public static ImagePPM decryptColor(ImagePPM imgCrypte, int valmax)  {
        
        ImagePPM imgDecrypte = new ImagePPM(imgCrypte.getTailleX(), imgCrypte.getTailleY(), valmax);
        for(int i = 0; i < imgCrypte.getTailleX(); i++){
            for(int j = 0; j < imgCrypte.getTailleY(); j++){
                imgDecrypte.setCompR(i, j, imgCrypte.getCompR(i, j)%valmax);
                imgDecrypte.setCompV(i, j, imgCrypte.getCompV(i, j)%valmax);
                imgDecrypte.setCompB(i, j, imgCrypte.getCompB(i, j)%valmax);
            }
        }
        imgDecrypte.setMaxval(valmax-1);
        return imgDecrypte;
    }

    public static ImagePGM encrypt(ImagePGM imageCible, ImagePGM conteneur) {
        ImagePGM resultat = new ImagePGM(conteneur.getTailleX(), conteneur.getTailleY(), conteneur.getMaxval());

        for(int i = 0; i < conteneur.getTailleX(); i++){
            for(int j = 0; j<conteneur.getTailleY(); j++){
                
                int pixelACoder= imageCible.getPixel(i, j);
                int ajustementPixel = Math.abs(pixelACoder - conteneur.getPixel(i,j)%(imageCible.getMaxval()+1));
                
                if(ajustementPixel !=0){
                    if(conteneur.getPixel(i,j)+ajustementPixel<=resultat.getMaxval()){
                        resultat.setPixel(i, j, conteneur.getPixel(i,j)+ajustementPixel);
                    }
                    else{
                        resultat.setPixel(i, j, conteneur.getPixel(i,j)-(imageCible.getMaxval()+1)+ajustementPixel);
                    }
                }
                else{
                    resultat.setPixel(i,j, conteneur.getPixel(i,j));
                }
            }
        }
        return resultat;
    }
}