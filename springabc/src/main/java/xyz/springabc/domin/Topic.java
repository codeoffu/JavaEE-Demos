package xyz.springabc.domin;
// Generated 2015-11-14 18:40:02 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Topic generated by hbm2java
 */
@Entity
@Table(name = "topic", catalog = "spring_winds")
public class Topic implements java.io.Serializable {
	private static final long serialVersionUID = -4854566491341847894L;
	private Integer id;
	private Node node;
	private User user;
	@NotNull(message="内容不能为空")
	@Size(min=6,max=60000,message="内容六到六万个字符")
	private String content;
	private Date createAt;
	private Date lastCommentAt;
	private Integer lastCommentUserId;
	
	@Transient
	private User LastCommentUser;
	
	private Long likeCount=0L;
	private Long score=0L;
	private Integer status;
	@NotNull(message="标题不能为空")
	@Size(min=6,max=60,message="标题六到六十个字符")
	private String title;
	private Date updateAt;
	private Long viewCount=0L;
	private Long commentCount=0L;
	private Integer collectonId;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Collection> collections = new HashSet<Collection>(0);

	public Topic() {
	}

	public Topic(Node node, User user, String content, String title) {
		this.node = node;
		this.user = user;
		this.content = content;
		this.title = title;
	}

	public Topic(Node node, User user, String content, Date createAt, Date lastCommentAt, Integer lastCommentUserId,
			Long likeCount, Long score, Integer status, String title, Date updateAt,
			Long viewCount, Long commentCount, Integer collectonId, Set<Comment> comments,
			Set<Collection> collections) {
		this.node = node;
		this.user = user;
		this.content = content;
		this.createAt = createAt;
		this.lastCommentAt = lastCommentAt;
		this.lastCommentUserId = lastCommentUserId;
		this.likeCount = likeCount;
		this.score = score;
		this.status = status;
		this.title = title;
		this.updateAt = updateAt;
		this.viewCount = viewCount;
		this.commentCount = commentCount;
		this.collectonId = collectonId;
		this.comments = comments;
		this.collections = collections;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "node_id", nullable = false)
	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at", length = 19)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_comment_at", length = 19)
	public Date getLastCommentAt() {
		return this.lastCommentAt;
	}

	public void setLastCommentAt(Date lastCommentAt) {
		this.lastCommentAt = lastCommentAt;
	}

	@Column(name = "last_comment_user_id")
	public Integer getLastCommentUserId() {
		return this.lastCommentUserId;
	}

	public void setLastCommentUserId(Integer lastCommentUserId) {
		this.lastCommentUserId = lastCommentUserId;
	}

	public User getLastCommentUser() {
		return LastCommentUser;
	}

	public void setLastCommentUser(User lastCommentUser) {
		LastCommentUser = lastCommentUser;
	}

	@Column(name = "like_count")
	public Long getLikeCount() {
		return this.likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	@Column(name = "score")
	public Long getScore() {
		return this.score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	@Column(name = "status",nullable=false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at", length = 19)
	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Column(name = "view_count")
	public Long getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "comment_count")
	public Long getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	@Column(name = "collecton_id")
	public Integer getCollectonId() {
		return this.collectonId;
	}

	public void setCollectonId(Integer collectonId) {
		this.collectonId = collectonId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

}