package com.backbase.assignment.controllers;

import com.backbase.assignment.model.Address;
import com.backbase.assignment.model.ApiResponseObject;
import com.backbase.assignment.model.INGAtmLocation;
import com.backbase.assignment.services.AtmLocator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by rahuja on 23/07/16.
 */
public class AtmControllerTest {


    @InjectMocks
    AtmController atmController;

    @Mock
    AtmLocator atmLocator;

    private List<INGAtmLocation> atmLocationList;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        atmLocationList = new ArrayList<>();
        INGAtmLocation atmLocation = new INGAtmLocation();
        Address address = new Address();
        address.setCity("GELDROP");
        address.setHousenumber("1");

        atmLocation.setAddress(address);

        INGAtmLocation atmLocation1 = new INGAtmLocation();
        Address address1 = new Address();
        address1.setHousenumber("2");
        address1.setCity("ROTTERDAM");

        atmLocation1.setAddress(address1);

        atmLocationList.add(atmLocation);
        atmLocationList.add(atmLocation1);
    }

    @Test
    public void testGetATMLocationsfromING() throws Exception {

        when(atmLocator.getAtmLocationsfromING()).thenReturn(atmLocationList);
        ApiResponseObject atmLocationsfromING = atmController.getATMLocationsfromING();
        assertEquals(atmLocationsfromING.getList().size(),2);

    }

    @Test
    public void testGetATMLocationsfromINGByCity() throws Exception {

        when(atmLocator.getAtmLocationsfromINGByCity(Mockito.anyString())).thenReturn(atmLocationList);
        ApiResponseObject locationsfromINGByCity = atmController.getATMLocationsfromINGByCity("ANY_CITY");
        assertEquals(locationsfromINGByCity.getList().size(),2);

    }
}