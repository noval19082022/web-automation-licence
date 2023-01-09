package config.global;

public class FlowControl {
    private static boolean strictFlow;

    public static void setStrictFlow(boolean strictFlow) {
        FlowControl.strictFlow = strictFlow;
    }

    public static boolean getStrictFlow() {
        return strictFlow;
    }
}
