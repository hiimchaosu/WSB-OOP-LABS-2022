import callable.CallableSorter;
import task12.jdbc.ObjectToSql;
import task12.jdbc.entity.Employee;
import threads.Counter;

import java.util.*;
import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread firstThread = new Thread(new Counter("\u001B[30m"));
        Thread secondThread = new Thread(new Counter("\u001B[34m"));
        firstThread.start();
        secondThread.start();

        Map<Integer, ArrayList<Integer>> mapListOfInteger = Map.of(0, new ArrayList<>(Arrays.asList(7, 6, 8, 1, 5, 4, 2)), 1, new ArrayList<>(Arrays.asList(11, 13, 15, 3)), 2, new ArrayList<>(Arrays.asList(5, 9, 7, 4, 1, 5, 10, 20, 30, 55)), 3, new ArrayList<>(Arrays.asList(0, -1, 5, -9, 75)));
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0; i < 4; i++) {
                long start = Calendar.getInstance().getTimeInMillis();
                CallableSorter callableSorter = new CallableSorter(mapListOfInteger.get(i));
                callableSorter.call();
                long end = Calendar.getInstance().getTimeInMillis();
                long delta = end - start;
                System.out.println("Time it took to sort array: " + delta);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CallableSorter callableSorter = new CallableSorter(mapListOfInteger.get(0));
        CallableSorter callableSorter1 = new CallableSorter(mapListOfInteger.get(1));
        CallableSorter callableSorter2 = new CallableSorter(mapListOfInteger.get(2));
        CallableSorter callableSorter3 = new CallableSorter(mapListOfInteger.get(3));

        long start = Calendar.getInstance().getTimeInMillis();
        executor.submit(() -> {

            try {
                callableSorter.call();
                callableSorter1.call();
                callableSorter2.call();
                callableSorter3.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        long end = Calendar.getInstance().getTimeInMillis();
        long delta = end - start;
        System.out.println("Time it took to sort array: " + delta);

        ObjectToSql objectToSql = new ObjectToSql();
        objectToSql.insert(new Employee("Patryk", "Sobczak", "sobczak@patr.yk", "Male"));
    }
}