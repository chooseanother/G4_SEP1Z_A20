package Model;



public class ManagementSystem implements ManagementSystemModel
{

	private Status status;
	private Task task;
	private Requirement requirement;
	private RequirementList requirementList;
	private TeamMemberList teamMemberList;
	//private ManagementSystemFile managementSystemFile;
	private Project project;
	private ProjectList projectList;
	private TaskList taskList;
	//private ManagementSystemPersistence managementSystemPersistence;
	public ManagementSystem() {
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
    requirementList.addRequirement(requirement);
	}


	/**
	 *
	 */
	public void addTask(Task task) {
   taskList.addTask(task);
	}


	/**
	 *
	 */
	public Project getProject() {
		return project;
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
