package se.molybden.jenkins.testhost.listeners;

import hudson.EnvVars;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Environment;
import hudson.model.TaskListener;
import hudson.model.listeners.RunListener;

/**
 * Created by Jocke on 2015-11-29.
 */
@Extension
public class TestHostRunListener extends RunListener<AbstractBuild> {

    public void onCompleted(AbstractBuild build, TaskListener listener) {

    }

    public Environment setUpEnvironment(AbstractBuild build, Launcher launcher, BuildListener listener){
        Environment environment = Environment.create(new EnvVars("TESTHOST"));
        return null;
    }
}
