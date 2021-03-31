package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.Places.dao.Comment;
import com.Places.dao.CommentContainer;



public class CommentContainerTest {
	
	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("BDD");
		Long containerId = null;

		// Save a container with 3 actions
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			Comment comment1 = new Comment("Title 1");
			Comment comment2 = new Comment("Title 2");
			Comment comment3 = new Comment("Title 3");

			CommentContainer container = new CommentContainer();
			container.getComments().add(comment1);
			container.getComments().add(comment2);
			container.getComments().add(comment3);

			container = pm.makePersistent(container);
			containerId = container.getId();
			pm.close();
		}

		// Retrieve this container
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			CommentContainer container = pm.getObjectById(CommentContainer.class, containerId);
			Assert.assertEquals(3, container.getComments().size());

			pm.close();
		}

		pmf.close();
	}

}
