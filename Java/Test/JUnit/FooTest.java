import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

public class FooTest {

    @Test
    void doThat() throws Exception {
        // get Logback Logger 
        Logger fooLogger = (Logger) LoggerFactory.getLogger(Foo.class);

        // create and start a ListAppender
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        // add the appender to the logger
        // addAppender is outdated now
        fooLogger.addAppender(listAppender);

        // call method under test
        Foo foo = new Foo();
        foo.doThat();

        // JUnit assertions
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("start", logsList.get(0)
                                      .getMessage());
        assertEquals(Level.INFO, logsList.get(0)
                                         .getLevel());

        assertEquals("finish", logsList.get(1)
                                       .getMessage());
        assertEquals(Level.INFO, logsList.get(1)
                                         .getLevel());
    }
}
