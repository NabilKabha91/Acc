package com.timesheet.utils;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersistenceUtils {

	@Transactional(readOnly = true)
	public static void initialize(Object proxy) {
		
		Hibernate.initialize(proxy);
		
	}
}
