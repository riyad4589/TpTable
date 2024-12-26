package ma.cityManager.repository;

import java.util.List;
import java.util.Optional;

public interface IDao <T, ID> {
        List<T> findAll();
        Optional<T> findById(ID id);
        T save(T newElement);
        boolean update(T newValuesElement);
        boolean delete(T elementToDelete);
        boolean deleteById(ID id);

}
