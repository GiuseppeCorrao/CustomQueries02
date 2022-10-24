package co.develhope.CustomQueries1.repositories;


import co.develhope.CustomQueries1.entities.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Override
    Page<Flight> findAll(Pageable pageable);

    //List<Flight> findBYStatus(FlightStatus status);
    @Query(value = "SELECT * FROM Flights f WHERE f.status = ONTIME",nativeQuery = true)
    List<Flight> findByStatusOnTime();

    @Query(value = "SELECT * FROM flight AS f WHERE f.status =:p1 OR f.status=:p2", nativeQuery = true)
    List<Flight> findByTwoStatus(@Param("p1") String p1, @Param("p2") String p2);
}
