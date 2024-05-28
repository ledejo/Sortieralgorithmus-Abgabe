package MergeSort_Code;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Row> rows = new ArrayList<>();
        
        rows.add(new Row("Max Verstappen", 3000));
        rows.add(new Row("Max Verstappen", 3000));
        rows.add(new Row("Steffen Merk", 5000));
        rows.add(new Row("Steffen Merk", 5000));
        rows.add(new Row("Jonas Lederer", 2000));
        rows.add(new Row("Jonas Lederer", 2000));
        

        Aggregator aggregator = new Aggregator();
        ArrayList<AggregatedRow> aggregatedRows = aggregator.aggregate(rows);

        Sorter sorter = new Sorter();
        sorter.sort(aggregatedRows);

        for (AggregatedRow row : aggregatedRows) {
            System.out.println(row.driver + ": " + row.totalCostTyre);
        }
    }
}