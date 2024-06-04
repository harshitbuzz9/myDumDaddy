package myDumDaddy.service;

import myDumDaddy.config.APILogger;
import myDumDaddy.model.response.QuestionResponse;

public interface DumService {
    QuestionResponse getQuestionsById(APILogger logger, String id);
}
