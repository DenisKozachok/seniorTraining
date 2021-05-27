package integration.enumProperty;

import lombok.Getter;

@Getter
public enum TestCaseStatus {

    PASSED(1),
    BLOCKED(2),
    UNTESTED(3),
    RETEST(4),
    FAILED(5);

    private final int testCaseStatus;

    TestCaseStatus(int testCaseStatus)
    {
        this.testCaseStatus = testCaseStatus;
    }


}
