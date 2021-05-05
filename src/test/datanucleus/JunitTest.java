package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.Places.dao.MapDao;
import com.Places.dao.MapDaoImpl;
import com.Places.dao.User;
import com.Places.dao.UserDao;
import com.Places.dao.UserDaoImpl;

public class JunitTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("BDD");
		UserDao userDao = new UserDaoImpl(pmf);
		
		Assert.assertEquals(null, userDao.getUser("Test"));
		
		User remsi = userDao.createUser("Remsi", "password", "Remsi bio");
		User trizy = userDao.createUser("Trizy", "password", "Paulsi bio");
		userDao.createUser("Paulsi", "password", "Trizy bio");

		
		Assert.assertNotNull(remsi);
		

		
		MapDao mapDao = new MapDaoImpl(pmf);
		mapDao.createMap(1, 1, "MapRemsi", "desc", "tags");
		
		Assert.assertEquals(1, remsi.getMyMaps().size());
		Assert.assertEquals(1, mapDao.getPublicMaps().size());
		
	}

}
