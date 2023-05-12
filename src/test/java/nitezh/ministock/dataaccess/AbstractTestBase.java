package nitezh.ministock.dataaccess;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.mockito.MockedStatic;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

public class AbstractTestBase {
    protected final FxChangeRepository fxRepository = new FxChangeRepository();

    private MockedStatic<Log> logMockedStatic;

    @Before
    public final void setUpBase() {
        logMockedStatic = mockStatic(Log.class);

        logMockedStatic.when(() -> Log.i(any(), any())).thenAnswer((Answer<Integer>) invocation -> {
            System.out.println("Having log: " + Arrays.toString(invocation.getArguments()));

            return 1;
        });
    }

    @After
    public final void tearDownBase() {
        logMockedStatic.close();
    }
}
