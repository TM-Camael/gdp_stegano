import java.io.*;

public class Stegano{

    public void decrypt(ImagePGM imgCrypte) throws IOException {
        
        ImagePGM imgDecrypte = new ImagePGM(imgCrypte.getTailleX(), imgCrypte.getTailleY(), imgCrypte.getMaxval());
        FileWriter out;
        for(int i = 0; i < imgCrypte.getTailleX(); i++){
            for(int j = 0; j < imgCrypte.getTailleY(); j++){
                if(imgCrypte.getPixel(i, j)%2 == 0){
                    imgDecrypte.setPixel(i, j, 0);
                }
                else{
                    imgDecrypte.setPixel(i, j, 1);
                }
            }
        }

        out = null;

        try{
            out = new FileWriter("imageDecrypte.pgm");

            out.write("P2\n");
            out.write(imgDecrypte.getTailleX()+" "+imgDecrypte.getTailleY()+"\n");       
            out.write("1\n");
            for(int i = 0; i < imgDecrypte.getTailleX(); i++){
                for(int j = 0; j < imgDecrypte.getTailleY(); j++){
                    out.write(String.valueOf(imgDecrypte.getPixel(i, j))+"\n");
                }
            }
        } finally {
            out.close();
        }



    }
}