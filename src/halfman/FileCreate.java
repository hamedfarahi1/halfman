package halfman;

import java.io.*;

public class FileCreate extends TreeCreator{
    public void Create() {
        try {
            File file = new File("C:\\Users\\hamed\\Desktop\\text.txt");
            File finalFile = new File("C:\\Users\\hamed\\Desktop\\finaltext.txt");
            if (file.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                BufferedWriter Buffer = new BufferedWriter(new FileWriter(finalFile));
                int ch;
                while ((ch = buffer.read()) != 126) {
                    if(ch<126 &&  ch>0) {

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
