package Mediator;

import Controller.CategoryController;
import Model.Category;

public class ControllerMediator implements IControllerMediator {
    private final CategoryController categoryController;

    public ControllerMediator(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public Category getCategoryById(int id) {
        return this.categoryController.getById(id);
    }
}
