
package model;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Note implements Serializable{
    public String content;
    public Date dateCreate;
    public Date deadline;
    public int status;
    public String StrDate;
    public String DeadlineString;
    public String strStatus;
    public Note( String cont, Date deadline) {
        this.dateCreate = new Date();
        this.content = cont;
        this.deadline = deadline;
        this.status = 0;
        setStatus(status);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        StrDate = formatter.format(dateCreate); 
    }
    
    public void setCreateDate(Date date) {
        this.dateCreate = date;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        StrDate = formatter.format(dateCreate); 
    }
    
    public Date getCreateDate() {
        return dateCreate;
    }
    
    public Date getDealine() {
        return deadline;
    }
    
    public void SetDeadline(Date dl) {
        this.deadline = dl;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        DeadlineString =  formatter.format(deadline); 
    }
    
    public void setStrDeadline(String str) {
        DeadlineString = str;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int state) {
        status = state;
        if(status == 1) strStatus = "Finished";
        if(status == 0) strStatus = "Ongoing";
        if(status == 2) strStatus = "Overdue";
    }
    
    public void setStrStatus(String s) {
        if(s == "Ongoing") 
            if(this.deadline.before(Calendar.getInstance().getTime())) {
                this.status = 2;
                this.strStatus = "Overdue";
            }
            else {
                this.status = 0;
                this.strStatus = "Ongoing";
            }
        else {
            this.strStatus = "Finished";
            this.status = 1;
        }
    }
    
    public String getStrDate() {
        return this.StrDate;
    }
    
    public Object[] toObject() {
        return new Object[] {
            StrDate, content, DeadlineString, strStatus
        };
    }
}
