package myDumDaddy.repository;

import myDumDaddy.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, String> {
    List<Survey> findByProductCode(String id);
}
