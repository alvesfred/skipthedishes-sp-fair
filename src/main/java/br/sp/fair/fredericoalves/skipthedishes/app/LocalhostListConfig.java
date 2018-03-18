package br.sp.fair.fredericoalves.skipthedishes.app;

import com.hazelcast.config.ListConfig;

/**
 * Hazelcast Local Config
 * 
 * @author frederico.alves
 *
 */
public class LocalhostListConfig extends ListConfig {

    private int timeToLiveSeconds = 0;

    public LocalhostListConfig() {
    }

    public LocalhostListConfig(LocalhostListConfig config) {
        this.timeToLiveSeconds = config.getTimeToLiveSeconds();
    }

    public int getTimeToLiveSeconds() {
        return timeToLiveSeconds;
    }

    public LocalhostListConfig setTimeToLiveSeconds(int timeToLiveSeconds) {
        this.timeToLiveSeconds = timeToLiveSeconds;
        return this;
    }

}
