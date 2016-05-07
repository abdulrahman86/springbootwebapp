package spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dao.CityDAO;
import spring.dao.CityDatabase;
import spring.dao.ICityDAO;
import spring.dao.ICityDS;

@Configuration
public class DAOConfig {

    @Bean
    public ICityDAO cityDAO() {
        return new CityDAO();
    }
}
