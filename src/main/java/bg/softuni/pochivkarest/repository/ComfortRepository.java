package bg.softuni.pochivkarest.repository;

import bg.softuni.pochivkarest.model.entity.Comfort;
import bg.softuni.pochivkarest.model.enums.ComfortEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComfortRepository extends JpaRepository<Comfort, Long> {
    Comfort findByName(ComfortEnum comfortEnum);
}
