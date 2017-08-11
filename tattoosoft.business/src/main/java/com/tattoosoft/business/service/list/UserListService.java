package com.tattoosoft.business.service.list;

import org.springframework.stereotype.Service;

import com.tattoosoft.persistence.dao.UserDAO;
import com.tattoosoft.persistence.model.User;

@Service("userListService")
public class UserListService extends AbstractGenericListService<User, UserDAO> {

}
