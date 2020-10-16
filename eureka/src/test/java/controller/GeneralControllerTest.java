package controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles({"test"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = {GeneralConfiguration.class})
public class GeneralControllerTest {
//    @Autowired
//    private GeneralConfiguration generalConfiguration;
//
//    @Test
//    public void testGeneralController() {
//        String result = generalConfiguration.getDev();
//        System.out.println(result);
//    }
}
