package integration.model.runs.addOrUpdateRuns;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddOrUpdateRunsModel{

	@JsonProperty("name")
	private String testRunName;

	@JsonProperty("include_all")
	private boolean includeAll;

	@JsonProperty("case_ids")
	private List<Integer> caseIds = new ArrayList<>();

	@JsonProperty("refs")
	private String refs;
//
//	@JsonProperty("assignedto_id")
//	private int assignedtoId;
//
//	@JsonProperty("suite_id")
//	private int suiteId;


	public AddOrUpdateRunsModel(String testRunProjectName) {
		this.testRunName = testRunProjectName;
		this.includeAll = false;
	}

	public AddOrUpdateRunsModel(String testRunProjectName, List<Integer> caseIds) {
		this.testRunName = testRunProjectName;
		this.includeAll = false;
		this.caseIds = caseIds;
	}
}