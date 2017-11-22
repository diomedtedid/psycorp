package psycorp.core.model;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import psycorp.core.model.enums.Area;
import psycorp.core.util.TestFactory;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 12.11.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTest {

    @Mock
    private TestCore testCore;

    @Mock
    private Map<Area, Set<Question>> questions;

    private Test testResponse;

    @Before
    public void setUp() throws Exception {
        Mockito.when(testCore.getId()).thenReturn(2L);
        testResponse = new Test(testCore, questions);
    }

    @org.junit.Test
    public void getIdTest() throws Exception {
        assertEquals(2L, testResponse.getId());
    }


}