
public abstract class DBOperations {

	public abstract String getConnection();
		
	public  boolean doOerations(){
		 boolean bFlag = false;
		try{
		getConnection();
		update();
		save();
		delete();
		closeConnection();
		}catch(Exception ex){
			
		}
		return bFlag;
	}
	
	public boolean closeConnection(){
		return true;
	}
	
	public boolean delete(){
		return true;
	}
	
	public boolean save(){
		return true;
	}
	
	public boolean update(){
		return true;
	}
}
