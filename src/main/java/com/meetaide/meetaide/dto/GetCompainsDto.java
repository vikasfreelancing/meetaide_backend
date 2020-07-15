package com.meetaide.meetaide.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class GetCompainsDto {
    private List<Campaign> campaigns;
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    @ToString
    public static class Campaign{
        private String id;
        Recipients recipients;

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        @ToString
        public static class Recipients{
            @JsonProperty("list_id")
            private String listId;
        }
    }
}
