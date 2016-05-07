package spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import spring.domain.City;

import java.util.List;
import java.util.Optional;
import java.util.Random;


public class CityDAO implements  ICityDAO{

	@Autowired
	private ICityDS cityDatabase;

	@Override
	public Optional<City> findById(Integer id) {

		return cityDatabase.getCityList().stream().filter(x -> x.getId().equals(id)).findFirst();

	}

	@Override
	public void deleteById(Integer id) {

		this.findById(id).map(x ->  {
			cityDatabase.getCityList().remove(x);
			return x;
		});
	}

	@Override
	public List<City> listAll() {
		return cityDatabase.getCityList();
	}

	@Override
	public Integer create(City city) {
		Random random = new Random();
		Integer id = Math.abs(random.nextInt());

		city.setId(id);
		cityDatabase.getCityList().add(city);

		return id;
	}

	@Override
	public void update(City updatedCity) {
		this.findById(updatedCity.getId()).map(x -> {
			x.setName(updatedCity.getName());
			x.setLatitude(updatedCity.getLatitude());
			x.setLongitude(updatedCity.getLongitude());
			return x;
		});
	}
}
