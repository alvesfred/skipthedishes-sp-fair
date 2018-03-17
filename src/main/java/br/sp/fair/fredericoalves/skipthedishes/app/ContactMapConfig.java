package br.sp.fair.fredericoalves.skipthedishes.app;

import com.hazelcast.config.MapConfig;

/**
 * SkipTheDishes Map Config
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public class ContactMapConfig extends MapConfig {

    private int timeToLiveSeconds = DEFAULT_TTL_SECONDS;

    public ContactMapConfig() {
    }

    public ContactMapConfig(ContactMapConfig config) {
        this.timeToLiveSeconds = config.getTimeToLiveSeconds();
    }

    @Override
    public int getTimeToLiveSeconds() {
        return timeToLiveSeconds;
    }

    /**
     * Time to live objects
     *
     * @param timeToLiveSeconds
     * @return
     */
    public ContactMapConfig setTimeToLiveSeconds(int timeToLiveSeconds) {
        this.timeToLiveSeconds = timeToLiveSeconds;
        return this;
    }

}
