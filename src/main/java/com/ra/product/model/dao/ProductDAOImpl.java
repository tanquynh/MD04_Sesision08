package com.ra.product.model.dao;

import com.ra.product.model.entity.Product;
import com.ra.product.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IGenericDAO<Product, Integer> {
    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("productId"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductPrice(resultSet.getDouble("productPrice"));
                product.setProductDescription(resultSet.getString("productDescription"));
                product.setProductStatus(resultSet.getBoolean("productStatus"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = ConnectionDB.getConnection();
        try {
            String query = "insert into products(productName, productPrice, productDescription, productStatus) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            preparedStatement.setString(3, product.getProductDescription());
            preparedStatement.setBoolean(4, product.isProductStatus());
            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Product getById(Integer productId) {
        Product product = new Product();
        Connection connection = ConnectionDB.getConnection();

        try {
            String query = "select * from products where productId";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setProductId(resultSet.getInt("productId"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductPrice(resultSet.getDouble("productPrice"));
                product.setProductDescription(resultSet.getString("productDescription"));
                product.setProductStatus(resultSet.getBoolean("productStatus"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return product;
    }

    @Override
    public boolean update(Product product, Integer productId) {
        Connection connection = ConnectionDB.getConnection();

        try {
            String query = "update products set productName = ?, productPrice = ?, productDescription = ?, productStatus = ? where productId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            preparedStatement.setString(3, product.getProductDescription());
            preparedStatement.setBoolean(4, product.isProductStatus());
            preparedStatement.setInt(5, productId);
            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delete(Integer productId) {
        Connection connection = ConnectionDB.getConnection();
        try {
            String query = "delete from products where productId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }
}
