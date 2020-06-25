package model;

/**
 * interface for result-objects that can be consumed by the GUI
 * @author Sebastian
 *
 */
public interface QueryResult {

	/**
	 * get the result as a string that can directly be dumped to a TextArea
	 * @return readily formatted string of the result
	 */
	public String getResultString();
	
	
}
