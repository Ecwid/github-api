package org.kohsuke.github;

import java.io.IOException;

import javax.annotation.Nonnull;

/**
 * Environment variable configured for a repository environment.
 */
public class GHEnvironmentVariable extends GitHubInteractiveObject {

    private String name;
    private String value;
    private String createdAt;
    private String updatedAt;

    /**
     * Creates an environment variable instance.
     */
    public GHEnvironmentVariable() {
    }

    /**
     * Gets the variable name.
     *
     * @return the variable name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the variable name.
     *
     * @param name
     *            the variable name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the variable value.
     *
     * @return the variable value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the variable value.
     *
     * @param value
     *            the variable value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the creation timestamp.
     *
     * @return the creation timestamp
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     *
     * @param createdAt
     *            the creation timestamp
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the update timestamp.
     *
     * @return the update timestamp
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the update timestamp.
     *
     * @param updatedAt
     *            the update timestamp
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    static GHEnvironmentVariable read(@Nonnull GHRepository repository,
            @Nonnull String environment,
            @Nonnull String name) throws IOException {
        String url = "environments/" + environment + "/variables/" + name;
        GHEnvironmentVariable variable = repository.root()
                .createRequest()
                .withUrlPath(repository.getApiTailUrl(url))
                .fetch(GHEnvironmentVariable.class);
        return variable;
    }

}
