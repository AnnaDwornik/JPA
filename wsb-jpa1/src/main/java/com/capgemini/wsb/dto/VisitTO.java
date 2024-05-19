package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitTO implements Serializable  {

    private Long id;

    private String description;

    private LocalDateTime time;

    private RelationsConnectorTO relationsConnector;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public RelationsConnectorTO getRelationsConnector() {
        return relationsConnector;
    }

    public void setRelationsConnector(RelationsConnectorTO relationsConnector) {
        this.relationsConnector = relationsConnector;
    }
}
