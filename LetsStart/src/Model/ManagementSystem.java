package Model;



public class ManagementSystem implements ManagementSystemModel
{

	private Status status;
	private Requirement requirement;
	private RequirementList requirementList;
	private TeamMemberList teamMemberList;
	private ManagementSystemFile managementSystemFile;
	private ManagementSystemFile managementSystemFile;
	private Project project;
	private ProjectList projectList;
	private ProjectList projectList;
	private ManagementSystemPersistence managementSystemPersistence;
	public ManagementSystem() {

	}


	/**
	 * @see ManagementSystemModel#addProject(model.Project)
	 */
	public void addProject(Project project) {

	}


	/**
	 * @see ManagementSystemModel#addRequierment(model.Requirement)
	 */
	public void addRequierment(Requirement requirement) {

	}


	/**
	 * @see ManagementSystemModel#addTask(model.Task)
	 */
	public void addTask(Task task) {

	}


	/**
	 * @see ManagementSystemModel#getProject()
	 */
	public Project getProject() {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getRequirement()
	 */
	public Requirement getRequirement() {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getTask()
	 */
	public Task getTask() {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getAllProjects()
	 */
	public ProjectList getAllProjects() {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getAllRequirements()
	 */
	public RequirementList getAllRequirements() {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getAllTasks()
	 */
	public TaskList getAllTasks() {
		return null;
	}


	/**
	 * @see ManagementSystemModel#removeProject(model.Project)
	 */
	public void removeProject(Project project) {

	}


	/**
	 * @see ManagementSystemModel#removeRequirement(model.Requirement, model.Project)
	 */
	public void removeRequirement(Requirement requirement, Project project) {

	}


	/**
	 * @see ManagementSystemModel#removeTask(model.Task, model.Project)
	 */
	public void removeTask(Task task, Project project) {

	}


	/**
	 * @see ManagementSystemModel#updateRequirementStatus(model.Status)
	 */
	public void updateRequirementStatus(Status requirementStatus) {

	}


	/**
	 * @see ManagementSystemModel#updateTaskStatus(model.Status)
	 */
	public void updateTaskStatus(Status taskStatus) {

	}


	/**
	 * @see ManagementSystemModel#updateProjectStatus(model.Status)
	 */
	public void updateProjectStatus(Status projectStatus) {

	}


	/**
	 * @see ManagementSystemModel#changeTaskPriority(model.Priority)
	 */
	public void changeTaskPriority(Priority priority) {

	}


	/**
	 * @see ManagementSystemModel#changeRequirementPriority(model.Priority)
	 */
	public void changeRequirementPriority(Priority priority) {

	}


	/**
	 * @see ManagementSystemModel#addTeamMember(model.TeamMember)
	 */
	public void addTeamMember(TeamMember member) {

	}


	/**
	 * @see ManagementSystemModel#removeTeamMember(String)
	 */
	public void removeTeamMember(String ID) {

	}


	/**
	 * @see ManagementSystemModel#assignRole(model.Role, model.TeamMember)
	 */
	public void assignRole(Role role, TeamMember member) {

	}


	/**
	 * @see ManagementSystemModel#getResponsibleTeamMember(model.Requirement)
	 */
	public TeamMember getResponsibleTeamMember(Requirement requirement) {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getResponsibleTeamMember(model.Task)
	 */
	public TeamMember getResponsibleTeamMember(Task task) {
		return null;
	}


	/**
	 * @see ManagementSystemModel#setDeadline(model.MyDateTime)
	 */
	public void setDeadline(MyDateTime date) {

	}


	/**
	 * @see ManagementSystemModel#getRequirementStatus(model.Requirement)
	 */
	public Status getRequirementStatus(Requirement requirement) {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getTaskStatus(model.Task)
	 */
	public Status getTaskStatus(Task task) {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getProjectStatus(model.Project)
	 */
	public Status getProjectStatus(Project project) {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getTotalTimeSpent(model.Project)
	 */
	public MyDateTime getTotalTimeSpent(Project project) {
		return null;
	}


	/**
	 * @see ManagementSystemModel#setEstimatedTime(model.MyDateTime, model.Requirement)
	 */
	public void setEstimatedTime(MyDateTime time, Requirement requirement) {

	}


	/**
	 * @see ManagementSystemModel#setEstimatedTime(model.MyDateTime, model.Task)
	 */
	public void setEstimatedTime(MyDateTime time, Task task) {

	}


	/**
	 * @see ManagementSystemModel#getEstimatedTime(model.Requirement)
	 */
	public MyDateTime getEstimatedTime(Requirement requirement) {
		return null;
	}


	/**
	 * @see ManagementSystemModel#getEstimatedTime(model.Task)
	 */
	public MyDateTime getEstimatedTime(Task task) {
		return null;
	}

}
