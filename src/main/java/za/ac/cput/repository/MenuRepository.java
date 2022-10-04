/**
 * MenuRepository.java
 * Menu Repository class in Restaurant System
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 09 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Menu;

import java.util.HashSet;
import java.util.Set;

public class MenuRepository implements IMenuRepository{

    private static MenuRepository menuRepository = null;
    private Set<Menu> menuDB = null;

    private MenuRepository(){
        menuDB = new HashSet<Menu>();
    }
    public static MenuRepository getMenuRepository(){
        if (menuRepository == null){
            menuRepository = new MenuRepository();
        }
        return menuRepository;
    }

    //adding create method
    @Override
    public Menu create (Menu menuItem){
        boolean success = menuDB.add(menuItem);
        if (!success)
            return null;
        return menuItem;
    }

    //adding read method
    @Override
    public Menu read (String menuId){
        Menu menu = menuDB.stream()
                .filter(m -> m.getMenuItem().equals(m.getMenuItem()))
                .findAny()
                .orElse(null);
        return menu;
    }

    //adding update method
    @Override
    public Menu update(Menu menuItem){
        Menu oldMenuItem = read(menuItem.getMenuItem());
        if (oldMenuItem != null){
            menuDB.remove(oldMenuItem);
            menuDB.add(menuItem);
            return menuItem;
        }
        return null;
    }

    //adding delete method
    @Override
    public boolean delete(String menuItem){
        Menu menuItemToDelete = read((menuItem));
        if (menuItemToDelete == null)
            return false;
        menuDB.remove(menuItemToDelete);
        return true;
    }

    //adding get all method
    @Override
    public Set<Menu> getAll(){
        return menuDB;
    }
}