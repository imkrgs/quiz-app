package com.project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.dbutil.FactoryProvider;
import com.project.pojo.AdminInfo;

public class adminDao {

	public static String verifyUser(AdminInfo details) {
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from AdminInfo where email=:x and password=:y");
		q.setParameter("x", details.getEmail());
		q.setParameter("y", details.getPassword());
		@SuppressWarnings("unchecked")
		List<AdminInfo> result = q.getResultList();
		System.out.println("result from dao :" + result);
		s.close();
		// FactoryProvider.closeFactory();
		return result.size() == 1 ? "true" : "false";
	}

	public static String changePassword(AdminInfo details) {
		Session s = FactoryProvider.getFactory().openSession();
		Transaction transaction = s.beginTransaction();
		Query q = s.createQuery("update AdminInfo a set a.password=:x where email=:y");
		q.setParameter("y", details.getEmail());
		q.setParameter("x", details.getPassword());
		int result = q.executeUpdate();
		transaction.commit();
		System.out.println("result from dao :" + result);
		s.close();
		return result == 1 ? "true" : "false";
	}

	public static List<String> flightList() {
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("select b.flightNumber from BookingDetails b");
		@SuppressWarnings("unchecked")
		List<String> details = (List<String>) q.getResultList();
		s.close();
		return details;
	}

	public static List<String> airLineList() {
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("select b.flight from BookingDetails b");
		@SuppressWarnings("unchecked")
		List<String> details = (List<String>) q.getResultList();
		s.close();
		return details;
	}

	public static List<Object [] > sourceAndDestinationList() {
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("select b.source , b.destination from BookingDetails b");
		@SuppressWarnings("unchecked")
		List<Object []> details =  q.getResultList();
		s.close();
		return details;
	}

}
