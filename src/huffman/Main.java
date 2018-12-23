package huffman;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TreeCreator m=new TreeCreator();
        Scanner scanner = new Scanner(System.in);
        String input;
        String path="";
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
                    menu(5,0);
                    System.out.println();
                    time = System.currentTimeMillis();
                    m.CreateFile(path);
                    time = System.currentTimeMillis() - time;
                    menu(4,time);
                    break;
                case "s":
                    showCodes();
                    break;
                case "e":
                    menu(6,0);
                    time = System.currentTimeMillis();
                    m.Extract();
                    time = System.currentTimeMillis() - time;
                    menu(7,time);
                    break;
                case "show":

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
    }
    private static void menu(){
        System.out.println("----------------------------------------------------------");
        System.out.println("         Compressing new txt file : (Enter 'n')");
        System.out.println("----------------------------------------------------------");
        System.out.println("      Show huffman code of characters : (Enter 's')");
        System.out.println("----------------------------------------------------------");
        System.out.println("              Extract file : (Enter 'e')");
        System.out.println("----------------------------------------------------------");
        System.out.println("                 Exit : (Enter 'exit')");
        System.out.println("----------------------------------------------------------");
    }
    private static void menu(int option,long time) throws InterruptedException {
        switch (option){
            case 1:
                System.out.println("----------------------------------------------------------");
                System.out.println("               Enter path of file :");
                System.out.println("----------------------------------------------------------");
                break;
            case 2:
                System.out.println("----------------------------------------------------------");
                System.out.println("              Huffman Tree creating ...");
                System.out.println("----------------------------------------------------------");
                break;
            case 3:
                System.out.println("----------------------------------------------------------");
                System.out.println("          Tree is created ! ("+time+" ms)");
                System.out.println("----------------------------------------------------------");
                System.out.println("             Creating compressed file ...");
                System.out.println("----------------------------------------------------------");
                break;
            case 4:
                System.out.println("----------------------------------------------------------");
                System.out.println("      Compressed file is created ! ("+time+" ms)");
                System.out.println("----------------------------------------------------------");
                break;
            case 5:
                for (int i=0;i<15;i++){
                    System.out.print(".");
                    Thread.sleep(400);
                }
                break;
            case 6:
                System.out.println("Extracting file ...");
                break;
            case 7:
                System.out.println("----------------------------------------------------------");
                System.out.println("          File is Extracted ("+time+" ms)");
                System.out.println("----------------------------------------------------------");
        }
    }
}
