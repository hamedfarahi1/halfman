package halfman;
import java.io.*;
public class FileWR {
    public int[] counter=new int[127];
    public void get() {
        try {
            File file = new File("C:\\Users\\hamed\\Desktop\\text.txt");
            if (file.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                int ch;
                while ((ch = buffer.read()) != 126) {
                    if(ch<126 &&  ch>0) {
                        counter[ch]++;
                    }
                }
            }else{
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

    
