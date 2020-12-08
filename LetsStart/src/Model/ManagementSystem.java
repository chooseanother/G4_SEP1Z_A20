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
	public void addRequirement(String projectID, Requirement requirement) {
   projectList.getProject(projectID).addRequirement(requirement);
	}


	/**
	 *
	 */
	public void addTask(String projectID, String requirementID, Task task) {
  projectList.getProject(projectID).getRequirementList().getRequirement(requirementID).addTask(task,requirementID);
	}


	/**
	 *
	 */
	public Project getProject(String id) {
		return projectList.getProject(id);
	}


	/**
	 *
	 */
	public Requirement getRequirement(String projectID, String reqID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(reqID);
	}


	/**
	 *
	 */
	public Task getTask(String projectID, String reqID, String taskID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTask(taskID);
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
	public RequirementList getAllRequirements(String projectID) {
		return projectList.getProject(projectID).getRequirementList();
	}


	/**
	 *
	 */
	public TaskList getAllTasks(String projectID, String reqID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks();
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
	public void removeRequirement(Requirement requirement, String projectID) {
  projectList.getProject(projectID).getRequirementList().removeRequirement(requirement);
	}

	@Override public void removeTask(Task task, String reqID, String projectID)
	{
   projectList.getProject(projectID).getRequirementList().getRequirement(reqID).removeTask(task);
	}

	@Override public void updateRequirementStatus(String requirementStatus, String projectID, String reqID)
	{
    projectList.getProject(projectID).getRequirementList().getRequirement(reqID).updateStatus(requirementStatus);
	}

	@Override public void updateTaskStatus(String taskStatus, String taskID, String reqID, String projectID)
	{
    projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks().getTask(taskID).updateStatus(taskStatus);
	}

	@Override public void updateProjectProgress(String projectID)
	{
    projectList.getProject(projectID).updateProgress();
	}

	/**
	 *
	 */
	public void removeTask(String taskID,String reqID, String projectID) {
  projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks().getTask(taskID);
	}

	/**
	 *
	 */
	public void changeTaskPriority(Priority priority, String taskID, String reqID, String projectID) {
   projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks().getTask(taskID).setPriority(priority);
	}


	/**
	 *
	 */
	public void changeRequirementPriority(Priority priority, String reqID, String projectID) {
   projectList.getProject(projectID).getRequirementList().getRequirement(reqID).setPriority(priority);
	}


	/**
	 *
	 */
	public void addTeamMember(TeamMember member, String projectID) {
   projectList.getProject(projectID).addTeamMember(member);
	}


	/**
	 *
	 */
	public void removeTeamMember(String ID, String projectID) {
   projectList.getProject(projectID).removeTeamMember(ID);
	}


	/**
	 *
	 */
	public void assignRole(Role role, String memberID, String projectID) {
   projectList.getProject(projectID).getTeamMemberList().getTeamMember(memberID).assignRole(role);
	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(String requirementID, String projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(requirementID).getResponsibleTeamMember();
	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(String taskID, String reqID, String projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks().getTask(taskID).getResponsibleTeamMember();
	}


	/**
	 *
	 */
	public void setProjectDeadline(MyDate date, String projectID) {
  projectList.getProject(projectID).setDeadline(date);
	}
  public void setRequirementDeadline(MyDate date, String reqID, String projectID){
		projectList.getProject(projectID).getRequirementList().getRequirement(reqID).setDeadline(date);
	}
	public void setTaskDeadline(MyDate date, String taskID, String reqID, String projectID)
	{
    projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks().getTask(taskID).setDeadline(date);
	}

	/**
	 *
	 */
	public Status getRequirementStatus(String requirementID, String projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(requirementID).getStatus();
	}


	/**
	 *
	 */
	public Status getTaskStatus(String taskID, String reqID, String projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks().getTask(taskID).getStatus();
	}


	/**
	 *
	 */
	public double getProjectProgress(String projectID) {
		return projectList.getProject(projectID).getProgress();
	}


	/**
	 *
	 */
	public int getTotalTimeSpent(String projectID) {
		return projectList.getProject(projectID).getTotalHoursSpent();
	}


	/**
	 *
	 */
	public void setEstimatedTime(int time, String requirementID, String projectID) {
    projectList.getProject(projectID).getRequirementList().getRequirement(requirementID).setEstimatedTime(time);
	}


	/**
	 *
	 */
	public void setEstimatedTime(int time, String taskID, String reqID, String projectID) {
  projectList.getProject(projectID).getRequirementList().getRequirement(reqID).getTasks().getTask(taskID).setEstimatedTime(time);
	}


	/**
	 *
	 */
	public int getEstimatedRequirementTime(String requirementID, String projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(requirementID).getEstimatedTime();
	}


	/**
	 *
	 */
	public int getEstimatedTaskTime(String taskID, String requirementID, String projectID) {
		return projectList.getProject(projectID).getRequirementList().getRequirement(requirementID).getTasks().getTask(taskID).getEstimatedHours();
	}

}
