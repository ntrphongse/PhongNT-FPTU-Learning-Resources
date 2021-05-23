/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonemanager;

/**
 *
 * @author Hp
 */
public class Phone {
    private String name;
    private String model;
    private PIN pin;
    
    // Tao INNER / NESTED CLASS
    class PIN {
        private int hour;

        public PIN(int hour) {
            this.hour = hour;
        }

        public PIN() {
            hour = 5;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        @Override
        public String toString() {
            return "PIN {" + "hour = " + hour + "}";
        }
    }

    public Phone(String name, String model, int hour) {
        this.name = name;
        this.model = model;
        this.pin = new PIN(hour);
    }

    public Phone() {
        name = "";
        model = "";
        pin = new PIN(); // Khong co lenh nay ==> Bai bi hu (LOI RUN-TIME: NullPointerException)
    }

    @Override
    public String toString() {
        return "Phone {name = " + name + ", model = " + model + ", PIN = " + pin;
    }
    
    void xuat()
    {
        System.out.println("Name: " + name);
        System.out.println("Model: " + model);
        System.out.println("Hour: " + pin.getHour());
    }
}
