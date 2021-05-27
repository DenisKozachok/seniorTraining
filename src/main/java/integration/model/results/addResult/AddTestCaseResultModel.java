package integration.model.results.addResult;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import integration.enumProperty.TestCaseStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddTestCaseResultModel{

	@JsonProperty("case_id")
	private int caseId;

	@JsonProperty("status_id")
	private int statusId;

	@JsonProperty("elapsed")
	private String elapsed;

	@JsonProperty("defects")
	private String defects;

	@JsonProperty("comment")
	private String comment;

	@JsonProperty("version")
	private String version;

	@JsonProperty("custom_step_results")
	private List<CustomStepResultsItemModel> customStepResults;

	public AddTestCaseResultModel setStatusId(TestCaseStatus statusId) {
		this.statusId = statusId.getTestCaseStatus();

		return this;
	}
}