import com.jraft.State;
import com.jraft.util.SerializationUtils;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SerializationUtilTestCase extends TestCase {

    @Before
    @Override
    public void setUp() throws Exception {

    }


    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testSerializeAndDeserialize() throws Exception {
        State state = new State();
        state.setRole(State.Role.Candidate);
        state.setCurrentTerm(3);
        byte[] stateBytes = SerializationUtils.serialize(state);
        State stateNew = SerializationUtils.deserialize(stateBytes, State.class);
        Assert.assertEquals(state.getRole(), stateNew.getRole());
        Assert.assertEquals(state.getCurrentTerm(), stateNew.getCurrentTerm());
    }

    @Test
    public void testFileSerializeAndDeserialize() throws Exception {
        String serializedFileName = "/tmp/state.dat";
        State state = new State();
        State stateNew;

        // one
        state.setRole(State.Role.Follower);
        state.setCurrentTerm(1);
        SerializationUtils.serializeToFile(state, serializedFileName);
        stateNew = SerializationUtils.deserializeFomeFile(serializedFileName, State.class);
        Assert.assertEquals(state.getRole(), stateNew.getRole());
        Assert.assertEquals(state.getCurrentTerm(), stateNew.getCurrentTerm());

        // two
        state.setRole(State.Role.Candidate);
        state.setCurrentTerm(2);
        SerializationUtils.serializeToFile(state, serializedFileName);
        stateNew = SerializationUtils.deserializeFomeFile(serializedFileName, State.class);
        Assert.assertEquals(state.getRole(), stateNew.getRole());
        Assert.assertEquals(state.getCurrentTerm(), stateNew.getCurrentTerm());

        // three
        state.setRole(State.Role.Leader);
        state.setCurrentTerm(3);
        SerializationUtils.serializeToFile(state, serializedFileName);
        stateNew = SerializationUtils.deserializeFomeFile(serializedFileName, State.class);
        Assert.assertEquals(state.getRole(), stateNew.getRole());
        Assert.assertEquals(state.getCurrentTerm(), stateNew.getCurrentTerm());

    }

}
