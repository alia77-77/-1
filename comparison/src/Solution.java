import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final int ONE_THOUSAND = 1000;
    private static final int TWO_THOUSAND = 2000;
    private static final int FIVE_THOUSAND = 5000;
    private static final int TEN_THOUSAND = 10000;
    private static final int TWENTY_THOUSAND = 20000;

    public static void main(String[] args) {
        doTests(TWENTY_THOUSAND, ONE_THOUSAND, "ARRAY LIST");
        doTests(TWENTY_THOUSAND, ONE_THOUSAND, "LINKED LIST");

    }

    private static void doTests(int sizeOfList, int iterations, String header) {
        List<Integer> list;
        if (sizeOfList <= iterations) {
            System.out.println("Количетсво итераций превосходит количество элементов в списке");
            return;
        }
        if ("ARRAY LIST".equals(header)) {
            list = initArrayList(sizeOfList);
        } else {
            list = initLinkedList(sizeOfList);
        }
        long addTestDuration = addTest(list, iterations);
        long removeTestDuration = removeTest(list, iterations);
        long getTestDuration = getTest(list, iterations);
        long setTestDuration = setTest(list, iterations);
        Result result = new Result(iterations, addTestDuration, removeTestDuration, getTestDuration, setTestDuration);
        printResults(header, result);
    }

    private static List<Integer> initArrayList(int size) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private static List<Integer> initLinkedList(int size) {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }

    private static long addTest(List<Integer> list, int numberOfLoops) {
        // засекаем время на момент начала теста
        long startTime = System.currentTimeMillis();//использует системные часы , возвращает абсолютное время
        for (int i = 0; i < numberOfLoops; i++) {
            list.add(i);
        }
        // получаем время на момент окончания теста
        long endTime = System.currentTimeMillis();
        // отдаем разницу
        return endTime - startTime;
    }

    private static long removeTest(List<Integer> list, int numberOfLoops) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfLoops; i++) {
            list.remove(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long getTest(List<Integer> list, int numberOfLoops) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfLoops; i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long setTest(List<Integer> list, int numberOfLoops) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfLoops; i++) {
            list.set(i, i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static void printResults(String header, Result result) {
        System.out.printf("---------%s----------", header);
        System.out.println();
        System.out.printf("Size: %d Add: %d Remove: %d Get: %d Set: %d",
                result.size, result.addTime, result.removeTime, result.getTime, result.setTime);
        System.out.println("\n");
    }
}
