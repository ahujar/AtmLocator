package com.backbase.assignment.repositories;

import com.backbase.assignment.AtmLocatorApplication;
import com.backbase.assignment.model.INGAtmLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by rahuja on 23/07/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AtmLocatorApplication.class)
@WebAppConfiguration
public class AtmDataPopulatorTest {

    @Autowired
    AtmDataPopulator atmDataPopulator;

    @Test
    public void shouldFetchDatafromINGService() throws Exception {

        List<INGAtmLocation> dataFromInG = atmDataPopulator.getDataFromInG();
        assertEquals(dataFromInG.size(), 1587);
    }

}
