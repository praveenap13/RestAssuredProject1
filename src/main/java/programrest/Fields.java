package programrest;

import java.util.List;

public class Fields {
	
    private String summary;
    private String description;
    private Project project;
    private IssueType issueType;
    
    public Fields(String summary,String description,Project project,IssueType issueType) {
    	this.summary=summary;
    	this.description=description;
    	this.project=project;
    	this.issueType=issueType;
    }
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public IssueType getIssueType() {
		return issueType;
	}
	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
}
