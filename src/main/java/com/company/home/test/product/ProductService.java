package com.company.home.test.product;


import java.util.List;

import com.company.home.test.product.option.ProductOptionDAO;
import com.company.home.test.product.option.ProductOptionDTO;


public class ProductService {
	//강한 결합도
	private ProductDAO productDAO;
	private ProductOptionDAO productOptionDAO;
	
	public ProductService() {
		
		this.productDAO = new ProductDAO();
		this.productOptionDAO = new ProductOptionDAO();
		
	}
	
	public int setAddProduct(ProductDTO productDTO,List<ProductOptionDTO> ar) throws Exception{
		//product테이블에 상품등록 및 옵션 등록
		int productNum = productDAO.getProductNum().intValue();
		productDTO.setPro_num(productNum);
		int result = productDAO.addProduct(productDTO);
		
		for(ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setOption_num(productNum);
			result = productOptionDAO.addProductOption(productOptionDTO);
		}
		return result;
	}
	
	public List<ProductDTO> getProductList() throws Exception{
		return productDAO.getProduct();
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	
	//약한 결합도
	public void setProductOptionDAO(ProductOptionDAO productOptionDAO) {
		this.productOptionDAO = productOptionDAO;
	}
	
	public int addProductOption(ProductOptionDTO productOptionDTO, List<ProductOptionDTO> listOption) throws Exception{
		
		int productNum = productOptionDAO.getMax();
		
		productOptionDTO.setPro_num(productNum);
		
		int result = productOptionDAO.addProductOption(productOptionDTO);
		
		for(ProductOptionDTO OptionDTO : listOption) {
			OptionDTO.setPro_num(productNum);
			result = productOptionDAO.addProductOption(OptionDTO);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		ProductDTO productDTO = new ProductDTO();
		ProductDAO productDAO = new ProductDAO();
		
		ProductOptionDTO productoptionDTO = new ProductOptionDTO();
		ProductOptionDAO productoptionDAO = new ProductOptionDAO();
		
		productDTO.setPro_num(null);
		productDTO.setPro_introduce(null);
		productDTO.setRating(null);
		productDTO.setTag(null);
		productDTO.setPro_name(null);
		
		try {
			productDAO.addProduct(productDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productoptionDTO.setOption_num(null);
		productoptionDTO.setPro_num(null);
		productoptionDTO.setOption_name(null);
		productoptionDTO.setOption_price(null);
		productoptionDTO.setOption_stock(null);
		
		
		
	}
}
