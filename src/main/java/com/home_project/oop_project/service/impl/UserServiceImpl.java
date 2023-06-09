package com.home_project.oop_project.service.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.home_project.oop_project.entity.User;
import com.home_project.oop_project.repository.UserRepository;
import com.home_project.oop_project.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
        return userRepository.findAll();
	}

	@Override
	public List<User> getAllUsers(String keyword, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
		if (keyword != null) {
            return userRepository.search(keyword, pageNo*pageSize, pageSize);
        }
        return userRepository.findAll(pageable).get().toList();
	}

	@Override
	public User validationUser(String username, String password) {
		// throw new UnsupportedOperationException("Unimplemented method 'validationUser'");
		return userRepository.validationUser(username, password);
	}

	@Override
	public User findUserByUsername(String username) {
		// throw new UnsupportedOperationException("Unimplemented method 'validationUser'");
		return userRepository.findUserByUsername(username);
	}

	@Override
	public int getTotalItems(String keyword){
		if (keyword !=null){
			return userRepository.getTotalItemsSearched(keyword);
		}
		return userRepository.getTotalItems();
	}

	@Override
	public User saveUser(User User) {
		return userRepository.save(User);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User User) {
		return userRepository.save(User);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);	
	}
}
