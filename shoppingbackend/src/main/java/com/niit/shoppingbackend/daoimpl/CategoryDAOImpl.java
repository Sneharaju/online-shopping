package com.niit.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static{
	  Category category= new Category();
	  
	  //adding first category
	  category.setId(1);
	  category.setName("Television");
	  category.setDescription("this is tv");
	  category.setImageURL("cat1.png");
	  categories.add(category);
	  
	  //2nd category
category= new Category();
	  
	  //adding first category
	  category.setId(2);
	  category.setName("Mobile");
	  category.setDescription("this is mobile");
	  category.setImageURL("cat2.png");
	  categories.add(category);
	  
	  //3rd category
category= new Category();
	  
	  //adding first category
	  category.setId(3);
	  category.setName("laptop");
	  category.setDescription("this is laptop");
	  category.setImageURL("cat3.png");
	  categories.add(category);
	}
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		
		String  selectActiveCategory ="FROM Category WHERE active = :active ";
		Query query =sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * getting single category
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {
		// TODO Auto-generated method stub

		try {

			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

}
