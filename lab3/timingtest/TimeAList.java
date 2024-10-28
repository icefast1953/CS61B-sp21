package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
       AList<Integer> Ns = new AList<>();
       AList<Double> Times = new AList<>();
       AList<Integer> Adds =new AList<>();
       Stopwatch stop = new Stopwatch();
       int size =0;

       for (int i =1000;i<128001;i*=2){
           Ns.addLast(i);
       }
       for (int i =1;i<128001;i++){
           Adds.addLast(i);

           if (i== Ns.get(size)){
               size++;
               double stop1 =stop.elapsedTime();
               Times.addLast(stop1);
           }
       }
        printTimingTable(Ns,Times,Ns);

    }
}
