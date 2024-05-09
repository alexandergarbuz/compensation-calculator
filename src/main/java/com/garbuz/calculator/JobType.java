package com.garbuz.calculator;

public enum JobType {
	
    INTERN("Intern"),
    FLOOR_WORKER("Floor worker"),
    SUPERVISOR("Supervisor"),
    MANAGER("Manager"),
    EXECUTIVE("Executive");

    private final String jobType;

    JobType(String typeName) {
        this.jobType = typeName;
    }

    public String getTypeName() {
        return jobType;
    }
}

