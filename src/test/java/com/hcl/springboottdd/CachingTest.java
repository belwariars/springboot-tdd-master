package com.hcl.springboottdd;


import com.hcl.springboottdd.domain.Car;
import com.hcl.springboottdd.domain.CarRepository;
import com.hcl.springboottdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    private CarService service;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void caching() throws Exception {
        given(carRepository.findByName(anyString())).willReturn(Car.builder().name("prius").type("hybrid").build());

        service.getCarDetails("prius");
        service.getCarDetails("prius");

        verify(carRepository,times(1)).findByName("prius");
    }
}
