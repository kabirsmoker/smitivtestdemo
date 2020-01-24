package com.xworkz.studentmanagement.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.studentmanagement.controller.StudentController;
import com.xworkz.studentmanagement.dto.StudentDTO;
import com.xworkz.studentmanagement.exception.DaoException;

@Repository
public class StudentDao {
	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(StudentController.class);

	public StudentDao() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	public void save(StudentDTO dto) throws DaoException {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(dto);
			transaction.commit();
		} catch (HibernateException e) {
			throw new DaoException(e.getMessage());
		}

	}

	public List<StudentDTO> getStudentList() throws DaoException {

		List<StudentDTO> studentList = null;
		try {
			String sql = "from StudentDTO";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(sql);
			studentList = query.list();
		} catch (HibernateException e) {
			throw new DaoException(e.getMessage());
		}
		return studentList;

	}

	public StudentDTO getStudentById(int id) throws DaoException {

		StudentDTO studentDTO = null;

		try {
			String sql = "from StudentDTO where id=:uid";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(sql);
			query.setParameter("uid", id);
			studentDTO = (StudentDTO) query.uniqueResult();
		} catch (HibernateException e) {
			throw new DaoException(e.getMessage());
		}

		return studentDTO;

	}

}
