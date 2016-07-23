package com.backbase.assignment.repositories;

import com.backbase.assignment.model.INGAtmLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rahuja on 23/07/16.
 */
@Component
public class AtmDataPopulator extends RouteBuilder {

    private Logger atmDataPopulatorLogger = LoggerFactory.getLogger(AtmDataPopulator.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<INGAtmLocation> getDataFromInG() throws Exception {


        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

        atmDataPopulatorLogger.debug("GARBAGE IN RESPONSE:" + "\n\n" + response.substring(0, 5) + "\n\n");
        String toBeParsed = response.substring(6, response.length());
        atmDataPopulatorLogger.debug("TO BE PARSED RESPONSE:" + "\n\n" + toBeParsed + "\n\n");
        ObjectMapper objectMapper = new ObjectMapper();
        INGAtmLocation[] ingAtmLocations = objectMapper.readValue(toBeParsed, INGAtmLocation[].class);
        atmDataPopulatorLogger.debug("PARSED RESPONSE:" + "\n\n" + ingAtmLocations.toString() + "\n\n");

        return Arrays.asList(ingAtmLocations);
    }

    @Override
    public void configure() throws Exception {

        // TODO: To be implemented with Camel in place,
        // but I have never worked on camel before hence, this part is left as is.
    }
}
