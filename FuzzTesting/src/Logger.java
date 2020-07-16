public class Logger {
    long Start =0;
    long Finish =0;

    public Logger() {
        Start = System.nanoTime();
    }
    public void Reset(){
        Start = System.nanoTime();
        Finish = 0;
    }
    public void Stop() {
        Finish = System.nanoTime()-Start;
    }

    public long getFinished(){
        return Finish;
    }

}
