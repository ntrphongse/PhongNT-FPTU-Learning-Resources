/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Base.Animal;

/**
 *
 * @author Hp
 */
public interface I_Process {
    boolean add(Animal x);
    
    Animal update(int id); // Tra ve dia chi cua object da sua
    Animal Delete(int id); // Tra ve dia chi cua object vua xoa
    Animal find(int id);    // Tra ve dia chi object trung id
    void SortByColor();
}
