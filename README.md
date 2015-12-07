RWSplitting (读写分离): 
========================
#####使用技术
	
*   SpringMVC
*   Spring
*	MyBatis

#####实现原理


通过实现Spring提供的org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource来选择数据源

	public class RoutingDataSource extends AbstractRoutingDataSource {
		public static final ThreadLocal<String> lookupKey = new ThreadLocal<String>();
	    @Override
	    protected Object determineCurrentLookupKey() {
	    	Object object = lookupKey.get();
	    	lookupKey.remove();
	    	return object;
	    }
	}

如果存在事务则选择写库，如果不存在事务（read-only）则选择写库

	public class RoutingDataSourceTransactionManager extends DataSourceTransactionManager {
		private static final long serialVersionUID = -6020366726602466690L;
		@Override
		protected void doBegin(Object transaction, TransactionDefinition definition) {
			RoutingDataSource.lookupKey.set("master");
			super.doBegin(transaction, definition);
		}
	}