import java.io.File;
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
        System.out.println(tailleX);
        tailleY = Integer.parseInt(sc.next());
        System.out.println(tailleY);
        image = new int[tailleX][tailleY];
        maxval = Integer.parseInt(sc.next());
        System.out.println(maxval);

        for(int x=0;x<tailleX;x++){
            for(int y=0;y<tailleY;y++){
                    image[x][y]=Integer.parseInt(sc.next());
            }
        }

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

    public static void main(String[] args) throws Exception {
        ImagePGM image = new ImagePGM("C:\\Users\\Utilisateur\\Desktop\\img\\dahir.pgm");
        System.out.println(image);
    }
}
