import jdk.jfr.StackTrace;

import java.util.Iterator;
import java.util.LinkedList;

public class ExceptionObj {
    //variables
   private  Exception e;
   private LinkedList<String> StackTraceList = new LinkedList<>();
    //constructor


    public ExceptionObj(Exception e) {
        this.e = e;
        ConvertStackList();
    }
    //checks if the two exceptions are == and if they are they return 1; if they are different returns 0;
    public boolean Compare(ExceptionObj comparedException) {
        if (getStackTraceList().size() != comparedException.getStackTraceList().size()) {
            return false;
        }
        //fixed comparision.
        Iterator<String> it1 = getStackTraceList().iterator();
        Iterator<String> it2 = comparedException.getStackTraceList().iterator();
        while(it1.hasNext()){
            String one = it1.next();
            String two = it2.next();
            if(!one.equals(two)){
                return false;
            }
        }

        //-------------------------------------------------------------------------
        /*
            for (int i = 0; i < e.getStackTrace().length; i++) {
                     String one = comparedException.getException().getStackTrace()[i].toString();
                     String two = e.getStackTrace()[i].toString();
                     if(!one.equals(two)){
                         return false;
                     }
            }
            */
            String exceptionMessage1 = comparedException.getException().toString();
            String exceptionMessage2 = e.toString();
            if(exceptionMessage1.contains(":")||exceptionMessage2.contains(":")){
                if(exceptionMessage1.contains(":")) {
                    String[] output1 = exceptionMessage1.split(":");
                    if (exceptionMessage2.contains(output1[0])) {
                        return true;
                    }
                }
                if(exceptionMessage2.contains(":")) {
                    String[] output2 = exceptionMessage2.split(":");
                    if (exceptionMessage1.contains(output2[0])) {
                        return true;
                    }
                }
            }
            if (!exceptionMessage1.equals(exceptionMessage2)){
                return false;

            }
                return true;
        }
    public Exception getException(){
        return e;
    }
    private void ConvertStackList(){
        String looking = "KWIC.quickSort";
        Boolean contains = false;
        //finding whether contains quicksort and range for it.
        for(int i=0;i<e.getStackTrace().length;i++){
            if(e.getStackTrace()[i].toString().contains(looking)&&contains==false){
                    contains = true;
                    StackTraceList.add(looking);
                    continue;
                }
            if(!e.getStackTrace()[i].toString().contains(looking)){
                StackTraceList.add(e.getStackTrace()[i].toString());
            }
            }
        }

    public LinkedList<String> getStackTraceList() {
        return StackTraceList;
    }

    private void setStackTraceList(LinkedList<String> stackTraceList) {
        StackTraceList = stackTraceList;
    }
}
