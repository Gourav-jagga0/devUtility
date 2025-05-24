package com.dev.utility.idgenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.dev.utility.entities.baseEntity;
public class IdeGenerator implements IdentifierGenerator {
	private static final long serialVersionUID = 1L;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
				if (object == null) 
			throw new HibernateException(new NullPointerException()) ;

	    if ((((baseEntity) object).getId()) == null) {
	        return sequenceGenerator.getInstance().nextId();
	    } else {
	        return ((baseEntity) object).getId();

	    } 
	}

}
