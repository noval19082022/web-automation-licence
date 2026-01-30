package config.global;

/**
 * Thread-safe flow control manager for test execution modes.
 * Manages flags for @continue, @context1, @context2, @apiflow tags.
 * Each thread maintains its own isolated flow control state.
 */
public class FlowControl {
    private static ThreadLocal<Boolean> contextOneFlow = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<Boolean> contextTwoFlow = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<Boolean> continueFlow = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<Boolean> strictFlow = ThreadLocal.withInitial(() -> true);
    private static ThreadLocal<Boolean> multipleContextFlow = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<Boolean> continueTag = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<Boolean> apiFlow = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<Boolean> mobileFlow = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<String> scenarioName = ThreadLocal.withInitial(() -> null);

    // ===== Context One Flow =====
    public static boolean isContextOneFlow() {
        return contextOneFlow.get();
    }

    public static void setContextOneFlow(boolean value) {
        contextOneFlow.set(value);
    }

    // ===== Context Two Flow =====
    public static boolean isContextTwoFlow() {
        return contextTwoFlow.get();
    }

    public static void setContextTwoFlow(boolean value) {
        contextTwoFlow.set(value);
    }

    // ===== Continue Flow =====
    public static boolean isContinueFlow() {
        return continueFlow.get();
    }

    public static void setContinueFlow(boolean value) {
        continueFlow.set(value);
    }

    // ===== Strict Flow =====
    public static boolean isStrictFlow() {
        return strictFlow.get();
    }

    public static void setStrictFlow(boolean value) {
        strictFlow.set(value);
    }

    // ===== Multiple Context Flow =====
    public static boolean isMultipleContextFlow() {
        return multipleContextFlow.get();
    }

    public static void setMultipleContextFlow(boolean value) {
        multipleContextFlow.set(value);
    }

    // ===== Continue Tag =====
    public static boolean isContinueTag() {
        return continueTag.get();
    }

    public static void setContinueTag(boolean value) {
        continueTag.set(value);
    }

    // ===== API Flow =====
    public static boolean isApiFlow() {
        return apiFlow.get();
    }

    public static void setApiFlow(boolean value) {
        apiFlow.set(value);
    }

    // ===== Mobile Flow =====
    public static boolean isMobileFlow() {
        return mobileFlow.get();
    }

    public static void setMobileFlow(boolean value) {
        mobileFlow.set(value);
    }

    // ===== Scenario Name =====
    public static String getScenarioName() {
        return scenarioName.get();
    }

    public static void setScenarioName(String value) {
        scenarioName.set(value);
    }

    /**
     * Resets all flow control flags to their default values for the current thread.
     * Called in @After hook to ensure clean state for next scenario.
     */
    public static void reset() {
        contextOneFlow.set(false);
        contextTwoFlow.set(false);
        continueFlow.set(false);
        strictFlow.set(true);
        multipleContextFlow.set(false);
        continueTag.set(false);
        apiFlow.set(false);
        mobileFlow.set(false);
        scenarioName.set(null);
    }

    /**
     * Cleans up ThreadLocal resources for the current thread.
     * MUST be called in @AfterTest to prevent memory leaks.
     */
    public static void cleanup() {
        contextOneFlow.remove();
        contextTwoFlow.remove();
        continueFlow.remove();
        strictFlow.remove();
        multipleContextFlow.remove();
        continueTag.remove();
        apiFlow.remove();
        mobileFlow.remove();
        scenarioName.remove();
    }
}
