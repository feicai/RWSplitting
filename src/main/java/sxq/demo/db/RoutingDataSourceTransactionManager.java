package sxq.demo.db;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

public class RoutingDataSourceTransactionManager extends DataSourceTransactionManager {
	private static final long serialVersionUID = -6020366726602466690L;


	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		RoutingDataSource.lookupKey.set("master");
		super.doBegin(transaction, definition);
	}
	
}
