package com.company.home.test.product.option;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.home.util.DBconnection;

public class ProductOptionDAO {
	//getPro_num
	public int getPro_num(String pro_name) throws Exception{
		Connection con = DBconnection.getConnection();
		String sql = "SELECT PRO_NUM FROM PRODUCT WHERE PRO_NAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pro_name);
		
		ResultSet rs = ps.executeQuery();
		
		int result = 0;
		
		if(rs.next()) {
			result = rs.getInt("PRO_NUM");
		}
		return result;
	}
	
	//getMax
	public int getMax() throws Exception{
		Connection con = DBconnection.getConnection();
		String sql = "SELECT MAX(PRO_NUM) FROM PRODUCT";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		int result = 0;
		
		if(rs.next()) {
			result = rs.getInt("MAX(PRO_NUM)");
		}
		return result;
	}
	
	public List<ProductOptionDTO> getProductOption() throws Exception{
		
		ArrayList<ProductOptionDTO> arDTO = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBconnection.getConnection();
		String sql = "SELECT PRO_NUM, OPTION_NUM, OPTION_NAME,"
				+ " OPTION_PRICE, OPTION_STOCK FROM PRODUCT_OPTION";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO opDTO = new ProductOptionDTO();
			opDTO.setPro_num(rs.getInt("PRO_NUM"));
			opDTO.setOption_num(rs.getInt("OPTION_NUM"));
			opDTO.setOption_name(rs.getString("OPTION_NAME"));
			opDTO.setOption_price(rs.getInt("OPTION_PRICE"));
			opDTO.setOption_stock(rs.getInt("OPTION_STOCK"));
			
			arDTO.add(opDTO);
		}
		
		DBconnection.disconnection(con, ps, rs);
		
		return arDTO;
	}
	
	public int addProductOption(ProductOptionDTO poDTO) throws Exception{
		Connection con = DBconnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT_OPTION"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, poDTO.getOption_num());
		ps.setInt(2, poDTO.getPro_num());
		ps.setString(3, poDTO.getOption_name());
		ps.setInt(4, poDTO.getOption_price());
		ps.setInt(5, poDTO.getOption_stock());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	public static void main(String[] args) {
		ProductOptionDAO poDAO = new ProductOptionDAO();
//		int testresult;
//		try {
//			int result = poDAO.getMax();
//			System.out.println(result);
//			ProductOptionDTO poDTO = new ProductOptionDTO();
//			
//			poDTO.setOption_num(1);
//			poDTO.setPro_num(result);
//			poDTO.setOption_name("TEST1");
//			poDTO.setOption_price(1000);
//			poDTO.setOption_stock(50);
//			
//			testresult = poDAO.addProductOption(poDTO);
//			System.out.println(testresult == 1);
//			
//			ProductOptionDTO poDTO2 = new ProductOptionDTO();
//			
//			poDTO2.setOption_num(2);
//			poDTO2.setPro_num(result);
//			poDTO2.setOption_name("TEST2");
//			poDTO2.setOption_price(1000);
//			poDTO2.setOption_stock(50);
//			
//			testresult = poDAO.addProductOption(poDTO2);
//			System.out.println(testresult == 1);
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		try {
			List<ProductOptionDTO> arDTO = poDAO.getProductOption();
			System.out.println(arDTO.size() > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
