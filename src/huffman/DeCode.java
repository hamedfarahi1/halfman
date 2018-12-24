package huffman;
import java.io.*;
class DeCode {
    private StringBuilder mod = new StringBuilder();
    private String[] codes = new String[127];
    String path;
    DeCode(String path){
        this.path = path;
    }
    void read() throws IOException {
        File fileStream = new File(Main.pathForCompress+"\\binary.ftm");
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
        File file = new File(Main.pathForCompress+"\\codesofcharacter.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder Code= new StringBuilder();
        char code;
        while (true){
            code =(char) bufferedReader.read();
            if (code=='#')break;
            if (code=='~'){
                codes[bufferedReader.read()]= Code.toString();
                Code = new StringBuilder();
                code =(char) bufferedReader.read();
                if (code=='#')break;
            }
            Code.append(code);
        }
    }
    private void ConvertToBinary(byte s) {
        for (int i = 0; i < 8; i++) {
            int o = (int) Math.pow(2, (7 - i));
            if ((s & o) == o) {
                mod.append("1");
            } else if ((s & o) == 0)mod.append("0");
        }
    }
    void searchAndWrite() throws IOException {
        getCode();
        StringBuilder Temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mod.length(); i++) {
            Temp.append(mod.charAt(i));
            for (int j=0;j<127;j++) {
                if (!Temp.toString().equals(codes[j])) {
                    continue;
                }
                result.append((char) j);
                Temp = new StringBuilder();
            }
        }
        result = new StringBuilder(result.substring(9));
        result.insert(0, FileWR.getMast());
        System.out.println("Compressed file is decoded !!");
        File file = new File(path + "\\ExtractedFile.txt");
        FileOutputStream file1 = new FileOutputStream(file);
        file1.write(result.toString().getBytes());
        System.out.println("Extracted file is created !!");
        file1.close();
    }
    }
