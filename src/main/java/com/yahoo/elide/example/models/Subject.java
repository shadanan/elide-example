/*
 * Copyright (c) 2015 Yahoo! Inc. All Rights Reserved.
 */
package com.yahoo.elide.example.models;

import com.yahoo.elide.annotation.Include;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Model representing a person. It is rootable
 */
@Entity
@Table(name = "subject")
@Include(rootLevel = true)
public class Subject {
    @Id @GeneratedValue private long id;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String email;
    @Getter @Setter private String phoneNumber;
    private List<LogEntry> logEntries;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany
    public List<LogEntry> getLogEntries() {
        return logEntries;
    }

    public void setLogEntries(List<LogEntry> logEntries) {
        this.logEntries = logEntries;
    }
}
