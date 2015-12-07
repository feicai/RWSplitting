package sxq.demo.db;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {

	public static final ThreadLocal<String> lookupKey = new ThreadLocal<String>();
	
    @Override
    protected Object determineCurrentLookupKey() {
    	Object object = lookupKey.get();
    	lookupKey.remove();
    	return object;
    }

}
