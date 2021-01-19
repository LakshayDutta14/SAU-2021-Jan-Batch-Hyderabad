package jaxb;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement; 
import java.util.List;
@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Students implements Serializable {
 
    private static final long serialVersionUID = 1L;
     
    @XmlElement(name="student")
    private List<Student> studentlist=null;
     
    public Students() {
        super();
    }
    
    public Students( List<Student> studentlist) {
        super();
        
        this.studentlist = studentlist;
    }
 
    //Setters and Getters
 
    public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}

	@Override
    public String toString() {
        return "Students [student="+ studentlist + "]";
    }

	public int size() {
		
		return this.studentlist.size();
	}

	public Student get(int i) {
		List<Student> s=this.studentlist;
		return s.get(i) ;
	}
}