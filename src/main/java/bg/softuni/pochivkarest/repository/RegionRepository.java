package bg.softuni.pochivkarest.repository;

import bg.softuni.pochivkarest.model.entity.Region;
import bg.softuni.pochivkarest.model.enums.RegionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByTypeRegion(RegionEnum sea);
}
