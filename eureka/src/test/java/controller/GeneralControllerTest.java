package controller;

import com.yinghan.coupon.EurekaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EurekaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GeneralControllerTest {

    private int port = 8000;

    @Test
    public void contextLoad() {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://127.0.0.1:" + port, String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}
