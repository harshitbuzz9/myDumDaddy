package myDumDaddy.controller;

import myDumDaddy.config.APILogger;
import myDumDaddy.model.response.QuestionResponse;
import myDumDaddy.service.DumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/dum/")
public class DumController {
    @Autowired
    private DumService dumService;

    @GetMapping("/test")
    String test() {
        return "test";
    }

    @GetMapping("survey/questions")
    QuestionResponse getQuestionsById(@RequestAttribute("logger") APILogger logger, @RequestParam String id) {
        QuestionResponse response;
        try {
            logger.add("DumController.getQuestionsById-startTime", LocalDateTime.now().toString());
            response = dumService.getQuestionsById(logger, id);
            logger.add("DumController.getQuestionsById-endTime", LocalDateTime.now().toString());
            logger.logSuccess(200);
        } catch (DataAccessException e) {
            logger.logError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            throw e;
        }
        return response;
    }

}
