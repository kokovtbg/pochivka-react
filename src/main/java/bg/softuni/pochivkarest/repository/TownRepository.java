package bg.softuni.pochivkarest.repository;

import bg.softuni.pochivkarest.model.entity.Town;
import bg.softuni.pochivkarest.model.enums.TownEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Town findByName(TownEnum townEnum);
}
