package Model;

import Model.mediator.ManagementSystemFile;
import Model.mediator.ManagementSystemPersistence;

public class ManagementSystem implements ManagementSystemModel
{

	private ProjectList projectList;
	private ManagementSystemPersistence MSP;

	public ManagementSystem()
	{
		projectList = new ProjectList();
		MSP = new ManagementSystemFile();
	}

	/**
	 *
	 */
	@Override public void addProject(Project project)
	{
		projectList.addProject(project);
	}

	/**
	 *
	 */
	@Override public void addRequirement(int projectId, Requirement requirement)
	{
		projectList.getProject(projectId).getRequirementList().
				addRequirement(requirement);
	}

	/**
	 *
	 */
	@Override public void addTask(int projectId, int requirementId, Task task)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().addTask(task);
	}

	/**
	 *
	 */
	@Override public void addTeamMember(int projectId, TeamMember member)
	{
		projectList.getProject(projectId).getTeamMemberList().addTeamMember(member);
	}

	/**
	 *
	 */
	@Override public void addTeamMember(int projectId, int requirementId,
			int taskId, TeamMember member)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				addTeamMember(member);
	}

	/**
	 *
	 */
	@Override public void assignRole(int projectId, TeamMember member, Role role)
	{
		projectList.getProject(projectId).getTeamMemberList().
				getTeamMember(member.toString()).assignRole(role);
	}

	/**
	 *
	 */
	@Override public void assignRequirementPriority(int projectId,
			int requirementId, Priority priority)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).setPriority(priority);
	}

	/**
	 *
	 */
	@Override public Project getProject(int id)
	{
		return projectList.getProject(id);
	}

	/**
	 *
	 */
	@Override public ProjectList getAllProjects()
	{
		return projectList;
	}

	/**
	 *
	 */
	@Override public double getProjectProgress(int projectId)
	{
		return projectList.getProject(projectId).getProgress();
	}

	/**
	 *
	 */
	@Override public TeamMember getTeamMember(int projectId, String name)
	{
		return projectList.getProject(projectId).getTeamMemberList().
				getTeamMember(name);
	}

	/**
	 *
	 */
	@Override public TeamMemberList getAllTeamMembers(int projectId)
	{
		return projectList.getProject(projectId).getTeamMemberList();
	}

	/**
	 *
	 */
	@Override public int getTotalTimeSpent(int projectId)
	{
		return projectList.getProject(projectId).getTotalHoursSpent();
	}

	/**
	 *
	 */
	@Override public Requirement getRequirement(int projectId, int requirementId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId);
	}

	/**
	 *
	 */
	@Override public RequirementList getAllRequirements(int projectId)
	{
		return projectList.getProject(projectId).getRequirementList();
	}

	/**
	 *
	 */
	@Override public Status getRequirementStatus(int projectId, int requirementId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getStatus();
	}

	/**
	 *
	 */
	@Override public TeamMember getResponsibleTeamMember(int projectId,
			int requirementId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getResponsibleTeamMember();
	}

	/**
	 *
	 */
	@Override public int getEstimatedTime(int projectId, int requirementId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getEstimatedTime();
	}

	/**
	 *
	 */
	@Override public Task getTask(int projectId, int requirementId, int taskId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId);
	}

	/**
	 *
	 */
	@Override public TaskList getAllTasks(int projectId, int requirementId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks();
	}

	/**
	 *
	 */
	@Override public Status getTaskStatus(int projectId, int requirementId,
			int taskId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).getStatus();
	}

	/**
	 *
	 */
	@Override public TeamMember getResponsibleTeamMember(int projectId,
			int requirementId, int taskId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				getResponsibleTeamMember();
	}

	/**
	 *
	 */
	@Override public TeamMember getTeamMember(int projectId, int requirementId,
			int taskId, String name)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				getAllTeamMembers().getTeamMember(name);
	}

	/**
	 *
	 */
	@Override public TeamMemberList getAllTeamMembers(int projectId,
			int requirementId, int taskId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				getAllTeamMembers();
	}

	/**
	 *
	 */
	@Override public int getEstimatedTime(int projectId, int requirementId,
			int taskId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				getEstimatedTime();
	}

	/**
	 *
	 */
	@Override public void removeProject(int projectId)
	{
		projectList.removeProject(projectId);
	}

	/**
	 *
	 */
	@Override public void removeRequirement(int projectId, int requirementId)
	{
		projectList.getProject(projectId).getRequirementList().
				removeRequirement(requirementId);
	}

	/**
	 *
	 */
	@Override public void removeTask(int projectId, int requirementId, int taskId)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().removeTask(taskId);
	}

	/**
	 *
	 */
	@Override public void removeTeamMember(int projectId, String name)
	{
		projectList.getProject(projectId).getTeamMemberList().
				removeTeamMember(name);
	}

	/**
	 *
	 */
	@Override public void removeTeamMember(int projectId, int requirementId,
			int taskId, String name)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				removeTeamMember(name);
	}

	/**
	 *
	 */
	@Override public void updateProjectProgress(int projectId)
	{
		projectList.getProject(projectId).updateProgress();
	}

	/**
	 *
	 */
	@Override public void updateRequirementStatus(int projectId,
			int requirementId)
	{

	}

	/**
	 *
	 */
	@Override public void updateTaskStatus(int projectId, int requirementId,
			int taskId)
	{

	}

	@Override public void saveToFile(){
		MSP.save(projectList, "Project_List.json");
	}

	@Override public void loadFromFile(){
		projectList = MSP.load("Project_List.json");
	}
}
