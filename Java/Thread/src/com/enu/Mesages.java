package com.enu;

public enum Mesages {
	
	DATABASE(1, "A database error has occured."),
	DUPLICATE_USER(5007, "This user already exists."),
	HTTP_NOTFOUND(404, "Not found."),
	HTTP_O(200, "Ok.");

	private int _id = 1;
	private String _strMessage = ""; 
	
	private Mesages(int id, String sMessage){
		this._id = id;
		this._strMessage = sMessage;
	}
	
	  public int getId() { return _id; }
	  public String getMessage() { return _strMessage; }
	  
	  @Override
	  public String toString(){
		  return String.format("Error code:%s\t,Error Message:%s", _id,_strMessage) ;
		  
	  }

}
