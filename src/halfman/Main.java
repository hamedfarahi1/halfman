package halfman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TreeCreator m=new TreeCreator();
        Scanner scanner = new Scanner(System.in);
        String input;
        String path="";
        System.out.println("Compressing new txt file : (Enter 'n')");
        System.out.println("Show huffman code of characters : (Enter 's')");
        System.out.println("Extract file : (Enter 'e'");
        while (!(input = scanner.nextLine()).equals("exit")){

            switch (input){
                case "n":
                    m=new TreeCreator();
                    System.out.println("Enter path of file :");
                    path = scanner.nextLine();
                    m.get(path);
                    System.out.println("Huffman Tree creating ...");
                    m.treeCreator();
                    System.out.println("Tree is created !");
                    System.out.println("Creating compressed file ...");
                    m.CreateFile(path);
                    System.out.println("Compressed file is created !");
                    break;
                case "s":
                    int k=0;
                    for (int i=0;i<127;i++){
                        if (m.strings[i]!=null){
                            System.out.print("'"+(char)i+"'" +":"+m.strings[i]+"  ");
                            k++;
                            if (k%10==0)
                                System.out.println();
                        }
                    }
                    break;
                case "e":
                    System.out.println("Extracting file ...");
                    m.Extract();
                    break;
            }
            System.out.println("Compressing new txt file : (Enter 'n')");
            System.out.println("Show huffman code of characters : (Enter 's')");
            System.out.println("Extract file : (Enter 'e'");
        }

    }
}
