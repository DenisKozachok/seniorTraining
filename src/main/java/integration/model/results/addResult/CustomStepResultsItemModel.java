package integration.model.results.addResult;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomStepResultsItemModel{

	@JsonProperty("actual")
	private String actual;

	@JsonProperty("status_id")
	private int statusId;

	@JsonProperty("expected")
	private String expected;

	@JsonProperty("content")
	private String content;
}