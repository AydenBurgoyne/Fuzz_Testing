import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        //variables
        //generator made with max line count 50;
        Integer TestNum = 0; //counts how many iterations have occured
        PrintStream out = null; //gets a new print writer called out. Defines because can't define within try block loop.
        LinkedList<ExceptionObj> ErrorList = new LinkedList<>();
        try {

            createFile("data\\output.txt");

            out = new PrintStream(new FileOutputStream("data\\output.txt"));

        } catch (Exception e) {
            exit(0);
        }
        for (int i = 0; i < Integer.valueOf(args[0]); i++) {
            KWIC temp = new KWIC();
            String[] input = new String[1];
            Random rand = new Random();
            RandomFileContentGenerator gen = new RandomFileContentGenerator("large.txt", rand.nextInt(1000));
            gen.generate();
            input[0] = "data\\large.txt";
            try {
                temp.main(input);
            } catch (Exception e) {
                File file = new File("data\\large.txt");
                Scanner myReader = new Scanner(file);
                ExceptionObj tempE = new ExceptionObj(e);
                if(checkExceptionExists(tempE,ErrorList)){
                    continue;
                }
                ErrorList.add(tempE);
                TestNum++;
                out.println("-------------------------------------------------------");
                out.println("Test:" + TestNum);
                for (int z = 0; z < e.getStackTrace().length; z++) {
                    out.println(e.getStackTrace()[z]);

                }
                out.println(e);
                out.println("-------------------------------------------------------");
                out.println("input:");
                while(myReader.hasNext()){
                    out.println(myReader.next());
                }
            }

        }
        out.println("-------------------------------------------------------");
        out.println("-------------------------------------------------------");
        out.println("Total unqiue errors:"+TestNum);
    }
    public static void createFile(String name){
        File myFile = new File(name);
    }
    public static boolean checkExists(String name){
        File myFile = new File(name);
       return myFile.exists();
    }
    public static boolean checkExceptionExists(ExceptionObj check,LinkedList<ExceptionObj> errorList){
        for (ExceptionObj exceptionObj : errorList) {
            if(exceptionObj.Compare(check)){
                return true;
            }
        }
        return false;
    }

}

