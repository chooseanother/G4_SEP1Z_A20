package Model;
public class ManagementSystem implements ManagementSystemModel
{
	//private ManagementSystemFile managementSystemFile;

	private ProjectList projectList;

	//private ManagementSystemPersistence managementSystemPersistence;

	public ManagementSystem() {
		projectList = new ProjectList();
	}

	/**
	 *
	 */
	 public void addProject(Project project) {
    projectList.addProject(project);
	}


	/**
	 *
	 */
	public void addRequirement(int projectID, Requirement requirement) {
   projectList.getProject(projectID).addRequirement(requirement);
	}


	/**
	 *
	 */
	public void addTask(int projectID, int requirementID, Task task) {
  projectList.getProject(projectID).getRequirementList().getRequirementId(requirementID).addTask(task);
	}


	/**
	 *
	 */
	public Project getProject(int id) {
		return projectList.getProject(id);
	}


	/**
	 *
	 */
	public Requirement getRequirement(int projectID, int reqID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(reqID);
	}


	/**
	 *
	 */
	public Task getTask(int projectID, int reqID, int taskID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).getAllTasks().getTaskId(taskID);
	}


	/**
	 *
	 */
	public ProjectList getAllProjects() {
		return projectList;
	}


	/**
	 *
	 */
	public RequirementList getAllRequirements(int projectID) {
		return projectList.getProject(projectID).getRequirementList();
	}


	/**
	 *
	 */
	public TaskList getAllTasks(int projectID, int reqID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).getAllTasks();
	}


	/**
	 *
	 */
	public void removeProject(Project project) {
  projectList.removeProject(project);
	}


	/**
	 *
	 */
	public void removeRequirement(Requirement requirement, int projectID) {
  projectList.getProject(projectID).getRequirementList().removeRequirement(requirement);
	}

	@Override public void removeTask(Task task, int reqID, int projectID)
	{
   projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).removeTask(task);
	}

	@Override public void updateRequirementStatus(String requirementStatus, int projectID, int reqID)
	{
    projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).updateStatus(requirementStatus);
	}

	@Override public void updateTaskStatus(String taskStatus, int taskID, int reqID, int projectID)
	{
    projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).getAllTasks().getTaskId(taskID).updateStatus(taskStatus);
	}

	@Override public void updateProjectProgress(int projectID)
	{
    projectList.getProject(projectID).updateProgress();
	}

	/**
	 *
	 */
	public void removeTask(int taskID,int reqID, int projectID) {
  projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).getAllTasks().getTaskId(taskID);
	}

	/**
	 *
	 */



	/**
	 *
	 */
	public void changeRequirementPriority(Priority priority, int reqID, int projectID) {
   projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).setPriority(priority);
	}


	/**
	 *
	 */
	public void addTeamMember(TeamMember member, int projectID) {
   projectList.getProject(projectID).addTeamMember(member);
	}


	/**
	 *
	 */
	public void removeTeamMember(String ID, int projectID) {
   projectList.getProject(projectID).removeTeamMember(ID);
	}


	/**
	 *
	 */
	public void assignRole(Role role, String memberID, int projectID) {
   projectList.getProject(projectID).getTeamMemberList().getTeamMember(memberID).assignRole(role);
	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(int requirementID, int projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(requirementID).getResponsibleTeamMember();
	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(int taskID, int reqID, int projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).getAllTasks().getTaskId(taskID).getResponsibleTeamMember();
	}


	/**
	 *
	 */



	/**
	 *
	 */
	public Status getRequirementStatus(int requirementID, int projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(requirementID).getStatus();
	}


	/**
	 *
	 */
	public String getTaskStatus(int taskID, int reqID, int projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(reqID).getAllTasks().getTaskId(taskID).getStatus();
	}


	/**
	 *
	 */
	public double getProjectProgress(int projectID) {
		return projectList.getProject(projectID).getProgress();
	}


	/**
	 *
	 */
	public int getTotalTimeSpent(int projectID) {
		return projectList.getProject(projectID).getTotalHoursSpent();
	}

	/**
	 *
	 */
	public int getEstimatedRequirementTime(int requirementID, int projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(requirementID).getEstimatedTime();
	}

	/**
	 *
	 */
	public int getEstimatedTaskTime(int taskID, int requirementID, int projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirementId(requirementID).getAllTasks().getTaskId(taskID).getEstimatedTime();
	}

}
