package Model;

public interface ManagementSystemModel {
	void addProject(Project project);
	void addRequirement(int projectId, Requirement requirement);
	void addTask(int projectId, int requirementId, Task task);
	void addTeamMember(int projectId, TeamMember member);
	void addTeamMember(int projectId, int requirementId, int taskId, TeamMember member);
	void editRequirement(int projectId, int requirementId, String description, int time, String status, Priority priority, TeamMember responsible);
	void editTask(int projectId, int requirementId, int taskId, String title, TeamMember responsible, String status, int timeSpent, int estimate);
	Project getProject(int id);
	ProjectList getAllProjects();
	TeamMember getTeamMember(int projectId, int memberId);
	TeamMemberList getAllTeamMembers(int projectId);
	Requirement getRequirement(int projectId, int requirementId);
	Task getTask(int projectId, int requirementId, int taskId);
	void removeProject(int projectId);
	void removeRequirement(int projectId, int requirementId);
	void removeTeamMember(int projectId, int id);
	void removeTeamMember(int projectId, int requirementId, int taskId, int id);
	void updateProjectProgress(int projectId);
	void saveToFile();
	void loadFromFile();
}
