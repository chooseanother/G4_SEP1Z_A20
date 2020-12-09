package Model;

public interface ManagementSystemModel {
	void addProject(Project project);
	void addRequirement(int projectID, Requirement requirement);
	void addTask(int projectID, int requirementID, Task task);
	Project getProject(int id);
	Requirement getRequirement(int projectID, int reqID);
	Task getTask(int projectID, int reqID, int taskID);
	ProjectList getAllProjects();
	RequirementList getAllRequirements(int projectID);
	TaskList getAllTasks(int projectID, int reqID);
	void removeProject(Project project);
	void removeRequirement(Requirement requirement, int projectID);
	void removeTask(Task task, int reqID, int projectID);
	void updateRequirementStatus(int projectID, int reqID);
	void updateTaskStatus(String taskStatus, int taskID, int reqID, int projectID);
	void updateProjectProgress(int projectID);
	void removeTask(int taskID,int reqID, int projectID);
	void changeRequirementPriority(Priority priority, int reqID, int projectID);
	void addTeamMember(TeamMember member, int projectID);
	void removeTeamMember(String ID, int projectID);
	void assignRole(Role role, String memberID, int projectID);
	TeamMember getResponsibleTeamMember(int requirementID, int projectID);
	TeamMember getResponsibleTeamMember(int taskID, int reqID, int projectID);
	Status getRequirementStatus(int requirementID, int projectID);
	String getTaskStatus(int taskID, int reqID, int projectID);
	double getProjectProgress(int projectID);
	int getTotalTimeSpent(int projectID);
	int getEstimatedRequirementTime(int requirementID, int projectID);
	int getEstimatedTaskTime(int taskID, int requirementID, int projectID);
}
