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
        String args[] = {"java", "abc", "-h"};
        Assert.assertFalse(parser.parse(args));
        parser.showHelp();
    }

    @Test
    public void testOpt() throws Exception {
        String[] args = {"java", "abc", "-i", "-s"};
        Assert.assertFalse(parser.parse(args));

        String[] args1 = {"java", "abc", "-i", "id.conf", "-s"};
        Assert.assertFalse(parser.parse(args1));
        Assert.assertNull(parser.getIdConfFile());
        Assert.assertNull(parser.getServersConfFile());
        Assert.assertNull(parser.getArgsOption("abc"));

        String[] args2 = {"java", "abc", "-i", "id.conf", "-s", "servers.conf"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertNull(parser.getArgsOption("abc"));

        String[] args3 = {"java", "abc", "-i", "id.conf", "-s", "servers.conf", "--abc", "123"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertEquals(parser.getArgsOption("id-conf"), "id.conf");
        Assert.assertEquals(parser.getArgsOption("servers-conf"), "servers.conf");
    }

    @Test
    public void testLongOpt() throws Exception {
        String[] args = {"java", "abc", "--id-conf", "--servers-conf"};
        Assert.assertFalse(parser.parse(args));

        String[] args1 = {"java", "abc", "--id-conf", "id.conf", "--servers-conf"};
        Assert.assertFalse(parser.parse(args1));
        Assert.assertNull(parser.getIdConfFile());
        Assert.assertNull(parser.getServersConfFile());
        Assert.assertNull(parser.getArgsOption("abc"));

        String[] args2 = {"java", "abc", "--id-conf", "id.conf", "--servers-conf", "servers.conf"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertNull(parser.getArgsOption("abc"));

        String[] args3 = {"java", "abc", "--id-conf", "id.conf", "--servers-conf", "servers.conf", "--abc", "123"};
        Assert.assertTrue(parser.parse(args2));
        Assert.assertEquals(parser.getIdConfFile(), "id.conf");
        Assert.assertEquals(parser.getServersConfFile(), "servers.conf");
        Assert.assertEquals(parser.getArgsOption("id-conf"), "id.conf");
        Assert.assertEquals(parser.getArgsOption("servers-conf"), "servers.conf");
    }
}
