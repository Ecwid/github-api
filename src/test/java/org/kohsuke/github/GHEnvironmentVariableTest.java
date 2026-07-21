package org.kohsuke.github;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test class for GHEnvironmentVariable.
 */
public class GHEnvironmentVariableTest {

    /**
     * Create default GHEnvironmentVariableTest instance.
     */
    public GHEnvironmentVariableTest() {
    }

    /**
     * Tests environment variable getters and setters.
     */
    @Test
    public void testAccessors() {
        GHEnvironmentVariable variable = new GHEnvironmentVariable();

        variable.setName("name");
        variable.setValue("value");
        variable.setCreatedAt("created");
        variable.setUpdatedAt("updated");

        assertThat(variable.getName(), is("name"));
        assertThat(variable.getValue(), is("value"));
        assertThat(variable.getCreatedAt(), is("created"));
        assertThat(variable.getUpdatedAt(), is("updated"));
    }
}
