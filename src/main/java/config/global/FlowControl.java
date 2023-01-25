package config.global;

public class FlowControl {
    private static boolean strictFlow;
    private static boolean continueFlow;

    public static synchronized void setStrictFlow(boolean strictFlow) {
        FlowControl.strictFlow = strictFlow;
    }

    public static boolean getStrictFlow() {
        return strictFlow;
    }

    public static synchronized void setContinueFlow(boolean continueFlow) {
        FlowControl.continueFlow = continueFlow;
    }

    public static boolean getContinueFlow() {
        return continueFlow;
    }
}
