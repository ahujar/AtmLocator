package com.backbase.assignment.controllers;

import com.backbase.assignment.model.ApiResponseObject;
import com.backbase.assignment.model.INGAtmLocation;
import com.backbase.assignment.services.AtmLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rahuja on 23/07/16.
 */
@RestController
public class AtmController {

    @Autowired
    private AtmLocator atmLocator;

    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ApiResponseObject getATMLocationsfromING() throws Exception {
        ApiResponseObject<INGAtmLocation> responseObject= new ApiResponseObject<>();
        responseObject.setList(atmLocator.getAtmLocationsfromING());
        return responseObject;
    }

    @RequestMapping(value = "/locations/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ApiResponseObject getATMLocationsfromINGByCity(@PathVariable("city") String city) throws Exception {
        ApiResponseObject<INGAtmLocation> responseObject= new ApiResponseObject<>();
        responseObject.setList(atmLocator.getAtmLocationsfromINGByCity(city));
        return responseObject;
    }


}
