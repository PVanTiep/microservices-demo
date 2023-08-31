package com.microservices.demo.twitter.to.kafka.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class WikimediaRecentChangeDto {
    @JsonProperty("$schema")
    private String Rcschema;
    private RCMeta meta;
    private long id;
    private String type;
    private long namespace;
    private String title;
    @JsonProperty("title_url")
    private String titleUrl;
    private String comment;
    private long timestamp;
    private String user;
    private boolean bot;
    @JsonProperty("notify_url")
    private String notifyUrl;
    private boolean minor;
    private boolean patrolled;
    private RCLength length;
    private RCRevision revision;
    @JsonProperty("server_url")
    private String serverUrl;
    @JsonProperty("server_name")
    private String serverName;
    @JsonProperty("server_script_path")
    private String serverScriptPath;
    private String wiki;
    private String parsedcomment;

    @Data
    public class RCLength {
        private long old;
        @JsonProperty("new")
        private long lennew;
    }

    @Data
    public class RCRevision {
        private long old;
        @JsonProperty("new")
        private long rvnew;
    }

    @Data
    public class RCMeta {
        private String uri;
        @JsonProperty("request_id")
        private String requestId;
        private String id;
        private Date dt;
        private String domain;
        private String stream;
        private String topic;
        private long partition;
        private long offset;
    }
}

