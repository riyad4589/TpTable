package ma.cityManager.repository.dbMem;

import ma.cityManager.entities.City;
import ma.cityManager.repository.IDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDao implements IDao<City,Long> {

    private List<City> dbMemory(){
        return new ArrayList<>(
                List.of(
                        new City(1L,"Casablanca", 300000.0,"Casablanca-Settat"),
                        new City(2L,"Rabat", 1000000.0,"Rabat-Sale-Kenitra"),
                        new City(3L,"Fes", 900000.0,"Fes-Meknes"),
                        new City(4L,"Marrakech", 1200000.0,"Marrakech-Safi"),
                        new City(5L,"Tanger", 700000.0,"Tanger-Tetouan-Al Hoceima"),
                        new City(6L,"Agadir", 600000.0,"Souss-Massa")
                )
        );
    }
    @Override
    public List<City> findAll() {
        return dbMemory();
    }

    @Override
    public Optional<City> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public City save(City newElement) {
        return null;
    }

    @Override
    public boolean update(City newValuesElement) {
        return false;
    }

    @Override
    public boolean delete(City element) {
        return false;
    }

    @Override
    public boolean deleteById(Long identity) {
        return false;
    }
}
