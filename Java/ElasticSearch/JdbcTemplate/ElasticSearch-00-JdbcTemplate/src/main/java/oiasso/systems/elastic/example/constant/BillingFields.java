package oiasso.systems.elastic.example.constant;
/**
 * Billing fields if ElasticSearch data base. 
 */
public class BillingFields {

	/** Field spot id */
	public static final String SPOT_ID = "spot_id";
	
	/** Field spot name */
	public static final String SPOT_NAME = "spot_name";	
	
	/** Field device name */
	public static final String DEVICE_NAME = "dev";
	
	/** Field date start */
	public static final String DATE_START = "date_start";
	
	/** Field date end */
	public static final String DATE_END = "date_end";
	
	private BillingFields() throws InstantiationException {
		throw new InstantiationException();
	}
}
