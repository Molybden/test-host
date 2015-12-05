package se.molybden.jenkins.testhost.data;

/**
 * Created by Jocke on 2015-11-29.
 */
public class TestHost {
    public enum Status {
        AVAILABLE, QUEUED, EXECUTING, CHECKING, REINSTALLING, OUT_OF_ORDER;
    }

    private final String hostname;
    Status status;


    public TestHost(String hostname) {
        this.hostname = hostname;
    }

    public String getHostname() {
        return hostname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
