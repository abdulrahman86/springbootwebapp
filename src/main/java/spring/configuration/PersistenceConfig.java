package spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dao.CityDAO;
import spring.dao.CityDatabase;
import spring.dao.ICityDS;

@Configuration
public class PersistenceConfig {

    @Bean
    public ICityDS cityDS() {
        return new CityDatabase();
    }
}
