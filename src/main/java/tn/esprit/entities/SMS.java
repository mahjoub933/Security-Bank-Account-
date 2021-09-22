package tn.esprit.entities;

public class SMS {
    private String to;
    private String message;
    
    

    public SMS() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public SMS(String to, String message) {
		super();
		this.to = to;
		this.message = message;
	}



	public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "SMS{" +
                "to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }}
