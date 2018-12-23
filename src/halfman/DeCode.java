package halfman;
import java.io.*;


public class DeCode {
    public String mod = "";
    private String[] codes = new String[127];
    public void read() throws IOException {
        File fileStream = new File("C:\\Users\\hamed\\Desktop\\huffmanfiles\\binaryResult.hmd");
        FileInputStream fileInputStream = new FileInputStream(fileStream);
        byte[] bytes = fileInputStream.readAllBytes();
        int i = 1;
        while (i < bytes.length) {
            ConvertToBinary(bytes[i]);
            i++;
        }
        fileInputStream.close();
    }
    private void getCode() throws IOException {
        File file = new File("C:\\Users\\hAmed\\Desktop\\huffmanfiles\\codefile.cod");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String Code="";
        char code;
        while (true){
            code =(char) bufferedReader.read();
            if (code=='#')break;
            if (code=='~'){
                codes[bufferedReader.read()]=Code;
                Code="";
                code =(char) bufferedReader.read();
                if (code=='#')break;
            }
            Code=Code+code;
        }
    }
    public void ConvertToBinary(byte s) {

        for (int i = 0; i < 8; i++) {
            int o = (int) Math.pow(2, (7 - i));
            if ((s & o) == o) {
                mod = mod + "1";
            } else if ((s & o) == 0) mod = mod + "0";
        }
    }

    public void searchAndWrite(String[] strs) throws IOException {
        getCode();
        String Temp = "";
        String result = "";
        int y = 0;
        for (int i = 0; i < mod.length(); i++) {
            Temp = Temp + mod.charAt(i);
            for (int j=0;j<127;j++)
            if(Temp.equals(codes[j])){
                result=result + (char)j;
                Temp="";
            }
        }
        System.out.println("Compressed file is decoded !!");
        File file = new File("C:\\Users\\hAmed\\Desktop\\huffmanfiles\\ExtractedFile.txt");
        FileOutputStream file1 = new FileOutputStream(file);
        file1.write(result.getBytes());
        System.out.println("Extracted file is created !!");
        file1.close();

    }
    }
