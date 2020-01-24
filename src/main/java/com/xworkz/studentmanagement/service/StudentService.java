package com.xworkz.studentmanagement.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.studentmanagement.controller.StudentController;
import com.xworkz.studentmanagement.dao.StudentDao;
import com.xworkz.studentmanagement.dto.StudentDTO;
import com.xworkz.studentmanagement.exception.DaoException;
import com.xworkz.studentmanagement.exception.ServiceException;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	private static final Logger logger = Logger.getLogger(StudentController.class);

	public StudentService() {
		logger.info("created " + this.getClass().getSimpleName());

	}

	public void saveStudent(StudentDTO studentDTO) throws ServiceException {
		try {
			studentDao.save(studentDTO);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<StudentDTO> getStudentList() throws ServiceException {

		List<StudentDTO> dtos = null;
		try {
			dtos = studentDao.getStudentList();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return dtos;
	}

	public StudentDTO getStudentById(int id) throws ServiceException {

		StudentDTO studentDTO = null;

		try {
			studentDTO = studentDao.getStudentById(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return studentDTO;
	}

}
