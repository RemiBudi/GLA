package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.example.jetty_jersey.ws.Map;
import com.example.jetty_jersey.ws.MapContainer;

public class MapContainerTest {
	
	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		Long containerId = null;
		
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			Map map1 = new Map();
			Map map2 = new Map();
			Map map3 = new Map();
			map1.setTitle("map1");
			map2.setTitle("map2");
			map3.setTitle("map3");

			MapContainer container = new MapContainer();
			container.getMaps().add(map1);
			container.getMaps().add(map2);
			container.getMaps().add(map3);

			container = pm.makePersistent(container);
			containerId = container.getId();
			pm.close();
		}
		
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			MapContainer container = pm.getObjectById(MapContainer.class, containerId);
			Assert.assertEquals(3, container.getMaps().size());

			pm.close();
		}
		pmf.close();
	}

}
