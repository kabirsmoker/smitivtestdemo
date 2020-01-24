package com.xworkz.studentmanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.studentmanagement.dto.StudentDTO;
import com.xworkz.studentmanagement.exception.ServiceException;
import com.xworkz.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService studentService;

	private static final Logger logger = Logger.getLogger(StudentController.class);

	public StudentController() {
		logger.info("Studen Controllre is created");
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String onSubmit(StudentDTO dto, Model model) {
		logger.info("Student data is" + dto);
		try {
			studentService.saveStudent(dto);
			List<StudentDTO> dtos = studentService.getStudentList();
			model.addAttribute("stdList", dtos);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
		}

		return "StudentList";

	}

	@RequestMapping(value = "/pfUpdate", method = RequestMethod.GET)
	public String pfUpdate(@RequestParam int id, Model model) {

		logger.info("Student id : " + id);

		try {
			StudentDTO studentDTO = studentService.getStudentById(id);
			model.addAttribute("student", studentDTO);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
		}

		return "StudentUpdate";

	}

}
