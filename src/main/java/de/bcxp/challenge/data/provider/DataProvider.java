package de.bcxp.challenge.data.provider;

import de.bcxp.challenge.data.model.DataSet;
import java.net.URL;

/**
 * Interface for resource access.
 */
public interface DataProvider {

    /**
     * Loads a DataSet from a given resource
     * @param resource the resource which should be loaded
     * @return return null if the resource could not be loaded, otherwise a dataSet
     */
    public DataSet getDataSetFromResource(URL resource);
}
