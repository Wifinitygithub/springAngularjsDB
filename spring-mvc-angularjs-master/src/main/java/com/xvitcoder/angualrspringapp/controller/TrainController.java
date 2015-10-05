package com.xvitcoder.angualrspringapp.controller;

import com.xvitcoder.angualrspringapp.beans.Train;
import com.xvitcoder.angualrspringapp.dao.ContactDAOImpl;
import com.xvitcoder.angualrspringapp.service.TrainService;
import com.xvitcoder.angualrspringapp.service.TrainServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:22 AM
 */
@Controller
@RequestMapping("/trains")
public class TrainController {

	 final Logger logger = LoggerFactory.getLogger(TrainController.class);
	
    @Autowired
    private TrainService trainService;

    @RequestMapping("trainslist.json")
    public @ResponseBody List<Train> getTrainList() {
        return trainService.getAllTrains();
    }

    @RequestMapping(value = "/addTrain", method = RequestMethod.POST)
    public @ResponseBody void addTrain(@RequestBody Train train) {
    	logger.info("11111111");
        trainService.addTrain(train);
        logger.info("2222222222");
    }

    @RequestMapping(value = "/updateTrain", method = RequestMethod.PUT)
    public @ResponseBody void updateTrain(@RequestBody Train train) {
        trainService.updateTrain(train);
    }

    @RequestMapping(value = "/removeTrain/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeTrain(@PathVariable("id") Long id) {
        trainService.deleteTrainById(id);
    }

    @RequestMapping(value = "/removeAllTrains", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllTrains() {
        trainService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getTrainPartialPage(ModelMap modelMap) {
        return "trains/layout";
    }
}
