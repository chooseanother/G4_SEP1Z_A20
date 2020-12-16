package Model;

/**
 * Interface handling all communication between views and the {@link ManagementSystem}
 * @author Kim
 */
public interface ManagementSystemModel {
	/**
	 *
	 * @param project
	 */
	void addProject(Project project);
	/**
	 *
	 * @param projectId
	 * @param requirement
	 */
	void addRequirement(int projectId, Requirement requirement);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 * @param task
	 */
	void addTask(int projectId, int requirementId, Task task);
	/**
	 *
	 * @param projectId
	 * @param member
	 */
	void addTeamMember(int projectId, TeamMember member);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 * @param taskId
	 * @param member
	 */
	void addTeamMember(int projectId, int requirementId, int taskId, TeamMember member);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 * @param description
	 * @param time
	 * @param status
	 * @param priority
	 * @param responsible
	 */
	void editRequirement(int projectId, int requirementId, String description, int time, String status, Priority priority, TeamMember responsible);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 * @param taskId
	 * @param title
	 * @param responsible
	 * @param status
	 * @param timeSpent
	 * @param estimate
	 */
	void editTask(int projectId, int requirementId, int taskId, String title, TeamMember responsible, String status, int timeSpent, int estimate);
	/**
	 *
	 * @param id
	 * @return
	 */
	Project getProject(int id);
	/**
	 *
	 * @return
	 */
	ProjectList getAllProjects();
	/**
	 *
	 * @param projectId
	 * @param memberId
	 * @return
	 */
	TeamMember getTeamMember(int projectId, int memberId);
	/**
	 *
	 * @param projectId
	 * @return
	 */
	TeamMemberList getAllTeamMembers(int projectId);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 * @return
	 */
	Requirement getRequirement(int projectId, int requirementId);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 * @param taskId
	 * @return
	 */
	Task getTask(int projectId, int requirementId, int taskId);
	/**
	 *
	 * @param projectId
	 */
	void removeProject(int projectId);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 */
	void removeRequirement(int projectId, int requirementId);
	/**
	 *
	 * @param projectId
	 * @param id
	 */
	void removeTeamMember(int projectId, int id);
	/**
	 *
	 * @param projectId
	 * @param requirementId
	 * @param taskId
	 * @param id
	 */
	void removeTeamMember(int projectId, int requirementId, int taskId, int id);
	/**
	 *
	 * @param projectId
	 */
	void updateProjectProgress(int projectId);
	/**
	 * Saves a {@link ProjectList} to a json file
	 */
	void saveToFile();
	/**
	 * Loads a json file that contains a {@link ProjectList}
	 */
	void loadFromFile();
}
