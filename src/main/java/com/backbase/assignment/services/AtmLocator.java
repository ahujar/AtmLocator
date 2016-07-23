package com.backbase.assignment.services;

import com.backbase.assignment.model.INGAtmLocation;
import com.backbase.assignment.repositories.AtmDataPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahuja on 23/07/16.
 */
@Service
public class AtmLocator {

    @Autowired
    private AtmDataPopulator atmDataPopulator;

    public List<INGAtmLocation> getAtmLocationsfromING() throws Exception {

        return atmDataPopulator.getDataFromInG();
    }

    public List<INGAtmLocation> getAtmLocationsfromINGByCity(String city) throws Exception {

        List<INGAtmLocation> locations = new ArrayList<>();
        List<INGAtmLocation> atmLocationsfromING = getAtmLocationsfromING();
        for (INGAtmLocation location : atmLocationsfromING) {
            if (city.equalsIgnoreCase(location.getAddress().getCity())) {
                locations.add(location);
            }
        }
        return locations;
    }
}
