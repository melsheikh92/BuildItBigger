package com.udacity.gradle.testing;

import android.test.AndroidTestCase;
import android.test.MoreAsserts;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by Mahmoud on 13/05/2017.
 */

public class TestEndPointAsync extends AndroidTestCase {

    public void verifyAsynkTaskNotEmpty() {

        EndpointAsyncTask endpoint = new EndpointAsyncTask(getContext());
        endpoint.execute();

        try {
            String myjoke = endpoint.get();
            MoreAsserts.assertNotEqual(myjoke, null);

        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("error");
        } catch (ExecutionException e) {
            e.printStackTrace();
            fail("error");
        }


    }

}
