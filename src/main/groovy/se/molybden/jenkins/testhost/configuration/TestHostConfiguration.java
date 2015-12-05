package se.molybden.jenkins.testhost.configuration;

import hudson.model.Descriptor;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;
import se.molybden.jenkins.testhost.data.TestHost;
import se.molybden.jenkins.testhost.manager.TestHostManager;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by Jocke on 2015-11-29.
 */
public class TestHostConfiguration extends GlobalConfiguration {

    private TreeSet<TestHost> testhosts = new TreeSet<TestHost>();
    public TestHostConfiguration() {
        load();
        TestHostManager.get().initiate(testhosts);

    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        return super.configure(req, json);
    }


}
