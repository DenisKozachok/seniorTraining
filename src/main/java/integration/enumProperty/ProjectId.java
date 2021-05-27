package integration.enumProperty;

import lombok.Getter;

@Getter
public enum ProjectId {

    SENIOR_TRAINING(1);


    private final int projectId;

    ProjectId(int projectId)
    {
        this.projectId = projectId;
    }


}
