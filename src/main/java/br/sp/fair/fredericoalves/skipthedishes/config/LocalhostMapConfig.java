package br.sp.fair.fredericoalves.skipthedishes.config;

import com.hazelcast.config.MapConfig;

/**
 * SkipTheDishes Map Config
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public class LocalhostMapConfig extends MapConfig {

    private int timeToLiveSeconds = DEFAULT_TTL_SECONDS;

    public LocalhostMapConfig() {
    }

    public LocalhostMapConfig(LocalhostMapConfig config) {
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
    public LocalhostMapConfig setTimeToLiveSeconds(int timeToLiveSeconds) {
        this.timeToLiveSeconds = timeToLiveSeconds;
        return this;
    }

}
