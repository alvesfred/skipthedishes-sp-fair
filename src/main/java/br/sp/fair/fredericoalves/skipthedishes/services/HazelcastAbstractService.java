package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;
import lombok.Getter;

/**
 * Hazelcast Abstract Service/Repo
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public abstract class HazelcastAbstractService<T extends LongModel> implements HazelcastService<T> {

	@Autowired
    @Getter
    private HazelcastInstance hazelcastInstance;

    /**
     * Destroy
     */
    @PreDestroy
    protected void shutDown() {
        hazelcastInstance.getLifecycleService().shutdown();
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

		addToList(entity);
	}

    @Override
    public void remove(Long id) {
        IMap<Long, T> dataStore = getHazelcastInstance().getMap(getCacheMapName());
        dataStore.remove(id);

        Optional<T> op = list().parallelStream().filter(entity -> entity.getId().equals(id)).findAny();
        if (op.isPresent()) {
        	removeFromList(op.get());
        }
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

	private void addToList(T entity) {
		IList<T> dataStore = getHazelcastInstance().getList(getCacheListName());
	    dataStore.add(entity);
	}

    private void removeFromList(T entity) {
        IList<T> dataStore = getHazelcastInstance().getList(getCacheListName());
        dataStore.remove(entity);
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
