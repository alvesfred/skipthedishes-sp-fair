package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;

import br.sp.fair.fredericoalves.skipthedishes.model.Customer;
import br.sp.fair.fredericoalves.skipthedishes.model.Model;

/**
 * Hazelcast Abstract Service/Repo
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
//@Repository("hazelcastService")
public abstract class HazelcastAbstractService<T extends Model> implements HazelcastService<T> {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    /**
     * Destroy
     */
    @PreDestroy
    protected void shutDown() {
        hazelcastInstance.getLifecycleService().shutdown();
    }

    /**
     * Hazelcast Instance
     *
     * @return
     */
    protected HazelcastInstance getHazelcastInstance() {
    	return hazelcastInstance;
    }

	@Override
	public T get(Long id) {
		IMap<Long, T> dataStore = getHazelcastInstance().getMap(getCacheMapName());
		return dataStore.get(id);
	}

	@Override
	public void add(T entity) {
		IMap<Long, T> dataStore = getHazelcastInstance().getMap(getCacheMapName());
		dataStore.put(entity.getId(), entity);
	}

    @Override
    public void remove(Long id) {
        IMap<Long, Customer> dataStore = getHazelcastInstance().getMap(getCacheMapName());
        dataStore.remove(id);
    }

    @Override
    public List<T> list() {
        IList<T> dataStore = getHazelcastInstance().getList(getCacheListName());
        return dataStore;
    }

	@Override
	public void addList(List<T> list) {
		IList<T> dataStore = getHazelcastInstance().getList(getCacheListName());
	    dataStore.addAll(list);
	}

    @Override
    public void removeList() {
        IList<T> dataStore = getHazelcastInstance().getList(getCacheListName());
        dataStore.clear();
    }

    /**
     * Cache List
     *
     * @return
     */
    protected abstract String getCacheListName();

    /**
     * Cache Map
     *
     * @return
     */
    protected abstract String getCacheMapName();
}
