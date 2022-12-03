package trasmissionemeteo.persistence;

import java.util.ArrayList;
import java.util.List;
import trasmissionemeteo.domain.MeteoData;

public class MeteoDataPersistence extends ListPersistenceFacade<String, MeteoData> {

    private static ArrayList<MeteoData> meteoDatas = null;

    @Override
    protected List<MeteoData> getPersistence() {
        if (null == meteoDatas) {
            meteoDatas = new ArrayList<>();
        }

        return meteoDatas;
    }
}
