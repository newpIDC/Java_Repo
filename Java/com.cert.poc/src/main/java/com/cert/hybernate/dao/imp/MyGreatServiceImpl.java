/*package com.cert.hybernate.dao.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cert.hybernate.dao.MyGreatDao;

@Repository("myGreatService")  
@Transactional(rollbackFor = Exception.class)  
public class MyGreatServiceImpl implements MyGreatService {  
     private MyGreatDao myGreatDao;  
     public MyGreatDao getMyGreatDao(){  
          return myGreatDao;  
     }  
     public void setMyGreatDao(MyGreatDao mg){  
          this.myGreatDao = mg;  
     }  
     @Override  
     public readOnlyMethod(long id){  
    	 
     }  
     @Override  
     @Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
     public readWriteMethod(MYGreatVO myVO){  
     
     }  
} */