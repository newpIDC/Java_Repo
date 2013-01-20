package com.wellsfargo;

public class Employee implements Person{
   private 	String Name;
   private  String EmpID;

   public String getEmpID() {
	return EmpID;
   }


   public void setEmpID(String empID) {
	EmpID = empID;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

@Override
public String toString() {
	return "Employee [Name=" + Name + "]";
}
   

}
