package org.jenkinsci.plugins.workflow.job.properties;

import hudson.Extension;
import jenkins.model.OptionalJobProperty;
import org.jenkinsci.Symbol;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Disables resuming a pipeline if the master restarts - the run will simply fail instead, just like a FreeStyle job.
 * @author Victor Martinez
 */
public class QuietPeriodJobProperty extends OptionalJobProperty<WorkflowJob> {

    private int quietPeriod;

    @DataBoundConstructor
    public QuietPeriodJobProperty(int quietPeriod) {
        this.quietPeriod = quietPeriod;
    }

    public Integer getQuietPeriod() {
        return quietPeriod;
    }

    @Extension @Symbol("quietPeriod")
    public static class DescriptorImpl extends OptionalJobPropertyDescriptor {

        @Override public String getDisplayName() {
            return Messages.quiet_period();
        }

    }

}
