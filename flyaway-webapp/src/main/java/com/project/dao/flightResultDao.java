package com.project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.project.dbutil.FactoryProvider;
import com.project.pojo.BookingDetails;

public class flightResultDao {
	
	public static List<BookingDetails> flightSearchResult (BookingDetails details) {
		
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from BookingDetails where date =:x and source =:y and destination=:z");
		q.setParameter("x",details.getDate());
		q.setParameter("y",details.getSource());
		q.setParameter("z",details.getDestination());
		@SuppressWarnings("unchecked")
		List<BookingDetails> result = q.getResultList();
		s.close();
		//FactoryProvider.closeFactory();
		return result;
	}
}
