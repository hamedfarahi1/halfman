package huffman;
import java.io.*;
class FileWR {
    int[] counter=new int[127];
    private static StringBuilder mast=new StringBuilder();
    static StringBuilder getMast(){
        return mast;
    }
    void get(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                int ch,y=0;
                while ((ch = buffer.read()) != 126) {
                    if(ch<126 &&  ch>0) {
                        y++;
                        if (y<11){
                            mast.append((char)ch);
                        }
                        counter[ch]++;
                    }
                }
                buffer.close();
            }else{
                System.out.println(file.getAbsolutePath()+" not exist");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    }

    
