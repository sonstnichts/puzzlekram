package de.cau.infprogoo.lighthouse;



public interface View {
	/**
	 * Called whenever the world updates.
	 * 
	 * @param world the {@link World} object which called this method.
	 */
	void update(Model world);

}
