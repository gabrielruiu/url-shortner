package gabrielruiu.urlshortner.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
    @Column(name = "last_changed_date", nullable = false)
    private Date lastChangedDate;
    @Column(name = "public_identifier", nullable = false, unique = true)
    private String publicIdentifier;
    @Column(name = "target_url", nullable = false)
    private String targetUrl;
    @Column(name = "deleted_date")
    private Date deletedDate;
    @Column(name = "times_accessed", nullable = false)
    private int timesAccessed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastChangedDate() {
        return lastChangedDate;
    }

    public void setLastChangedDate(Date lastChangedDate) {
        this.lastChangedDate = lastChangedDate;
    }

    public String getPublicIdentifier() {
        return publicIdentifier;
    }

    public void setPublicIdentifier(String publicIdentifier) {
        this.publicIdentifier = publicIdentifier;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public int getTimesAccessed() {
        return timesAccessed;
    }

    public void setTimesAccessed(int timesAccessed) {
        this.timesAccessed = timesAccessed;
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
        this.lastChangedDate = new Date();
        this.timesAccessed = 0;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastChangedDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Url)) return false;
        Url url = (Url) o;
        return timesAccessed == url.timesAccessed &&
                Objects.equals(id, url.id) &&
                Objects.equals(createdDate, url.createdDate) &&
                Objects.equals(lastChangedDate, url.lastChangedDate) &&
                Objects.equals(publicIdentifier, url.publicIdentifier) &&
                Objects.equals(targetUrl, url.targetUrl) &&
                Objects.equals(deletedDate, url.deletedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, lastChangedDate, publicIdentifier, targetUrl, deletedDate, timesAccessed);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Url{");
        sb.append("id=").append(id);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", lastChangedDate=").append(lastChangedDate);
        sb.append(", publicIdentifier='").append(publicIdentifier).append('\'');
        sb.append(", targetUrl='").append(targetUrl).append('\'');
        sb.append(", deletedDate=").append(deletedDate);
        sb.append(", timesAccessed=").append(timesAccessed);
        sb.append('}');
        return sb.toString();
    }
}
