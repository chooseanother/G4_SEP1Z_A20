package Model;



public class ManagementSystem implements ManagementSystemModel
{

	private Status status;
	private Requirement requirement;
	private RequirementList requirementList;
	private TeamMemberList teamMemberList;
	//private ManagementSystemFile managementSystemFile;
	private Project project;
	private ProjectList projectList;
	//private ManagementSystemPersistence managementSystemPersistence;
	public ManagementSystem() {

	}


	/**
	 *
	 */
	public void addProject(Project project) {

	}


	/**
	 *
	 */
	public void addRequirement(Requirement requirement) {

	}


	/**
	 *
	 */
	public void addTask(Task task) {

	}


	/**
	 *
	 */
	public Project getProject() {
		return null;
	}


	/**
	 *
	 */
	public Requirement getRequirement() {
		return null;
	}


	/**
	 *
	 */
	public Task getTask() {
		return null;
	}


	/**
	 *
	 */
	public ProjectList getAllProjects() {
		return null;
	}


	/**
	 *
	 */
	public RequirementList getAllRequirements() {
		return null;
	}


	/**
	 *
	 */
	public TaskList getAllTasks() {
		return null;
	}


	/**
	 *
	 */
	public void removeProject(Project project) {

	}


	/**
	 *
	 */
	public void removeRequirement(Requirement requirement, Project project) {

	}


	/**
	 *
	 */
	public void removeTask(Task task, Project project) {

	}


	/**
	 *
	 */
	public void updateRequirementStatus(Status requirementStatus) {

	}


	/**
	 *
	 */
	public void updateTaskStatus(Status taskStatus) {

	}


	/**
	 *
	 */
	public void updateProjectStatus(Status projectStatus) {

	}


	/**
	 *
	 */
	public void changeTaskPriority(Priority priority) {

	}


	/**
	 *
	 */
	public void changeRequirementPriority(Priority priority) {

	}


	/**
	 *
	 */
	public void addTeamMember(TeamMember member) {

	}


	/**
	 *
	 */
	public void removeTeamMember(String ID) {

	}


	/**
	 *
	 */
	public void assignRole(Role role, TeamMember member) {

	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(Requirement requirement) {
		return null;
	}


	/**
	 *
	 */
	public TeamMember getResponsibleTeamMember(Task task) {
		return null;
	}


	/**
	 *
	 */
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
