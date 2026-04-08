import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String id;
    int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
}

public class UseCase {
    public static void main(String[] args) {
        // 1. Prepare a large dataset for meaningful benchmarking
        List<Bogie> consist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            consist.add(new Bogie("B" + i, (int) (Math.random() * 100)));
        }

        System.out.println("Benchmarking filtering of " + consist.size() + " bogies...");

        // --- Loop-Based Processing ---
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : consist) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // --- Stream-Based Processing ---
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = consist.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // --- Results ---
        System.out.println("-------------------------------------------");
        System.out.println("Loop Duration   : " + loopDuration + " ns");
        System.out.println("Stream Duration : " + streamDuration + " ns");
        System.out.println("Results Match   : " + (loopFiltered.size() == streamFiltered.size()));

        if (loopDuration < streamDuration) {
            System.out.println("Winner: Traditional Loop (Lower overhead)");
        } else {
            System.out.println("Winner: Java Stream (Optimization/JIT potential)");
        }
    }
}