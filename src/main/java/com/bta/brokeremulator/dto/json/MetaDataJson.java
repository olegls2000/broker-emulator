
package com.bta.brokeremulator.dto.json;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"1. Information",
		"2. Symbol",
		"3. Last Refreshed",
		"4. Time Zone"
})
public class MetaDataJson {

	@JsonProperty("1. Information")
	private String information;

	@JsonProperty("2. Symbol")
	private String symbol;

	@JsonProperty("3. Last Refreshed")
	private String lastRefreshed;

	@JsonProperty("4. Time Zone")
	private String timeZone;
}
