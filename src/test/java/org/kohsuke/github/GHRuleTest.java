package org.kohsuke.github;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;

/**
 * Test class for GHRule.
 */
public class GHRuleTest {

    /**
     * Create default GHRuleTest instance.
     */
    public GHRuleTest() {
    }

    /**
     * Tests rule getters and setters.
     */
    @Test
    public void testRuleAccessors() {
        GHRule rule = new GHRule();
        GHRule.Parameters parameters = new GHRule.Parameters();

        rule.setType(GHRule.RuleType.merge_queue);
        rule.setParameters(parameters);

        assertThat(rule.getType(), is(GHRule.RuleType.merge_queue));
        assertThat(rule.getParameters(), is(sameInstance(parameters)));
        assertThat(rule.wrap(), is(sameInstance(rule)));
    }

    /**
     * Tests parameter getters and setters.
     */
    @Test
    public void testParametersAccessors() {
        GHRule.Parameters parameters = new GHRule.Parameters();
        GHRule.RequiredCheck requiredCheck = new GHRule.RequiredCheck();

        parameters.setRequiredStatusChecks(Collections.singleton(requiredCheck));
        parameters.setMergeMethod(GHRule.MergeMethod.SQUASH);
        parameters.setMaxEntriesToBuild(1);
        parameters.setMinEntriesToMerge(2);
        parameters.setMaxEntriesToMerge(3);
        parameters.setMinEntriesToMergeWaitMinutes(4);
        parameters.setCheckResponseTimeoutMinutes(5);
        parameters.setGroupingStrategy(GHRule.GroupingStrategy.HEADGREEN);

        assertThat(parameters.getRequiredStatusChecks(), is(equalTo(Collections.singleton(requiredCheck))));
        assertThat(parameters.getMergeMethod(), is(GHRule.MergeMethod.SQUASH));
        assertThat(parameters.getMaxEntriesToBuild(), is(1));
        assertThat(parameters.getMinEntriesToMerge(), is(2));
        assertThat(parameters.getMaxEntriesToMerge(), is(3));
        assertThat(parameters.getMinEntriesToMergeWaitMinutes(), is(4));
        assertThat(parameters.getCheckResponseTimeoutMinutes(), is(5));
        assertThat(parameters.getGroupingStrategy(), is(GHRule.GroupingStrategy.HEADGREEN));
    }

    /**
     * Tests required check accessors.
     */
    @Test
    public void testRequiredCheckAccessors() {
        GHRule.RequiredCheck requiredCheck = new GHRule.RequiredCheck();

        requiredCheck.setContext("build");

        assertThat(requiredCheck.getContext(), is("build"));
    }

    /**
     * Tests rule enums.
     */
    @Test
    public void testEnums() {
        assertThat(GHRule.RuleType.values().length, is(14));
        assertThat(GHRule.RuleType.unknown, is(notNullValue()));
        assertThat(GHRule.MergeMethod.values().length, is(3));
        assertThat(GHRule.GroupingStrategy.values().length, is(2));
    }
}
