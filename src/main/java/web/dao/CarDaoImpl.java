package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> list = new ArrayList<>();
    
    static {
        list.add(new Car("Toyota", "RED", 1978));
        list.add(new Car("Ferrari", "YELLOW", 2015));
        list.add(new Car("Volga", "BLACK", 2000));
        list.add(new Car("Renault", "GREEN", 1950));
        list.add(new Car("Lada", "WHITE", 2022));
    }
    @Override
    public List<Car> getCars(int count) {
        if (count == 0 || count >= 5) {
            return list;
        }
        return list.stream().limit(count).collect(Collectors.toList());
    }
}