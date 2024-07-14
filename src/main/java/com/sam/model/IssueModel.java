package com.sam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@Entity
@Table(name = "Issue")
@DynamicInsert
@DynamicUpdate
public class IssueModel {
    private Integer id;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
