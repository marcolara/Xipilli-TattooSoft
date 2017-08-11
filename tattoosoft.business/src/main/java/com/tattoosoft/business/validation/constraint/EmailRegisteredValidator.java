package com.tattoosoft.business.validation.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.tattoosoft.business.validation.annotation.EmailRegistered;
import com.tattoosoft.persistence.dao.UserDAO;

public class EmailRegisteredValidator implements ConstraintValidator<EmailRegistered, String>{
	@Autowired
	@Qualifier("UserDAO")
	private UserDAO userDAO;
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(EmailRegistered constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	@Transactional
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userDAO.findUniqueByEmailAddress(value.toUpperCase()) != null;
	}
}
