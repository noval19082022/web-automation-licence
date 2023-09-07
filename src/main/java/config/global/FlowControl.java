package config.global;

import lombok.Getter;
import lombok.Setter;

public class FlowControl {
    @Getter @Setter
    private static boolean pmsFlow,pmsFlow1,continueFlow,strictFlow, multipleContextFlow;

}
