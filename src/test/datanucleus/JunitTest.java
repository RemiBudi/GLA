package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.Places.dao.User;
import com.Places.dao.UserDao;
import com.Places.dao.UserDaoImpl;

public class JunitTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		UserDao userDao = new UserDaoImpl(pmf);
		
		Assert.assertEquals(null, userDao.getUser("Test"));
		
		userDao.createUser("Remsi", "password", "Remsi bio");
		userDao.createUser("Paulsi", "password", "Paulsi bio");
		userDao.createUser("Trizy", "password", "Trizy bio");
		
		User remsi = userDao.getUser("Remsi");
		User trizy = userDao.getUser("Trizy");
		
		Assert.assertNotNull(remsi);
		
		userDao.addFriend(remsi.getId(), "Trizy");
		
		Assert.assertEquals(1, remsi.getContacts().size());
		
	}

}
