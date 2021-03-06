import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ImagePGM{

    private int tailleX;
    private int tailleY;
    private int[][] image;
    private int maxval;

    public ImagePGM(String s) throws Exception{
        File file = new File(s);
        Scanner sc = new Scanner(file);

        sc.nextLine();
        tailleX = sc.nextInt();
        tailleY = Integer.parseInt(sc.next());
        image = new int[tailleX][tailleY];
        maxval = Integer.parseInt(sc.next());

        for(int x=0;x<tailleX;x++){
            for(int y=0;y<tailleY;y++){
                    image[x][y]=Integer.parseInt(sc.next());
            }
        }

    }

    public ImagePGM(int tailleX, int tailleY, int maxval){
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.maxval = maxval;
        image = new int[this.tailleX][this.tailleY];
    }

    public int getTailleX() {
        return tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public int getMaxval() {
        return maxval;
    }

    public int getPixel(int i, int j){
        return image[i][j];
    }

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    public void setMaxval(int maxval) {
        this.maxval = maxval;
    }


    public void setPixel(int i, int j, int newVal) {
        this.image[i][j] = newVal;
    }

    public void sauvegarderImage(String fileName) throws IOException {
        FileWriter out = null;
        try{
            out = new FileWriter(fileName);

            out.write("P2\n");
            out.write(this.getTailleX()+" "+this.getTailleY()+"\n");
            out.write((this.getMaxval())+"\n");
            for(int i = 0; i < this.getTailleX(); i++){
                for(int j = 0; j < this.getTailleY(); j++){
                    out.write(this.getPixel(i, j)+"\n");
                }
            }
        } finally {
            out.close();
        }

    }

    @Override
    public String toString() {
        String resultat = new String();
        resultat += new String(tailleX+" "+tailleY+" "+maxval+"\n");
        for(int i = 0; i<tailleX; i++){
            for(int j =0; j<tailleY; j++) {
                resultat += new String(image[i][j]+" ");
            }
            resultat += "\n";
        }

        return resultat;
    }
}
