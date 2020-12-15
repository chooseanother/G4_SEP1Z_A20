package Model;

public interface ManagementSystemModel {
	void addProject(Project project);
	void addRequirement(int projectId, Requirement requirement);
	void addTask(int projectId, int requirementId, Task task);
	void addTeamMember(int projectId, TeamMember member);
	void addTeamMember(int projectId, int requirementId, int taskId, TeamMember member);
	void assignRole(int projectId, int memberId, Role role);
	void assignRequirementPriority(int projectId, int requirementId, Priority priority);

	void editRequirement(int projectId, int requirementId, String description, int time, String status, Priority priority, TeamMember responsible);

	Project getProject(int id);
	ProjectList getAllProjects();
	double getProjectProgress(int projectId);
	TeamMember getTeamMember(int projectId, int memberId);
	TeamMemberList getAllTeamMembers(int projectId);
	int getTotalTimeSpent(int projectId);

	Requirement getRequirement(int projectId, int requirementId);
	RequirementList getAllRequirements(int projectId);
	Status getRequirementStatus(int projectId, int requirementId);
	TeamMember getResponsibleTeamMember(int projectId, int requirementId);
	int getEstimatedTime(int projectId, int requirementId);

	Task getTask(int projectId, int requirementId, int taskId);
	TaskList getAllTasks(int projectId, int requirementId);
	Status getTaskStatus(int projectId, int requirementId, int taskId);
	TeamMember getResponsibleTeamMember(int projectId, int requirementId, int taskId);
	TeamMember getTeamMember(int projectId, int requirementId, int taskId, int memberId);//implement member id in all model classes
	TeamMemberList getAllTeamMembers(int projectId, int requirementId, int taskId);
	int getEstimatedTime(int projectId, int requirementId, int taskId);

	void removeProject(int projectId);
	void removeRequirement(int projectId, int requirementId);
	void removeTask(int projectId, int requirementId, int taskId);
	void removeTeamMember(int projectId, String name);
	void removeTeamMember(int projectId, int requirementId, int taskId, String name);

	void updateProjectProgress(int projectId);
	void updateRequirementStatus(int projectId, int requirementId);
	void updateTaskStatus(int projectId, int requirementId, int taskId);

	void saveToFile();
	void loadFromFile();
}
