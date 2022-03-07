package com.example.placesearch;

import com.example.placesearch.controller.SearchController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SearchController.class)
class PlaceSearchApplicationTests {

    @Autowired
    private MockMvc mvc;


}
