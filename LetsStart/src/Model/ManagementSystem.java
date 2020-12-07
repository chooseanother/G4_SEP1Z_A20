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
	public void addRequirement(Requirement requirement) {
    projectList.addRequirement(requirement);
	}


	/**
	 *
	 */
	public void addTask(Task task) {
		projectList.addTask(task);
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
	public Requirement getRequirement() {
		return requirement;
	}


	/**
	 *
	 */
	public Task getTask() {
		return task;
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
	public RequirementList getAllRequirements() {
		return requirementList;
	}


	/**
	 *
	 */
	public TaskList getAllTasks() {
		return taskList;
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
	public void removeRequirement(Requirement requirement, Project project) {
  project.getRequirementList().removeRequirement(requirement);
	}

	@Override public void removeTask(Task task, Project project)
	{

	}

	@Override public void updateRequirementStatus(Status requirementStatus)
	{

	}

	@Override public void updateTaskStatus(Status taskStatus)
	{

	}

	@Override public void updateProjectStatus(Status projectStatus)
	{

	}

	/**
	 *
	 */
	public void removeTask(Task task,String reqID, Project project) {
  project.getRequirementList().getRequirement(reqID).getTasks().removeTask(task);
	}


	/**
	 *
	 */
	public void updateRequirementStatus(String requirementStatus) {
  requirement.updateStatus(requirementStatus);
	}


	/**
	 *
	 */
	public void updateTaskStatus(String taskStatus) {
  task.updateStatus(taskStatus);
	}


	/**
	 *
	 */
	//might be wrong
	public void updateProjectStatus(String projectStatus) {
   project.updateProgress();
	}


	/**
	 *
	 */
	public void changeTaskPriority(Priority priority) {
  task.setPriority(priority);
	}


	/**
	 *
	 */
	public void changeRequirementPriority(Priority priority) {
  requirement.setPriority(priority);
	}


	/**
	 *
	 */
	public void addTeamMember(TeamMember member) {
  project.addTeamMember(member);
	}


	/**
	 *
	 */
	public void removeTeamMember(String ID) {
  project.removeTeamMember(ID);
	}


	/**
	 *
	 */
	public void assignRole(Role role, TeamMember member) {
   member.assignRole(role);
	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(Requirement requirement) {
		return requirement.getResponsibleTeamMember();
	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(Task task) {
		return task.getResponsibleTeamMember();
	}


	/**
	 *
	 */
	//for what??
	public void setDeadline(MyDate date) {
	}


	/**
	 *
	 */
	public Status getRequirementStatus(Requirement requirement) {
		return null;
	}


	/**
	 *
	 */
	public Status getTaskStatus(Task task) {
		return null;
	}


	/**
	 *
	 */
	public Status getProjectStatus(Project project) {
		return null;
	}


	/**
	 *
	 */
	public int getTotalTimeSpent(Project project) {
		return 0;
	}


	/**
	 *
	 */
	public void setEstimatedTime(int time, Requirement requirement) {

	}


	/**
	 *
	 */
	public void setEstimatedTime(int time, Task task) {

	}


	/**
	 *
	 */
	public int getEstimatedTime(Requirement requirement) {
		return 0;
	}


	/**
	 *
	 */
	public int getEstimatedTime(Task task) {
		return 0;
	}

}
