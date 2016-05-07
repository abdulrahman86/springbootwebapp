package spring.dao;

import spring.domain.City;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface ICityDAO {

    public Optional<City> findById(Integer id);

    public void deleteById(Integer id);

    public List<City> listAll();

    public Integer create(City city);

    public void update(City updatedCity);
}
