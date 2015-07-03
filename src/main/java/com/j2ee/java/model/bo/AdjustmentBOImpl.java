package com.j2ee.java.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.j2ee.java.model.dao.HibernateUtil;
import com.j2ee.java.model.dao.AdjustmentDAO;
import com.j2ee.java.model.dto.Adjustment;
@Component(value="AdjustmentBOImpl")
public class AdjustmentBOImpl implements AdjustmentBO {

	private static final Logger logger = LoggerFactory.getLogger(AdjustmentBOImpl.class);
	@Autowired
	@Qualifier("AdjustmentDAOImpl")
	private AdjustmentDAO adjustmentDAO;
	
	@Override
	public Adjustment getByID(int id) {
		// TODO Auto-generated method stub
		Adjustment Adjustment = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			Adjustment = adjustmentDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return Adjustment;
	}

	@Override
	public List<Adjustment> getAllAdjustment() {
		// TODO Auto-generated method stub
		List<Adjustment> listAdjustment = new ArrayList<Adjustment>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listAdjustment = adjustmentDAO.getAllAdjustment();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listAdjustment;
	}

	@Override
	public boolean insertAdjustment(Adjustment Adjustment) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = adjustmentDAO.insertAdjustment(Adjustment);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

	@Override
	public boolean updateAdjustment(Adjustment Adjustment) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = adjustmentDAO.updateAdjustment(Adjustment);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

	@Override
	public boolean deleteAdjustment(Adjustment Adjustment) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = adjustmentDAO.deleteAdjustment(Adjustment);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

}
