package com.Places.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.transaction.UserTransaction;


public class CommentDaoImpl implements CommentDao{
	
	private PersistenceManagerFactory pmf;
	
	@Resource
	UserTransaction userTransaction;

	
	public CommentDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	public CommentDaoImpl() {
		this.pmf = JDOHelper.getPersistenceManagerFactory("BDD");
		
	}


	//Return all comments from a user specified by his username
	@SuppressWarnings("unchecked")
	public List<Comment> getComments(String author) {
		
		List<Comment> comments = null;
		List<Comment> detached = new ArrayList<Comment>();
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			Query q = pm.newQuery(Comment.class);
			q.declareParameters("String user");
			q.setFilter("author == user");

			comments = (List<Comment>) q.execute(author);
			detached = (List<Comment>) pm.detachCopyAll(comments);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		return detached;
	}
	
	
	
	/**
	 * @param Pin
	 * @return List of comments of specific pin
	 */
	public List<Comment> getComments(Pin pin) {

		List<Comment> commentListPin = new ArrayList<Comment>();
		return commentListPin;
	}
	
	
	/**
	 * @param Map
	 * @return List of comments of specific map
	 */
	public List<Comment> getComments(Map map){
		
		List<Comment> commentListMap = new ArrayList<Comment>();
		return commentListMap;
		
	}

	/**
	 * @param User , title, text, map
	 * @return Comment to be posted on the map
	 */
	public Comment createComment(String user, String title, String text, Map map) {

		Comment newCommentMap = new Comment();
		return newCommentMap;
	}

	/**
	 * @param User , title, text, map
	 * @return Comment to be posted on the pin
	 */
	public Comment createComment(String user, String title, String text, Pin pin) {

		
		Comment newCommentPin = new Comment(user, title, text, pin);
		
	
		
		return newCommentPin;
	}

	/**
	 * @param Comment to be remove
	 * @return
	 */
	public void removeComment(Comment comment) {

	}
	
	/**
	 * @param Comment to be remove
	 * @return
	 */
	public void addComment(Comment comment) {

	}

}
