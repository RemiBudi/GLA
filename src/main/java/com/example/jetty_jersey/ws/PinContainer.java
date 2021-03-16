package com.example.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable
public class PinContainer {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected Long id = null;

	@Persistent
	protected List<Pin> pins = null;

	public PinContainer() {
		super();
		this.pins = new ArrayList<Pin>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Pin> getPins() {
		return pins;
	}

	public void setPins(List<Pin> p) {
		this.pins = p;
	}

}
