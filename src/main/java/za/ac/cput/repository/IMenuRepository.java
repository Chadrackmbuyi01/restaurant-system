/**
 * IMenuRepository.java
 * Menu Repository Interface for Menu Repository in Restaurant System
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 09 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Menu;

import java.util.Set;

public interface IMenuRepository extends IRepository <Menu, String> {
    public Set<Menu> getAll();
}
