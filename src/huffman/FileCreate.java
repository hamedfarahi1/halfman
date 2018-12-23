package huffman;
import java.io.*;
import java.math.BigInteger;

class FileCreate {
    private String[] strs=new String[127];
    void setter(String[] str){
        this.strs=str;
    }
    void Create(String path) {
        try {
            File file = new File(path);
            File finalFile = new File("C:\\Users\\hamed\\Desktop\\huffmanfiles\\binaryResult.hmd");
            File CodeFile = new File("C:\\Users\\hamed\\Desktop\\huffmanfiles\\codefile.cod");
            BufferedWriter codefile = new BufferedWriter(new FileWriter(CodeFile));
            if (file.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                FileOutputStream File = new FileOutputStream(finalFile);
                int ch;
                StringBuilder string= new StringBuilder();
                //kole matn ro peymayesh mikone bad jaye har harf kodesho mizare va to string save mikone
                while ((ch=buffer.read()) != 36) {
                   if (ch<127 && ch>0){
                       if (strs[ch]!=null)
                       string.append(strs[ch]);
                   }
                }
                byte[] Total = new BigInteger(string.toString(),2).toByteArray();
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    void ExtractFile(){
        DeCode decode=new DeCode();
        try {
            decode.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            decode.searchAndWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
