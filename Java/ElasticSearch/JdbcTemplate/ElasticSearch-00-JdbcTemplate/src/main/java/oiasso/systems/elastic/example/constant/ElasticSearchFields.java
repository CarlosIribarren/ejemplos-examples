package oiasso.systems.elastic.example.constant;
/**
 * Common elements to prepare ElasticSearch consult. 
 */
public class ElasticSearchFields {

	
	/** Total */
	public static final String TOTAL = "total";
	
	/** Hits */
	public static final String HITS = "hits";
	
	/** value */
	public static final String VALUE = "value";
	
	/** Min*/
	public static final String MIN = "min";
	
	/**Max*/
	public static final String MAX = "max";
	
	/** Aggregations */
	public static final String AGGREGATIONS = "aggregations";
	
	/** Aggregations */
	public static final String AGGS = "aggs";	
	
	/** Buckets */
	public static final String BUCKETS = "buckets";
	
	/** Size */
	public static final String SIZE = "size";	
	
	/** Field */
	public static final String FIELD = "field";
	
	/** Key */
	public static final String KEY = "key";	
	
	/** Terms */
	public static final String TERMS = "terms";

	/** Value as string */
	public static final String VALUE_AS_STRING = "value_as_string";
	
	private ElasticSearchFields() throws InstantiationException {
		throw new InstantiationException();
	}
}
