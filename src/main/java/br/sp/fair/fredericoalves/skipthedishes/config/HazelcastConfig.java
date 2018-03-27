package br.sp.fair.fredericoalves.skipthedishes.config;

import static java.util.Collections.singletonList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Hazelcast Config
 *
 * @author Frederico Cerqueira Alves
 * @see http://docs.hazelcast.org/docs/latest-development/manual/html/Understanding_Configuration/Configuring_Declaratively.html
 */
@Configuration
//@Import({LocalhostListConfig.class, LocalhostMapConfig.class})
public class HazelcastConfig {

	static final String LOCALHOST = "127.0.0.1";

    @Bean
    public Config config() {
        Config config = new Config();
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(singletonList(LOCALHOST));

        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance() {
        final Config config = new Config();
        config.setProperty("hazelcast.jmx", "true");

        /**
           <multicast enabled="true">
		      <multicast-group>224.2.2.3</multicast-group>
		      <multicast-port>54327</multicast-port>
		   </multicast>
		   <tcp-ip enabled="false">
			  <interface>127.0.0.1</interface>
			  <member-list>
			  <member>127.0.0.1</member>
			  </member-list>
		   </tcp-ip>
         */
        //setNetworkProperties(config);

        config.addListConfig(getListConfig("customer"));
        config.addListConfig(getListConfig("store"));
        config.addListConfig(getListConfig("product"));
        config.addListConfig(getListConfig("order"));
        config.addListConfig(getListConfig("orderItem"));

        config.addMapConfig(getMapConfig("customer"));
        config.addMapConfig(getMapConfig("store"));
        config.addMapConfig(getMapConfig("product"));
        config.addMapConfig(getMapConfig("order"));
        config.addMapConfig(getMapConfig("orderItem"));        

         return Hazelcast.newHazelcastInstance(config);
    }

    private LocalhostListConfig getListConfig(final String name) {
        LocalhostListConfig listConfig = new LocalhostListConfig();
        listConfig.setMaxSize(50);
        listConfig.setTimeToLiveSeconds(10);
        listConfig.setBackupCount(0);
        listConfig.setName(name + "List");

        return listConfig;
    }

    private LocalhostMapConfig getMapConfig(final String name) {
	    final LocalhostMapConfig mapConfig = new LocalhostMapConfig();
	    mapConfig.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE));
	    mapConfig.setTimeToLiveSeconds(10);
	    mapConfig.setBackupCount(0);
	    mapConfig.setName(name + "Map");
	    mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
	    mapConfig.setInMemoryFormat(InMemoryFormat.BINARY);
	    mapConfig.setMergePolicy("com.hazelcast.map.merge.PassThroughMergePolicy");

	    return mapConfig;
    }

    static final int PORT = 5505;
    void setNetworkProperties(Config config) {
        NetworkConfig network = config.getNetworkConfig();
        network.setPort(PORT);

        JoinConfig join = network.getJoin();
        join.getTcpIpConfig().setEnabled(false);
        join.getAwsConfig().setEnabled(false);
        join.getMulticastConfig().setEnabled(true);

        //join.getMulticastConfig().setMulticastGroup(MULTICAST_ADDRESS);
        //join.getMulticastConfig().setMulticastPort(MULTICAST_PORT);

        join.getMulticastConfig().setMulticastTimeoutSeconds(500);
    }
}
