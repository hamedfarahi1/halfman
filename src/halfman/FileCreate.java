package halfman;
import java.io.*;

public class FileCreate {

    private String[] strs=new String[127];
    public void setter(String[] str){
        this.strs=str;
    }
    public void Create() {
        try {
            File file = new File("C:\\Users\\hamed\\Desktop\\text.txt");
            File finalFile = new File("C:\\Users\\hamed\\Desktop\\finaltext.hmd");
            if (file.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                FileOutputStream File = new FileOutputStream(finalFile);
                byte[] contentInByte;
                for (int m=0;m<127;m++){
                    if (strs[m]!=null) {
                        char M = (char)m;
                        String string = " ' " + M + " ' " + ": " + strs[m]+"  ";
                        File.write(string.getBytes());

                    }
                }
                File.write(System.getProperty("line.separator").getBytes());
                File.write(System.getProperty("line.separator").getBytes());
                int ch;
                while ((ch=buffer.read()) != 126) {
                   if (ch<127 && ch>0){
                       contentInByte = strs[ch].getBytes();
                       File.write(contentInByte);
                   }
                }
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
}
