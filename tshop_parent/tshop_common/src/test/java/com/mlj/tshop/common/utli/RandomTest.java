package com.mlj.tshop.common.utli;

import com.mlj.tshop.common.util.Random;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Random Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 11, 2018</pre>
 */
public class RandomTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getLong(int length)
     */
    @Test
    public void testGetLong() throws Exception {

        System.out.println(Random.getLong(8));
    }


} 
