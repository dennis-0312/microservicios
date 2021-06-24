package academy.digitallab.store.product.service;

import academy.digitallab.store.product.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public List<Category> findByAll();
    public Category save(Category category);
}
