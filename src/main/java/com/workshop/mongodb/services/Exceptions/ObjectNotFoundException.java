package com.workshop.mongodb.services.Exceptions;
                                            //não exige que trate a exceção
public class ObjectNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
    
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
}
