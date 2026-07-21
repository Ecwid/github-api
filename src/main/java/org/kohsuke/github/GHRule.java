package org.kohsuke.github;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Collection;

/**
 * Rule configured for a repository branch.
 */
public class GHRule {
    private RuleType type;
    private Parameters parameters;

    /**
     * Creates a branch rule instance.
     */
    public GHRule() {
    }

    /**
     * Gets the rule type.
     *
     * @return the rule type
     */
    public RuleType getType() {
        return type;
    }

    /**
     * Sets the rule type.
     *
     * @param type
     *            the rule type
     */
    public void setType(RuleType type) {
        this.type = type;
    }

    /**
     * Gets the rule parameters.
     *
     * @return the rule parameters
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the rule parameters.
     *
     * @param parameters
     *            the rule parameters
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP2" }, justification = "Expected behavior")
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    /**
     * Wraps this rule.
     *
     * @return this rule
     */
    public GHRule wrap() {
        return this;
    }

    /**
     * Branch rule type.
     */
    public enum RuleType {
        /** Commit author email pattern rule. */
        commit_author_email_pattern,
        /** Copilot code review rule. */
        copilot_code_review,
        /** Creation rule. */
        creation,
        /** Deletion rule. */
        deletion,
        /** Merge queue rule. */
        merge_queue,
        /** Non fast-forward rule. */
        non_fast_forward,
        /** Pull request rule. */
        pull_request,
        /** Code scanning rule. */
        require_code_scanning,
        /** Deployment rule. */
        require_deployments,
        /** Linear history rule. */
        require_linear_history,
        /** Required signatures rule. */
        required_signatures,
        /** Required status checks rule. */
        required_status_checks,
        /** Update rule. */
        update,

        // Fallback for any rule type GitHub introduces in the future that this client
        // does not yet know about. Combined with READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE
        // in GitHubClient's ObjectMapper, this prevents deserialization failures on
        // new rule types and lets callers safely ignore them.
        /** Unknown rule type. */
        @JsonEnumDefaultValue
        unknown,
    }

    /**
     * Branch rule parameters.
     */
    public static class Parameters {
        private Collection<RequiredCheck> required_status_checks;
        private MergeMethod merge_method;
        private Integer max_entries_to_build;
        private Integer min_entries_to_merge;
        private Integer max_entries_to_merge;
        private Integer min_entries_to_merge_wait_minutes;
        private Integer check_response_timeout_minutes;
        private GroupingStrategy grouping_strategy;

        /**
         * Creates branch rule parameters.
         */
        public Parameters() {
        }

        /**
         * Gets required status checks.
         *
         * @return required status checks
         */
        @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
        public Collection<RequiredCheck> getRequiredStatusChecks() {
            return required_status_checks;
        }

        /**
         * Sets required status checks.
         *
         * @param required_status_checks
         *            required status checks
         */
        @SuppressFBWarnings(value = { "EI_EXPOSE_REP2" }, justification = "Expected behavior")
        public void setRequiredStatusChecks(Collection<RequiredCheck> required_status_checks) {
            this.required_status_checks = required_status_checks;
        }

        /**
         * Gets the merge method.
         *
         * @return the merge method
         */
        public MergeMethod getMergeMethod() {
            return merge_method;
        }

        /**
         * Sets the merge method.
         *
         * @param merge_method
         *            the merge method
         */
        public void setMergeMethod(MergeMethod merge_method) {
            this.merge_method = merge_method;
        }

        /**
         * Gets the maximum entries to build.
         *
         * @return the maximum entries to build
         */
        public Integer getMaxEntriesToBuild() {
            return max_entries_to_build;
        }

        /**
         * Sets the maximum entries to build.
         *
         * @param maxEntriesToBuild
         *            the maximum entries to build
         */
        public void setMaxEntriesToBuild(Integer maxEntriesToBuild) {
            this.max_entries_to_build = maxEntriesToBuild;
        }

        /**
         * Gets the minimum entries to merge.
         *
         * @return the minimum entries to merge
         */
        public Integer getMinEntriesToMerge() {
            return min_entries_to_merge;
        }

        /**
         * Sets the minimum entries to merge.
         *
         * @param minEntriesToMerge
         *            the minimum entries to merge
         */
        public void setMinEntriesToMerge(Integer minEntriesToMerge) {
            this.min_entries_to_merge = minEntriesToMerge;
        }

        /**
         * Gets the maximum entries to merge.
         *
         * @return the maximum entries to merge
         */
        public Integer getMaxEntriesToMerge() {
            return max_entries_to_merge;
        }

        /**
         * Sets the maximum entries to merge.
         *
         * @param maxEntriesToMerge
         *            the maximum entries to merge
         */
        public void setMaxEntriesToMerge(Integer maxEntriesToMerge) {
            this.max_entries_to_merge = maxEntriesToMerge;
        }

        /**
         * Gets the minimum entries to merge wait time in minutes.
         *
         * @return the minimum entries to merge wait time in minutes
         */
        public Integer getMinEntriesToMergeWaitMinutes() {
            return min_entries_to_merge_wait_minutes;
        }

        /**
         * Sets the minimum entries to merge wait time in minutes.
         *
         * @param minEntriesToMergeWaitMinutes
         *            the minimum entries to merge wait time in minutes
         */
        public void setMinEntriesToMergeWaitMinutes(Integer minEntriesToMergeWaitMinutes) {
            this.min_entries_to_merge_wait_minutes = minEntriesToMergeWaitMinutes;
        }

        /**
         * Gets the check response timeout in minutes.
         *
         * @return the check response timeout in minutes
         */
        public Integer getCheckResponseTimeoutMinutes() {
            return check_response_timeout_minutes;
        }

        /**
         * Sets the check response timeout in minutes.
         *
         * @param checkResponseTimeoutMinutes
         *            the check response timeout in minutes
         */
        public void setCheckResponseTimeoutMinutes(Integer checkResponseTimeoutMinutes) {
            this.check_response_timeout_minutes = checkResponseTimeoutMinutes;
        }

        /**
         * Gets the grouping strategy.
         *
         * @return the grouping strategy
         */
        public GroupingStrategy getGroupingStrategy() {
            return grouping_strategy;
        }

        /**
         * Sets the grouping strategy.
         *
         * @param groupingStrategy
         *            the grouping strategy
         */
        public void setGroupingStrategy(GroupingStrategy groupingStrategy) {
            this.grouping_strategy = groupingStrategy;
        }
    }

    /**
     * Required check for a branch rule.
     */
    public static class RequiredCheck {
        private String context;

        /**
         * Creates a required check instance.
         */
        public RequiredCheck() {
        }

        /**
         * Gets the check context.
         *
         * @return the check context
         */
        public String getContext() {
            return context;
        }

        /**
         * Sets the check context.
         *
         * @param context
         *            the check context
         */
        public void setContext(String context) {
            this.context = context;
        }
    }

    /**
     * Merge method for merge queue rules.
     */
    public enum MergeMethod {
        /** Merge commit method. */
        MERGE,
        /** Squash merge method. */
        SQUASH,
        /** Rebase merge method. */
        REBASE
    }

    /**
     * Grouping strategy for merge queue rules.
     */
    public enum GroupingStrategy {
        /** All entries must be green. */
        ALLGREEN,
        /** Head entry must be green. */
        HEADGREEN
    }
}
