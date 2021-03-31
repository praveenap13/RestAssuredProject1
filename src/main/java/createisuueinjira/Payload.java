package createisuueinjira;

public class Payload {
	private Projects project;
	private String summary;
	private String description;
	private IssueType issuetype;
	public Payload(Projects project, String summary, String description, IssueType issuetype) {
		
		this.project = project;
		this.summary = summary;
		this.description = description;
		this.issuetype = issuetype;
	}
	public Projects getProject() {
		return project;
	}
	public void setProject(Projects project) {
		this.project = project;
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
	public IssueType getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}
	

}
