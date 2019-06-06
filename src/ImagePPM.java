import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ImagePPM{

    private int tailleX;
    private int tailleY;
    private int[][] compR;
    private int[][] compV;
    private int[][] compB;
    private int maxval;

    public ImagePPM(String s) throws Exception{
        File file = new File(s);
        Scanner sc = new Scanner(file);


        sc.nextLine();
        tailleX = sc.nextInt();
        tailleY = Integer.parseInt(sc.next());
        compR = new int[tailleX][tailleY];
        compV = new int[tailleX][tailleY];
        compB = new int[tailleX][tailleY];
        maxval = Integer.parseInt(sc.next());

        for(int x=0;x<tailleX;x++){
            for(int y=0;y<tailleY;y++){
                    compR[x][y]=sc.nextInt();
                    compV[x][y]=sc.nextInt();
                    compB[x][y]=sc.nextInt();
            }
            
        }

    }

    public ImagePPM(int tailleX, int tailleY, int maxval){
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.maxval = maxval;
        compR = new int[this.tailleX][this.tailleY];
        compV = new int[this.tailleX][this.tailleY];
        compB = new int[this.tailleX][this.tailleY];
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

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    public void setMaxval(int maxval) {
        this.maxval = maxval;
    }

    public void setCompR(int i, int j, int newVal) {
        this.compR[i][j] = newVal;
    }
    public void setCompV(int i, int j, int newVal) {
        this.compV[i][j] = newVal;
    }
    public void setCompB(int i, int j, int newVal) {
        this.compB[i][j] = newVal;
    }

    public int getCompR(int i, int j) {
        return compR[i][j];
    }
    public int getCompV(int i, int j) {
        return compV[i][j];
    }
    public int getCompB(int i, int j) {
        return compB[i][j];
    }

    public void sauvegarderImage(String fileName) throws IOException {
        FileWriter out = null;
        try{
            out = new FileWriter(fileName);

            out.write("P3\n");
            out.write(this.getTailleX()+" "+this.getTailleY()+"\n");
            out.write((this.getMaxval())+"\n");
            for(int i = 0; i < this.getTailleX(); i++){
                for(int j = 0; j < this.getTailleY(); j++){
                    out.write(this.getCompR(i, j)+" "+this.getCompV(i, j)+" "+this.getCompB(i, j)+"\n");
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
                resultat += new String(compR[i][j]+" "+compV[i][j]+" "+compB[i][j]);
                resultat += "\n";
            }
            
        }

        return resultat;
    }
}