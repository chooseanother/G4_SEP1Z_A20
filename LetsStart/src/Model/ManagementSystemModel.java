package Model;


import view.RequirementViewController;
import view.ProjectViewController;
import view.RequirementListViewController;
import view.TeamMemberListViewController;
import view.NewProjectViewController;
import view.TeamMemberViewController;
import view.NewTaskViewController;
import model.Project;
import model.Requirement;
import model.Task;
import model.ProjectList;
import model.RequirementList;
import model.TaskList;
import model.Status;
import model.Priority;
import model.TeamMember;
import model.Role;
import model.MyDateTime;

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
	void setDeadline(MyDateTime date);
	Status getRequirementStatus(Requirement requirement);
	Status getTaskStatus(Task task);
	Status getProjectStatus(Project project);
	MyDateTime getTotalTimeSpent(Project project);
	void setEstimatedTime(MyDateTime time, Requirement requirement);
	void setEstimatedTime(MyDateTime time, Task task);
	MyDateTime getEstimatedTime(Requirement requirement);
	MyDateTime getEstimatedTime(Task task);

}
