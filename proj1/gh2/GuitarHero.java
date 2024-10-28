package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final double CONCERT_V = 440.0;
    public static final double CONCERT_Q = 110.0;
    public static final double CONCERT_I = 220.0;
    public static final double CONCERT_Space = 880.0;

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString stringV = new GuitarString(CONCERT_V);
        GuitarString stringQ = new GuitarString(CONCERT_Q);
        GuitarString stringA = new GuitarString(CONCERT_I);
        GuitarString stringSpace = new GuitarString(CONCERT_Space);

        while (true) {


            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                } else if (key == 'c') {
                    stringQ.pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = stringA.sample() + stringQ.sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            stringA.tic();
            stringQ.tic();
        }
    }
}