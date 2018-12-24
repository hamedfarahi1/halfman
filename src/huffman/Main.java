package huffman;
import java.util.Scanner;
public class Main {
    static String pathForCompress;
    public static void main(String[] args) throws InterruptedException {
        TreeCreator m=new TreeCreator();
        Scanner scanner = new Scanner(System.in);
        String input;
        String path;
        menu();
        while (!(input = scanner.nextLine()).equals("exit")){
            switch (input){
                case "n":
                    m=new TreeCreator();
                    menu(1,0);
                    path = scanner.nextLine();
                    m.get(path);
                    menu(2,0);
                    long time = System.currentTimeMillis();
                    m.treeCreator();
                    time = System.currentTimeMillis() - time;
                    menu(3,time);
                    System.out.println("----------------------------------------------------------");
                    System.out.println("             Compressed in: (Enter path)");
                    System.out.println("----------------------------------------------------------");
                    pathForCompress = scanner.nextLine();
                    menu(5,0);
                    time = System.currentTimeMillis();
                    m.CreateFile(path);
                    time = System.currentTimeMillis() - time;
                    menu(4,time);
                    break;
                case "s":
                    showCodes();
                    break;
                case "e":
                    System.out.println("----------------------------------------------------------");
                    System.out.println("    Extracted in your path :  (Enter path of folder");
                    System.out.println("----------------------------------------------------------");
                    path = scanner.nextLine();
                    menu(6,0);
                    time = System.currentTimeMillis();
                    m.Extract(path);
                    time = System.currentTimeMillis() - time;
                    menu(7,time);
                    break;
                case "new":
                    main(args);

            }
            menu();
        }
        TreeCreator.strings=null;
    }
    private static void showCodes() {
        int k=0;
        for (int i=0;i<127;i++){
            if (TreeCreator.strings[i]!=null){
                System.out.print("'"+(char)i+"'" +":"+TreeCreator.strings[i]+"  ");
                k++;
                if (k%10==0)
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
    private static void menu(){
        System.out.println("----------------------------------------------------------");
        System.out.println("               Enter path : (Enter 'n')");
        System.out.println("----------------------------------------------------------");
        System.out.println("      Show huffman code of characters : (Enter 's')");
        System.out.println("----------------------------------------------------------");
        System.out.println("              Extract file : (Enter 'e')");
        System.out.println("----------------------------------------------------------");
        System.out.println("                 Exit : (Enter 'exit')");
        System.out.println("----------------------------------------------------------");
        System.out.println("           Run again for new file (Enter 'new')");
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }
    private static void menu(int option,long time) throws InterruptedException {
        switch (option){
            case 1:
                System.out.println("----------------------------------------------------------");
                System.out.println("               Enter path of file :");
                System.out.println("----------------------------------------------------------");
                System.out.println();
                break;
            case 2:
                System.out.println("----------------------------------------------------------");
                System.out.println("              Huffman Tree creating ...");
                System.out.println("----------------------------------------------------------");
                System.out.println();
                break;
            case 3:
                System.out.println("----------------------------------------------------------");
                System.out.println("          Tree is created ! ("+time+" ms)");
                System.out.println("----------------------------------------------------------");
                System.out.println("             Creating compressed file ...");
                System.out.println("----------------------------------------------------------");
                System.out.println();
                break;
            case 4:
                System.out.println("----------------------------------------------------------");
                System.out.println("      Compressed file is created ! ("+time+" ms)");
                System.out.println("----------------------------------------------------------");
                System.out.println();
                break;
            case 5:
                for (int i=0;i<15;i++){
                    System.out.print(".");
                    Thread.sleep(400);
                }
                break;
            case 6:
                System.out.println("Extracting file ...");
                System.out.println();
                break;
            case 7:
                System.out.println("----------------------------------------------------------");
                System.out.println("          File is Extracted ("+time+" ms)");
                System.out.println("----------------------------------------------------------");
                System.out.println();
        }
    }
}
