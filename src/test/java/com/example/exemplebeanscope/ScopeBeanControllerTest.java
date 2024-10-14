package com.example.exemplebeanscope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.assertj.core.api.Assertions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ScopeBeanControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testingSingelton() throws Exception {
        // we are testing that singleton keep the same id (one instance)

        long firstInstanceId = getInstanceIdForSingeltonBean();

        long secondInstanceId = getInstanceIdForSingeltonBean();


        //because it's singleton scope the id of the instance did not change as you can see
       Assertions.assertThat(firstInstanceId).isEqualTo(secondInstanceId);
    }

    @Test
    void testingPrototypeBeanScope() throws Exception {
        final long[] thread1InstanceId = new long[1];
        final long[] thread2InstanceId = new long[1];

        // Runnable for Thread 1
        Runnable user1 = () -> {
            try {
                thread1InstanceId[0] = getInstanceIdForProtoypeean();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        // Runnable for Thread 2
        Runnable user2 = () -> {
            try {
                // Adding a delay to simulate a more realistic scenario
                Thread.sleep(100); // Wait for 100ms before making the second request
                thread2InstanceId[0] = getInstanceIdForProtoypeean();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        // Create and start threads
        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Assert that the instance IDs from the two threads are different
        Assertions.assertThat(thread1InstanceId[0]).isNotEqualTo(thread2InstanceId[0]);
    }


    @Test
    void testingRequestBeanScope() throws Exception {
        final long[] thread1InstanceId = new long[1];
        final long[] thread2InstanceId = new long[1];

        // Runnable for Thread 1
        Runnable user1 = () -> {
            try {
                thread1InstanceId[0] = getInstanceIdForRequestBean();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        // Runnable for Thread 2
        Runnable user2 = () -> {
            try {
                // Adding a delay to simulate a more realistic scenario
                Thread.sleep(100); // Wait for 100ms before making the second request
                thread2InstanceId[0] = getInstanceIdForRequestBean();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        // Create and start threads
        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Assert that the instance IDs from the two threads are different
        Assertions.assertThat(thread1InstanceId[0]).isNotEqualTo(thread2InstanceId[0]);
    }



    @Test
    void testingSessionBeanScope() throws Exception {
        final long[] thread1InstanceId = new long[1];
        final long[] thread2InstanceId = new long[1];

        // Runnable for Thread 1
        Runnable user1 = () -> {
            try {
                thread1InstanceId[0] = getInstanceIdForSessionBean();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        // Runnable for Thread 2
        Runnable user2 = () -> {
            try {
                // Adding a delay to simulate a more realistic scenario
                Thread.sleep(100); // Wait for 100ms before making the second request
                thread2InstanceId[0] = getInstanceIdForSessionBean();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        // Create and start threads
        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Assert that the instance IDs from the two threads are different
        Assertions.assertThat(thread1InstanceId[0]).isNotEqualTo(thread2InstanceId[0]);
    }




    private long getInstanceIdForSingeltonBean() throws Exception {
         return  Long.parseLong(mockMvc.perform(get("/scope/singelton"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString());
    }

    private long getInstanceIdForRequestBean() throws Exception {
        return  Long.parseLong(mockMvc.perform(get("/scope/request"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString());

    }

    private long getInstanceIdForSessionBean() throws Exception {
        return  Long.parseLong(mockMvc.perform(get("/scope/session"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString());

    }

    private long getInstanceIdForProtoypeean() throws Exception {
        return  Long.parseLong(mockMvc.perform(get("/scope/prototype"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString());

    }


}
