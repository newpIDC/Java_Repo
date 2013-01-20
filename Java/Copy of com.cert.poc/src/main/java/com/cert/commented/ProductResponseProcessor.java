package com.cert.commented;
/*package com.cert.dao;

import org.springframework.batch.item.ItemProcessor;

import com.wellsfargo.lbs.tmplegacyadaptercore.dao.ResponseFileJobDAO;
import com.wellsfargo.lbs.tmplegacyadaptercore.model.ProductResponse;


*//**
 * @author A171936
 *
 *//*
public class ProductResponseProcessor implements ItemProcessor<ProductResponse, ProductResponse> {
	public ProductResponse process(ProductResponse response) throws Exception {
		if (response == null){
			return null;
		} else{
			//Updating Product Response status to SENT
			ResponseFileJobDAO responseFileJobDAO = new ResponseFileJobDAO();
			responseFileJobDAO.updateProductResponse(response.getProductResponseId().toString());
		}
		return response;
	}
}
*/