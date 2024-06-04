package myDumDaddy.service.impl;

import myDumDaddy.config.APILogger;
import myDumDaddy.model.Survey;
import myDumDaddy.model.response.QuestionDetails;
import myDumDaddy.model.response.QuestionResponse;
import myDumDaddy.repository.SurveyRepository;
import myDumDaddy.service.DumService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DumServiceImpl implements DumService {
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private ModelMapper mapper;

    public QuestionResponse getQuestionsById(APILogger logger, String id) {
        logger.add("DumService.getQuestionsById-startTime", LocalDateTime.now().toString());
        List<Survey> list;
        QuestionResponse response = new QuestionResponse();
        try {
            logger.add("Fetching data from db using" + id, "");
            list = surveyRepository.findByProductCode(id);
            logger.add("Fetched data", "");
            response.setList(list.stream().map(x -> mapper.map(list, QuestionDetails.class)).toList());
        } catch (DataAccessException e) {
            throw e;
        }
        return response;
    }
}
