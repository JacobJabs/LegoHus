/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author J.Jabr
 */
public class Order {
    
    public Order(int id, int length, int width, int height) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        
    }
    
    public Order(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    private int id, length, width, height;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
}
