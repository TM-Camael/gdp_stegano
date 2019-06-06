import java.util.Scanner;
public class Main{
        public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int choix = -1;
        int maxval = 0;
        ImagePGM image;
        ImagePPM imageC;
        ImagePGM imageBase;
        String fileName = new String();
        while(choix != 0){
            System.out.println("1. Décrypter une image en noir et blanc`\n2. Décrypter une image en nuances de gris\n3. Crypter une image en noir et blanc\n4. Crypter une image en nuances de gris\n5. Décrypter une image en couleur\n0. Quitter");
            choix = sc.nextInt();
            switch (choix){
                case 0:
                    System.out.println("Programme terminé.");
                    choix = 0;
                    break;
                case 1:
                    System.out.println("Veuilez entrer le nom de l'image à décoder :\n");
                    fileName = sc.next();
                    image = new ImagePGM("./"+fileName);
                    image = Stegano.decrypt(image, 2);
                    System.out.println("Veuillez entrer le nom sous lequel sauvegarder l'image résultat :\n");
                    fileName = sc.next();
                    image.sauvegarderImage("./"+fileName);
                    choix = -1;
                    break;

                case 2 :
                    System.out.println("Veuilez entrer le nom de l'image à décoder\n");
                    fileName = "./"+sc.next();
                    image = new ImagePGM(fileName);
                    System.out.println("Veuillez entrer le nombre de nuances de gris à utiliser\n");
                    maxval = sc.nextInt();
                    image = Stegano.decrypt(image, maxval);
                    System.out.println("Veuillez entrer le nom sous lequel sauvegarder l'image résultat :\n");
                    fileName = "./"+sc.next();
                    image.sauvegarderImage(fileName);
                    choix = -1;
                    break;

                case 3 :
                    System.out.println("Veuilez entrer le nom de l'image à coder\n");
                    fileName = "./"+sc.next();
                    image = new ImagePGM(fileName);
                    System.out.println("Veuillez entrer le nom de l'image de base\n");
                    fileName = "./"+sc.next();
                    imageBase = new ImagePGM(fileName);
                    image = Stegano.encrypt(image, imageBase);
                    System.out.println("Veuillez entrer le nom sous lequel sauvegarder l'image résultat :\n");
                    fileName = "./"+sc.next();
                    image.sauvegarderImage(fileName);
                    choix = -1;
                    break;

                case 4 :
                    System.out.println("Veuilez entrer le nom de l'image à coder\n");
                    fileName = "./"+sc.next();
                    image = new ImagePGM(fileName);
                    System.out.println("Veuillez entrer le nom de l'image de base\n");
                    fileName = "./"+sc.next();
                    imageBase = new ImagePGM(fileName);
                    image = Stegano.encrypt(image, imageBase);
                    System.out.println("Veuillez entrer le nom sous lequel sauvegarder l'image résultat :\n");
                    fileName = "./"+sc.next();
                    image.sauvegarderImage(fileName);
                    choix = -1;
                    break;

                case 5 :
                    System.out.println("Veuilez entrer le nom de l'image à décoder\n");
                    fileName = "./"+sc.next();
                    imageC = new ImagePPM(fileName);
                    System.out.println("Veuillez entrer le nombre de nuances de couleur à utiliser\n");
                    maxval = sc.nextInt();
                    imageC = Stegano.decryptColor(imageC, maxval);
                    System.out.println("Veuillez entrer le nom sous lequel sauvegarder l'image résultat :\n");
                    fileName = "./"+sc.next();
                    imageC.sauvegarderImage(fileName);
                    choix = -1;
                    break;
                
                default :
                    System.out.println("Choix erroné veuillez recommencer.");
                    choix=-1;
                    break;
            }
        }
    }
}
