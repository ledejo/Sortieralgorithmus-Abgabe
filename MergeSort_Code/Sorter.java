package MergeSort_Code;

import java.util.ArrayList;

public class Sorter {
    public void sort(ArrayList<AggregatedRow> rows) {
        mergeSort(rows);
    }
    
    private static void mergeSort(ArrayList<AggregatedRow> rows) {
        int length = rows.size();
        if (length < 2) {
            return;
        }
        int middleIndex = length / 2;
        ArrayList<AggregatedRow> leftSide = new ArrayList<>(rows.subList(0, middleIndex));
        ArrayList<AggregatedRow> rightSide = new ArrayList<>(rows.subList(middleIndex, length));
        mergeSort(leftSide);
        mergeSort(rightSide);
        merge(rows, leftSide, rightSide);
    }

    private static void merge(ArrayList<AggregatedRow> rows, ArrayList<AggregatedRow> leftSide, ArrayList<AggregatedRow> rightSide) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (leftIndex >= leftSide.size()) { 
                rows.set(i, rightSide.get(rightIndex));
                rightIndex++;
                continue;
            } else if (rightIndex >= rightSide.size()) { 
                rows.set(i, leftSide.get(leftIndex));
                leftIndex++;
                continue;
            } else if (leftSide.get(leftIndex).totalCostTyre >= rightSide.get(rightIndex).totalCostTyre) {
                rows.set(i, leftSide.get(leftIndex));
                leftIndex++;
            } else {
                rows.set(i, rightSide.get(rightIndex));
                rightIndex++;
            }
        }
    }
}