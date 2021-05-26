package com.chainsys.product.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.chainsys.product.model.Product;

public class ProductDAOImpl implements ProductDAO {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Product> productSet;

	public ProductDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "apps", "apps");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Product> findAll() {
		try {
			pstmt = con.prepareStatement("select * from product_2593");
			rs = pstmt.executeQuery();
			productSet = new HashSet<>();
			while (rs.next()) {
				Product product = new Product(rs.getInt("p_id"), rs.getString("p_name"),
						rs.getDate("p_expiry_date").toLocalDate());
				productSet.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productSet;
	}

	@Override
	public Product findById(int p_id) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2593 where p_id=?");
			pstmt.setInt(1, p_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("p_id"), rs.getString("p_name"), rs.getDate("p_expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void save(Product product_2593) {
		try {
			pstmt = con.prepareStatement("insert into product_2593 values(?,?,?)");
			pstmt.setInt(1, product_2593.getId());
			pstmt.setString(2, product_2593.getName());
			pstmt.setDate(3, Date.valueOf(product_2593.getExpiryDate()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Product product_2593) {
		try {
			pstmt = con.prepareStatement("update product_2593 set p_name=? where p_id=?");
			pstmt.setString(1, product_2593.getName());
			pstmt.setInt(2, product_2593.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int p_id) {
		try {
			pstmt = con.prepareStatement("delete product_2593 where p_id=?");
			pstmt.setInt(1, p_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public Product findByName(String name) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2593 where p_name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("p_id"), rs.getString("p_name"), rs.getDate("p_expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}	
}
