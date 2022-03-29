
package com.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test the main application class (i.e. the App class), which bootstraps and
 * configures the web application.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

    /**
     * Verify that the application context loads without error.
     *
     * This is really an integration test rather than a unit test
     * since it does not test one unit of code in isolation.
     */
    @Test
    public void contextLoads() {
        // No test code required since this test just verifies that
        // no errors occur loading the spring configuration.
    }

}
