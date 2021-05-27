package integration.model.results.addResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Accessors(chain = true)
public class ResultsForCasesListModel{

	@JsonProperty("results")
	private List<AddTestCaseResultModel> results;
}