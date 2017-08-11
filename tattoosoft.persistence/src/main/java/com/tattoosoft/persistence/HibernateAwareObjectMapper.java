package com.tattoosoft.persistence;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
		registerModule(new Hibernate4Module());
	}

	public HibernateAwareObjectMapper(JsonFactory arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HibernateAwareObjectMapper(ObjectMapper arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HibernateAwareObjectMapper(JsonFactory arg0,
			DefaultSerializerProvider arg1, DefaultDeserializationContext arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

}
