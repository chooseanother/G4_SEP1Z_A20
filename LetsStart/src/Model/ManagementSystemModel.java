package Model;

public interface ManagementSystemModel {
	void addProject(Project project);
	void addRequierment(Requirement requirement);
	void addTask(Task task);
	Project getProject();
	Requirement getRequirement();
	Task getTask();
	ProjectList getAllProjects();
	RequirementList getAllRequirements();
	TaskList getAllTasks();
	void removeProject(Project project);
	void removeRequirement(Requirement requirement, Project project);
	void removeTask(Task task, Project project);
	void updateRequirementStatus(Status requirementStatus);
	void updateTaskStatus(Status taskStatus);
	void updateProjectStatus(Status projectStatus);
	void changeTaskPriority(Priority priority);
	void changeRequirementPriority(Priority priority);
	void addTeamMember(TeamMember member);
	void removeTeamMember(String ID);
	void assignRole(Role role, TeamMember member);
	TeamMember getResponsibleTeamMember(Requirement requirement);
	TeamMember getResponsibleTeamMember(Task task);
	void setDeadline(MyDate date);
	Status getRequirementStatus(Requirement requirement);
	Status getTaskStatus(Task task);
	Status getProjectStatus(Project project);
	int getTotalTimeSpent(Project project);
	void setEstimatedTime(MyDate time, Requirement requirement);
	void setEstimatedTime(MyDate time, Task task);
	MyDate getEstimatedTime(Requirement requirement);
	MyDate getEstimatedTime(Task task);

}
