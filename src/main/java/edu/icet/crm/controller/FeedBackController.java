package edu.icet.crm.controller;

import edu.icet.crm.dto.FeedBack;
import edu.icet.crm.service.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FeedBack")
@RequiredArgsConstructor
public class FeedBackController {

    final FeedBackService service;

    @GetMapping("/get-all")
    public  List<FeedBack> getFeedBack(){
        return service.getAll();
    }

    @PostMapping("/add-feedBack")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFeedBack(@RequestBody FeedBack feedBack){
        service.addFeedBack(feedBack);
    }

    @PutMapping("/update-feedBack")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateFeedBack(@RequestBody FeedBack feedBack){
        service.updateFeedBack(feedBack);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteFeedBackById(@PathVariable Integer id){
        service.deleteFeedBackById(id);
    }

}
