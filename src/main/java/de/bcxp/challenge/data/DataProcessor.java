package de.bcxp.challenge.data;

import de.bcxp.challenge.data.model.DataSet;
import de.bcxp.challenge.data.provider.DataProvider;
import java.net.URL;
import java.util.function.Function;

/**
 * Is used to perform and process dataSets from a given dataProvider.
 * @param <T> Type of the dataSet-objects which have to be processed
 */
public class DataProcessor<T> {

    private final DataProvider dataProvider;

    /**
     * creates a new instance of the dataProvider
     * @param dataProvider The provider which is the source of the data
     */
    public DataProcessor(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * loads the given resource from the dataProvider, transforms the dataSets and performs a function on the data
     * @param resource the URL which the dataProvider uses to load the data
     * @param transformation a function which transforms the loaded dataSet to explicit objects
     * @param function the function which has to be performed on the objects
     * @return returns the result of the function
     * @param <R> The type of the result
     */
    public <R> R process(URL resource, Function<DataSet, T> transformation, Function<T, R> function) {
        if (dataProvider == null) {
            return null;
        }
        DataSet dataSet = dataProvider.getDataSetFromResource(resource);
        T data = transformation.apply(dataSet);
        return function.apply(data);
    }
}
