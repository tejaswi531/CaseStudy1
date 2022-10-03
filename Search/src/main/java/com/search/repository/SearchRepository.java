package com.search.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.search.entity.FlightDetails;

@Repository
public interface SearchRepository extends MongoRepository<FlightDetails, Integer>
{

	FlightDetails findByFlightNo(int flightNo);
	@Query( "{'startPoint':?0,'endPoint':?1,'flightDate':?2}")
	public List<FlightDetails> findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint, LocalDate flightDate);
}
