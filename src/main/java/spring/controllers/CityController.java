package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.controllers.exception.ControllerExceptionHandler;
import spring.controllers.exception.NoSuchCityException;
import spring.dao.ICityDAO;
import spring.domain.City;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

@RestController
public class CityController {

    @Autowired
    private ICityDAO cityDAO;

    @RequestMapping("/cities")
    List<City> listCities(){
        return cityDAO.listAll();
    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.GET)
    public City getCity(@PathVariable Integer id) {

        return cityDAO.findById(id).orElseThrow(() -> new NoSuchCityException());
    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable Integer id) {

        cityDAO.deleteById(id);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.POST)
    public Integer createCity(@RequestBody City city) {

        return cityDAO.create(city);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.PUT)
    public void updateCity(@RequestBody City city) {

        cityDAO.update(city);
    }
}
