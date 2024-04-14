package de.bcxp.challenge.data.provider.csv;

import de.bcxp.challenge.data.model.DataSet;
import de.bcxp.challenge.data.provider.DataProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CsvReader implements DataProvider {

    @Override
    public DataSet getDataSetFromResource(URL resource) {
        String file = resource.getPath();

        List<String[]> data = new LinkedList<String[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException exception) {
            System.out.print(exception.getMessage());
            return null;
        }

        return csvToDataSet(data);
    }

    private DataSet csvToDataSet(List<String[]> data) {
        DataSet result = new DataSet();
        if (!data.isEmpty()) {
            List<String> columns = Arrays.asList(data.get(0));
            List<String[]> rows = new LinkedList<String[]>();
            if (data.size() > 1) {
                rows = data.subList(1, data.size()-1);
            }
            return new DataSet(columns, rows);
        }
        return result;
    }
}
