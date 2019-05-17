import com.jraft.util.CmdLineParser;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CmdLineParserTestCase extends TestCase {

    private CmdLineParser parser;
    @Before
    @Override
    public void setUp() throws Exception {
        parser = CmdLineParser.getInstance();
    }


    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testHelp() throws Exception {
        String args[] = {"-h"};
        Assert.assertFalse(parser.parse(args));
        parser.showHelp();
    }

    @Test
    public void testOpt() throws Exception {
        String[] args = {"-i", "-s"};
        Assert.assertFalse(parser.parse(args));

        String[] args1 = {"-i", "id.conf", "-s"};
        Assert.assertFalse(parser.parse(args1));
        Assert.assertNull(parser.getIdConfFile());
        Assert.assertNull(parser.getServersConfFile());

        String[] args2 = {"-i", "id.conf", "-s", "servers.conf"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertEquals(parser.getOptValue("i"), "id.conf");
        Assert.assertEquals(parser.getOptValue("s"), "servers.conf");

        String[] args3 = {"-i", "id.conf", "-s", "servers.conf", "--abc", "123"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertEquals(parser.getOptValue("id-conf"), "id.conf");
        Assert.assertEquals(parser.getOptValue("servers-conf"), "servers.conf");
        Assert.assertNull(parser.getOptValue("abc"));
    }

    @Test
    public void testLongOpt() throws Exception {
        String[] args = {"--id-conf", "--servers-conf"};
        Assert.assertFalse(parser.parse(args));

        String[] args1 = {"--id-conf", "id.conf", "--servers-conf"};
        Assert.assertFalse(parser.parse(args1));
        Assert.assertNull(parser.getIdConfFile());
        Assert.assertNull(parser.getServersConfFile());
        Assert.assertNull(parser.getOptValue("abc"));

        String[] args2 = {"--id-conf", "id.conf", "--servers-conf", "servers.conf"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertEquals(parser.getOptValue("id-conf"), "id.conf");
        Assert.assertEquals(parser.getOptValue("servers-conf"), "servers.conf");

        String[] args3 = {"--id-conf", "id.conf", "--servers-conf", "servers.conf", "--abc", "123"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertEquals(parser.getOptValue("i"), "id.conf");
        Assert.assertEquals(parser.getOptValue("s"), "servers.conf");
        Assert.assertNull(parser.getOptValue("abc"));
    }
}
