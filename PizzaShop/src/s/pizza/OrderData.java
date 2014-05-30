package s.pizza;

import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class OrderData {
      @PrimaryKey
      @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
      private Long id;
     
    @Persistent
    private String order;
     
    @Persistent
    private String url;
     
    @Persistent
    private String comment;
     
    @Persistent
    private Date datetime;

    public OrderData(String order, String url, String comment, Date datetime) {
        super();
        this.order = order;
        this.url = url;
        this.comment = comment;
        this.datetime = datetime;
        
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getOrder() {
        return order;
    }
    
    public void setOrder(String order) {
        this.order = order;
    }
 
    public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }
 
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
 
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
}
