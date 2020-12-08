package Model;

public interface ManagementSystemModel {
	void addProject(Project project);
	void addRequirement(String projectID, Requirement requirement);
	void addTask(String projectID, String requirementID, Task task);
	Project getProject(String id);
	Requirement getRequirement(String projectID, String reqID);
	Task getTask(String projectID, String reqID, String taskID);
	ProjectList getAllProjects();
	RequirementList getAllRequirements(String projectID);
	TaskList getAllTasks(String projectID, String reqID);
	void removeProject(Project project);
	void removeRequirement(Requirement requirement, String projectID);
	void removeTask(Task task, String reqID, String projectID);
	void updateRequirementStatus(String requirementStatus, String projectID, String reqID);
	void updateTaskStatus(String taskStatus, String taskID, String reqID, String projectID);
	void updateProjectProgress(String projectID);
	void removeTask(String taskID,String reqID, String projectID);
	void changeTaskPriority(Priority priority, String taskID, String reqID, String projectID);
	void changeRequirementPriority(Priority priority, String reqID, String projectID);
	void addTeamMember(TeamMember member, String projectID);
	void removeTeamMember(String ID, String projectID);
	void assignRole(Role role, String memberID, String projectID);
	TeamMember getResponsibleTeamMember(String requirementID, String projectID);
	TeamMember getResponsibleTeamMember(String taskID, String reqID, String projectID);
	void setProjectDeadline(MyDate date, String projectID);
	void setRequirementDeadline(MyDate date, String reqID, String projectID);
	void setTaskDeadline(MyDate date, String taskID, String reqID, String projectID);
	Status getRequirementStatus(String requirementID, String projectID);
	Status getTaskStatus(String taskID, String reqID, String projectID);
	double getProjectProgress(String projectID);
	int getTotalTimeSpent(String projectID);
	void setEstimatedTime(int time, String requirementID, String projectID);
	void setEstimatedTime(int time, String taskID, String reqID, String projectID);
	int getEstimatedRequirementTime(String requirementID, String projectID);
	int getEstimatedTaskTime(String taskID, String requirementID, String projectID);

}
