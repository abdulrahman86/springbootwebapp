package spring.dao;

import spring.domain.City;

import java.util.List;

/**
 * Created by asattar on 2016-05-07.
 */
public interface ICityDS {

    public List<City> getCityList();

    public void createCity(int id, String name, double latitude, double longitude);

}
