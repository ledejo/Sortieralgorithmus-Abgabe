package MergeSort_Code;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Row> rows = new ArrayList<>();
        //
        rows.add(new Row("Max Verstappen", 650));
        rows.add(new Row("Max Verstappen", 5900));
        rows.add(new Row("Charles Leclerc", 4310));
        rows.add(new Row("Charles Leclerc", 390210));
        rows.add(new Row("Jonas Lederer", 29));
        rows.add(new Row("Jonas Lederer", 388));
        
       
        
        Aggregator aggregator = new Aggregator();
        ArrayList<AggregatedRow> aggregatedRows = aggregator.aggregate(rows);

        Sorter sorter = new Sorter();
        sorter.sort(aggregatedRows);

        for (AggregatedRow row : aggregatedRows) {
            System.out.println(row.driver + ": " + row.totalCostTyre);
        }
    }
}