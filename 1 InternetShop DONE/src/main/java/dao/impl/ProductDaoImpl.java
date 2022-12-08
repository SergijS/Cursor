package dao.impl;

import dao.ProductDao;
import model.Product;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ProductDaoImpl implements ProductDao {
    private final Map<String, Product> productMap = new TreeMap<>();

    public ProductDaoImpl() {
        add(new Product("SUZUKI", 720121.80, 5));
        add(new Product("AUDI", 2354787.34, 3));
        add(new Product("BMW", 3500454.85, 4));
        add(new Product("TESLA", 2532125.65, 3));
        add(new Product("TOYOTA", 2854624.14, 2));
        add(new Product("FORD", 780654.74, 10));
        add(new Product("MERCEDES", 3565421.57, 1));
        add(new Product("FERRARI", 3854754.23, 1));
        add(new Product("MASERATI", 4125454.71, 1));
        add(new Product("RENO", 521457.25, 15));

    }

    @Override
    public Optional<Product> add(Product product) {
        return Optional.ofNullable(productMap.put(product.getName(), product));
    }

    @Override
    public Optional<Product> getByName(String name) {
        return Optional.ofNullable(productMap.get(name));
    }

    @Override
    public Optional<Product> delete(String name) {
        return Optional.ofNullable(productMap.remove(name));
    }

    @Override
    public Map<String, Product> getAllProducts() {
        return new TreeMap<>(productMap);
    }

    @Override
    public Optional<Product> update(String name, Product newProduct) {
        Optional<Product> deleteProduct = delete(name);
        if (deleteProduct.isPresent()) {
            add(newProduct);
        }
        return deleteProduct;
    }
}