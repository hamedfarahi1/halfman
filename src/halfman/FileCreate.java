package halfman;
import java.io.*;
import java.math.BigInteger;

public class FileCreate {
    public String[] strs=new String[127];
    public void setter(String[] str){
        this.strs=str;
    }
    public void Create(String path) {
        try {
            File file = new File(path);
            File finalFile = new File("C:\\Users\\hamed\\Desktop\\huffmanfiles\\binaryResult.hmd");
            File CodeFile = new File("C:\\Users\\hamed\\Desktop\\huffmanfiles\\codefile.cod");
            BufferedWriter codefile = new BufferedWriter(new FileWriter(CodeFile));
            if (file.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                FileOutputStream File = new FileOutputStream(finalFile);
                int ch;
                String string="";
                //kole matn ro peymayesh mikone bad jaye har harf kodesho mizare va to string save mikone
                while ((ch=buffer.read()) != 126) {
                   if (ch<127 && ch>0){
                       string+=strs[ch];
                   }
                }
                byte[] Total = new BigInteger(string,2).toByteArray();
                File.write(Total);
                for (int m=0;m<127;m++){
                    if (strs[m]!=null) {
                        char M = (char)m;
                        String str = strs[m] +"~" + M;
                        codefile.write(str);
                    }
                }
                codefile.write("#");
                codefile.close();
                File.close();
            }
            else{
                System.out.println(file.getAbsolutePath()+" not exist");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void ExtractFile(){
        DeCode decode=new DeCode();
        try {
            decode.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            decode.searchAndWrite(strs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
