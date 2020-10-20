package com.example.timesheetmicroservice.repo;

import com.example.timesheetmicroservice.domain.Timesheet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetRepository extends MongoRepository<Timesheet,String> {

    List<Timesheet> findAllByEid(String eid);

    Timesheet findByEndDateAndEid(String endDate, String eid);

    Timesheet findByIdAndEid(String id,String  eid);
    // find timesheet for a limited result by eid
    // https://www.baeldung.com/spring-data-jpa-pagination-sorting
//    List<Timesheet> findAllByEid(String eid, Pageable pageable);

}
