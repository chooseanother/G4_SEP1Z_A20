package Model;

import Model.mediator.ManagementSystemFile;
import Model.mediator.ManagementSystemPersistence;

/**
 * Implementation of {@link ManagementSystemModel}
 * @author Kim
 */
public class ManagementSystem implements ManagementSystemModel
{
	private ProjectList projectList;
	private ManagementSystemPersistence MSP;

	/**
	 * Initializes:
	 * <ul style="list-style-type:none;">
	 *   <li>{@link ProjectList} of a managing system</li>
	 *   <li>{@link ManagementSystemFile} of a managing system</li>
	 * </ul>
	 */
	public ManagementSystem()
	{
		projectList = new ProjectList();
		MSP = new ManagementSystemFile();
	}

	@Override public void addProject(Project project)
	{
		projectList.addProject(project);
	}

	@Override public void addRequirement(int projectId, Requirement requirement)
	{
		projectList.getProject(projectId).
				addRequirement(requirement);
	}

	@Override public void addTask(int projectId, int requirementId, Task task)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().addTask(task);
	}

	@Override public void addTeamMember(int projectId, TeamMember member)
	{
		projectList.getProject(projectId).getTeamMemberList().addTeamMember(member);
	}

	@Override public void addTeamMember(int projectId, int requirementId,
			int taskId, TeamMember member)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				addTeamMember(member);
	}

	@Override public void editRequirement(int projectId, int requirementId, String description, int time, String status, Priority priority, TeamMember responsible){
		Requirement edit = projectList.getProject(projectId).getRequirementList().getRequirementId(requirementId);
		edit.setDescription(description);
		edit.setEstimatedTime(time);
		edit.setStatus(status);
		edit.setPriority(priority);
		edit.changeResponsibleTeamMember(responsible);
	}

	@Override public void editTask(int projectId, int requirementId, int taskId, String title, TeamMember responsible, String status, int timeSpent, int estimate){
		Task edit = getTask(projectId,requirementId,taskId);
		edit.setTitle(title);
		edit.changeResponsibleTeamMember(responsible);
		edit.updateStatus(status);
		edit.updateHoursSpent(timeSpent);
		edit.setEstimatedHours(estimate);
	}

	@Override public Project getProject(int id)
	{
		return projectList.getProject(id);
	}

	@Override public ProjectList getAllProjects()
	{
		return projectList;
	}

	@Override public TeamMember getTeamMember(int projectId, int memberId)
	{
		return projectList.getProject(projectId).getTeamMemberList().
				getTeamMember(memberId);
	}

	@Override public TeamMemberList getAllTeamMembers(int projectId)
	{
		return projectList.getProject(projectId).getTeamMemberList();
	}

	@Override public Requirement getRequirement(int projectId, int requirementId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId);
	}

	@Override public Task getTask(int projectId, int requirementId, int taskId)
	{
		return projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId);
	}

	@Override public void removeProject(int projectId)
	{
		projectList.removeProject(projectId);
	}

	@Override public void removeRequirement(int projectId, int requirementId)
	{
		projectList.getProject(projectId).getRequirementList().
				removeRequirement(requirementId);
	}

	@Override public void removeTeamMember(int projectId, int id)
	{
		projectList.getProject(projectId).getTeamMemberList().
				removeTeamMember(id);
	}


	@Override public void removeTeamMember(int projectId, int requirementId,
			int taskId, int id)
	{
		projectList.getProject(projectId).getRequirementList().
				getRequirementId(requirementId).getAllTasks().getTaskId(taskId).
				removeTeamMember(id);
	}

	@Override public void updateProjectProgress(int projectId)
	{
		projectList.getProject(projectId).updateProgress();
	}

	@Override public void saveToFile(){
		MSP.save(projectList, "Project_List.json");
	}

	@Override public void loadFromFile(){
		projectList = MSP.load("Project_List.json");
	}
}
