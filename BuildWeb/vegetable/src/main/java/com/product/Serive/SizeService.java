package com.product.Serive;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.product.dao.IProductDao;
import com.product.dao.ISizeDao;
import com.product.entity.Product;
@SessionScope// Name: scopeTarget.cartService
@Service
public class SizeService {
	@Autowired
	ISizeDao sizeDao;
	@Autowired
	IProductDao productDao;

	private Map<Integer, Product> mapProduct = new HashMap<Integer, Product>(); 
	Product product = null;
	
	public void add(Integer  id, Integer sizeId) {		
		Product p = mapProduct.get(id);
		if(p == null) {
			p = productDao.findById(id);
			if(sizeId == 1) {
				p.setSizes("Small");
				mapProduct.put(id,  p);
				
			}	
		}else if(mapProduct.size() > 0) {
			switch (sizeId) {
			case 1:
				String nameS = "Small";
				checkSize(id,nameS);
				break;
			case 2:
				String nameM = "Medium";
				checkSize(id,nameM);
				break;
			case 3:
				String nameL = "Large";
				checkSize(id,nameL);
				product.setSizes("Large");
				break;
			case 5:
				String nameE = "Extra Large";
				checkSize(id,nameE);				
				break;
			}			
			 
		}
	}
	public void checkSize(Integer  id, String  nameSize) {
		for (Map.Entry<Integer, Product> mproduct : mapProduct.entrySet()) {
			 if(mproduct.getKey() != id) {
				 product = productDao.findById(id);	
				 product.setSizes(nameSize);
				 mapProduct.put(id,  product);
				 break;
			 }else if(mproduct.getKey() == id && !mproduct.getValue().getSizes().equals(nameSize)){
				 product = productDao.findById(id);	
				 mapProduct.remove(mproduct.getKey());
				 product.setSizes(nameSize);
				 mapProduct.put(id,  product);
				 break;
			 }
		 }	 
	}

	
	public void clear() {
		mapProduct.clear();
	}

	public Collection<Product> getItems() {
		return mapProduct.values();
	}
	
//	if (mapProduct.size() == 0) {
//		
//		product = productDao.findById(id);
//		switch (sizeId) {
//		case 1:
//			product.setSizes("Small");
//			break;
//		case 2:
//			product.setSizes("Medium");
//			break;
//		case 3:
//			product.setSizes("Large");
//			break;
//		case 5:
//			product.setSizes("Extra Large");
//			break;
//		}			
//		mapProduct.put(id,  product);
//	} 

}
