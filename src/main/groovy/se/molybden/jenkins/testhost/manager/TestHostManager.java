package se.molybden.jenkins.testhost.manager;


import se.molybden.jenkins.testhost.data.TestHost;

import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Jocke on 2015-11-29.
 */
public class TestHostManager {
    private static TestHostManager instance = new TestHostManager();
    private boolean dirty = false;
    private ConcurrentLinkedQueue<TestHost> availableHosts = new ConcurrentLinkedQueue<TestHost>();
    public static TestHostManager get() {
        return instance;
    }

    public void initiate(TreeSet<TestHost> testhosts) {
        for (TestHost host : testhosts) {
            switch (host.getStatus()){
                case AVAILABLE:
                case QUEUED:
                    markAvailable(host);
                    break;
                case EXECUTING:
                case CHECKING:
                    break;
                case REINSTALLING:
                    break;
                case OUT_OF_ORDER:
            }
        }
    }

    public void markAvailable(TestHost host) {
        mark(TestHost.Status.AVAILABLE, host);
        if (!availableHosts.contains(host)){
            availableHosts.add(host);
        }
    }

    private void mark(TestHost.Status status, TestHost host){
        if (host.getStatus()!= status){
            dirty = true;
            host.setStatus(status);
        }
    }
}
