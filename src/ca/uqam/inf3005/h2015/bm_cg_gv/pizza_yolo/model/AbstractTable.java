package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model;

import java.util.Map;


public abstract class AbstractTable<T> {
	
	
	public abstract T get(int index);
	public abstract Map<Integer, T> getAll();
	
	
	
}
