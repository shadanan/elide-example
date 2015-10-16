package com.yahoo.elide.example.models;

import com.yahoo.elide.annotation.Include;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by shad on 15-10-16.
 */
@Entity
@Table(name = "logentry")
@Include(rootLevel = true)
public class LogEntry {
    @Id @GeneratedValue private long id;
    @Getter @Setter private String logMessage;
}
