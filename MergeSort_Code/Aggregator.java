package MergeSort_Code;

import java.util.ArrayList;

public class Aggregator {
    public ArrayList<AggregatedRow> aggregate(ArrayList<Row> rows) {

        ArrayList<AggregatedRow> aggregatedRows = new ArrayList<>();

        for (Row row : rows) {
            AggregatedRow existingRow = findAggregatedRow(aggregatedRows, row.driver);
            if (existingRow != null) {
                existingRow.totalCostTyre += row.totalCostTyre;
            } else {
                aggregatedRows.add(new AggregatedRow(row.driver, row.totalCostTyre));
            }
        }
        return aggregatedRows;
    }

    private AggregatedRow findAggregatedRow(ArrayList<AggregatedRow> aggregatedRows, String driver) {
        for (AggregatedRow a : aggregatedRows) {
            if (a.driver.equals(driver)) {
                return a;
            }
        }
        return null;
    }
}